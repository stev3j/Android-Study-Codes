package com.example.androidstudycodes.login_practice.data.network.response.auth

// 받아오는 값의 형식
data class LoginResponse(
    val result: String,
    val accessToken: String,
    val refreshToken: String
)