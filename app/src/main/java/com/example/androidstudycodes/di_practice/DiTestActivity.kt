package com.example.androidstudycodes.di_practice

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.androidstudycodes.R

//@AndroidEntryPoint
class DiTestActivity : AppCompatActivity() {

    private val TAG = "DI Test"

//    @Inject
    lateinit var testString: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_di_test)

//        Log.d(TAG, testString)
        println(testString)
    }
}