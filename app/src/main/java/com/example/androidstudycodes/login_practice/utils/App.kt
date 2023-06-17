package com.example.androidstudycodes.login_practice.utils

import android.app.Application
import com.example.androidstudycodes.login_practice.data.database.PreferenceManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    // 가장 먼저 실행시키기 위해 Application() 안에 prefs 를 넣는다.
    companion object {
        lateinit var prefs: PreferenceManager
    }

    override fun onCreate() {
        prefs = PreferenceManager(applicationContext)
        super.onCreate()
    }

}