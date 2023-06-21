package com.example.androidstudycodes.login_practice.data.mapper

import android.util.Log
import com.example.androidstudycodes.login_practice.data.network.request.LoginRequest
import com.example.androidstudycodes.login_practice.data.network.request.TokenRequest
import com.example.androidstudycodes.login_practice.data.network.response.auth.LoginResponse
import com.example.androidstudycodes.login_practice.data.network.response.auth.RefreshTokenResponse
import com.example.androidstudycodes.login_practice.data.network.response.auth.TokenResponse
import com.example.androidstudycodes.login_practice.domain.model.Login
import com.example.androidstudycodes.login_practice.domain.model.LoginDto
import com.example.androidstudycodes.login_practice.domain.model.RefreshToken
import com.example.androidstudycodes.login_practice.domain.model.Token
import com.example.androidstudycodes.login_practice.domain.model.TokenDto

// 서버와 통신하여 받아온 값들을 Domain의 Model형식으로 변환

fun LoginDto.toModel(): LoginRequest = LoginRequest(
    userId = this.userId,
    password = this.password
)

//fun RegisterDto.toModel(): RegisterRequest = RegisterRequest(
//    userId = this.userId,
//    nickname = this.nickname,
//    password = this.password,
//    grade = this.grade,
//    room = this.room,
//    number = this.number
//)

fun TokenDto.toModel(): TokenRequest = TokenRequest(
    accessToken = this.accessToken
)

fun TokenResponse.toEntity(): Token = Token(
    accessToken = this.accessToken,
    refreshToken = this.refreshToken
)

fun RefreshTokenResponse.toEntity(): RefreshToken = RefreshToken(
    accessToken = this.accessToken
)

fun LoginResponse.toEntity(): Login  = Login(
        result = this.result,
        accessToken = this.accessToken,
        refreshToken = this.refreshToken
)

//fun UserResponse.toEntity(): User = User(
//    user = this.user.toEntity(),
//    post = this.post.map { it.toEntity() }
//)
//
//fun UserInfoResponse.toEntity(): UserInfo = UserInfo(
//    userId = this.userId,
//    nickname = this.nickname,
//    grade = this.grade,
//    room = this.room,
//    number = this.number
//)