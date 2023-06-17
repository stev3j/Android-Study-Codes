package com.example.androidstudycodes.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var count = 0
    private var _countText = MutableLiveData<String>().apply { value = "Hello, ${count++}" }
    val countText : LiveData<String> = _countText

    fun plusValue() {
        _countText.value = "Hello, ${count++}"
    }
}