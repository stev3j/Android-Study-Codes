package com.example.androidstudycodes.login_practice.presentation.auth

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidstudycodes.login_practice.domain.model.Login
import com.example.androidstudycodes.login_practice.domain.model.LoginDto
import com.example.androidstudycodes.login_practice.domain.model.TokenDto
import com.example.androidstudycodes.login_practice.domain.repository.AuthRepository
import com.example.androidstudycodes.login_practice.utils.App
import com.example.androidstudycodes.login_practice.utils.MutableEventFlow
import com.example.androidstudycodes.login_practice.utils.asEventFlow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//@HiltViewModel
class AuthViewModel constructor(
    private val authRepository: AuthRepository
): ViewModel() {

    private val _eventFLow = MutableEventFlow<Event>()
    val eventFlow = _eventFLow.asEventFlow()

    fun login(loginDto: LoginDto) = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            authRepository.login(loginDto)
        }.onSuccess {
            event(Event.SuccessLogin(it))
        }.onFailure {
            event(Event.UnkownException)
            Log.d("error1", "${it.message}")
        }
    }

    fun token(tokenDto: TokenDto) = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            authRepository.token(tokenDto)
        }.onSuccess {
            App.prefs.accessToken = it.accessToken
            App.prefs.refreshToken = it.refreshToken
//            App.prefs.autoLogin = true
            event(Event.SuccessToken)
        }.onFailure {
            event(Event.UnkownException)
            Log.d("error2", "${it.message}")
        }
    }

    private fun event(event: Event) {
        viewModelScope.launch {
            _eventFLow.emit(event)
        }
    }

    sealed class Event {
        data class SuccessLogin(val code: Login): Event()
        object SuccessToken: Event()
        object UnkownException: Event()
    }
}