package com.example.androidstudycodes.login_practice.domain.repository

import android.media.session.MediaSession
import com.example.androidstudycodes.login_practice.domain.model.Login
import com.example.androidstudycodes.login_practice.domain.model.LoginDto
import com.example.androidstudycodes.login_practice.domain.model.RefreshToken
import com.example.androidstudycodes.login_practice.domain.model.Token
import com.example.androidstudycodes.login_practice.domain.model.TokenDto

interface AuthRepository {

    suspend fun login(
        loginDto: LoginDto
    ): Login

    suspend fun refreshToken(
    ): RefreshToken

    suspend fun token(
        tokenDto: TokenDto
    ): Token

//    suspend fun register(
//        registerDto: RegisterDto
//    )

//    suspend fun getUser(
//    ): User

}