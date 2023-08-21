package com.example.androidstudycodes.login_practice.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.androidstudycodes.R
import com.example.androidstudycodes.databinding.ActivityAuthBinding
import com.example.androidstudycodes.login_practice.domain.model.LoginDto
import com.example.androidstudycodes.login_practice.domain.model.TokenDto
import com.example.androidstudycodes.login_practice.utils.App
import com.example.androidstudycodes.login_practice.utils.repeatOnStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : AppCompatActivity() {

    private val binding : ActivityAuthBinding by lazy { ActivityAuthBinding.inflate(layoutInflater) }
    private lateinit var viewModel : AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[AuthViewModel::class.java]

        if (App.prefs.accessToken.isEmpty().not()) {
            startActivity(Intent(AuthActivity(), AuthSuccessActivity::class.java))
            finish()
        }

        repeatOnStarted { viewModel.eventFlow.collect { event -> handleEvent(event) } }

        binding.btnLogin.setOnClickListener {
            viewModel.login(
                LoginDto(
                    binding.etId.text.toString(),
                    binding.etPwd.text.toString(),
                )
            )
        }

    }

    private fun handleEvent(event: AuthViewModel.Event): Any =
        when (event) {
            is AuthViewModel.Event.SuccessLogin -> {
                // Todo : ?
                viewModel.token(TokenDto(event.code.accessToken))
            }
            is AuthViewModel.Event.SuccessToken -> {
                startActivity(Intent(AuthActivity(), AuthSuccessActivity::class.java))
                finish()
            }
            is AuthViewModel.Event.UnkownException -> shortToast("알 수 없는 오류가 발생했습니다.")
        }

    private fun shortToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}