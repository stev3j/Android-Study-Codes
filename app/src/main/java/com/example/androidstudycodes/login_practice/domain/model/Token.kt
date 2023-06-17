package com.example.androidstudycodes.login_practice.domain.model

data class Token(
    val accessToken: String,
    val refreshToken: String
)