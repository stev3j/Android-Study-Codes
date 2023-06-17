package com.example.androidstudycodes.login_practice.domain.model

import com.example.androidstudycodes.login_practice.data.mapper.toEntity

data class Login(
    val result: String,
    val accessToken: String,
    val refreshToken: String
)
