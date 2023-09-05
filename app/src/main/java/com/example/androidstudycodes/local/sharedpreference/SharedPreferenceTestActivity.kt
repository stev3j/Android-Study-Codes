package com.example.androidstudycodes.local.sharedpreference

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidstudycodes.R
import com.example.androidstudycodes.databinding.ActivitySharedPreferenceTestBinding

class SharedPreferenceTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference_test)

        val etInput = findViewById<EditText>(R.id.et_input)
        val btnSave = findViewById<Button>(R.id.btn_save)
        val btnGet = findViewById<Button>(R.id.btn_get)

        btnSave.setOnClickListener {
            val sharedPreference = getSharedPreferences("test", MODE_PRIVATE)
            val preference = getPreferences(MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            val etText = etInput.text.toString()
            editor.putString("str1", etText)
            editor.apply()
            toastMakeText("Text Saved!!")

            editor.remove("str1")
            editor.clear()
        }

        btnGet.setOnClickListener {
            val sharedPreference = getSharedPreferences("test", MODE_PRIVATE)
            val str1 = sharedPreference.getString("str1", "")
            toastMakeText("Text : $str1")
        }
    }

    private fun toastMakeText(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val TAG = "SharedPreferenceTestActivity"
    }
}