package com.example.androidstudycodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.androidstudycodes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // tvCount가 바뀔 때마다 tvCount.text를 tvCount로 변환시킴
        viewModel.countText.observe(this) { countText ->
            binding.tvCount.text = countText
        }

        binding.btnPlus.setOnClickListener {
            viewModel.plusValue()
        }
    }
}