package com.example.androidstudycodes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.androidstudycodes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val tvCount = MutableLiveData<String>().apply { value = "Hello, ${count++}" }
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // tvCount가 바뀔 때마다 tvCount.text를 tvCount로 변환시킴
        tvCount.observe(this) { tvCount ->
            binding.tvCount.text = tvCount
        }

        binding.btnPlus.setOnClickListener {
            tvCount.value = "Hello, ${count++}"
        }
    }
}