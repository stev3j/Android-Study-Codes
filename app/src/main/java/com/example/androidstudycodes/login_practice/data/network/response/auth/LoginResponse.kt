package com.example.androidstudycodes.login_practice.data.network.response.auth


data class LoginResponse(
    val result: String,
    val accessToken: String,
    val refreshToken: String
)