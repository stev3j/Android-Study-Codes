package com.example.androidstudycodes.login_practice.data.repository

import android.util.Log
import com.example.androidstudycodes.login_practice.data.mapper.toEntity
import com.example.androidstudycodes.login_practice.data.mapper.toModel
import com.example.androidstudycodes.login_practice.data.network.api.AuthApi
import com.example.androidstudycodes.login_practice.domain.model.Login
import com.example.androidstudycodes.login_practice.domain.model.LoginDto
import com.example.androidstudycodes.login_practice.domain.model.RefreshToken
import com.example.androidstudycodes.login_practice.domain.model.Token
import com.example.androidstudycodes.login_practice.domain.model.TokenDto
import com.example.androidstudycodes.login_practice.domain.repository.AuthRepository
//import javax.inject.Inject

// 필요한 함수들 + 서버에서 받아온 값을 가공

class AuthRepositoryImpl constructor(
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun login(loginDto: LoginDto): Login =
        authApi.login(loginDto.toModel()).data.toEntity()

    override suspend fun refreshToken(): RefreshToken =
        authApi.refreshToken().data.toEntity()

    override suspend fun token(tokenDto: TokenDto): Token =
        authApi.token(tokenDto.toModel()).data.toEntity()

//    override suspend fun register(registerDto: RegisterDto) =
//        authApi.register(registerDto.toModel()).data
//
//    override suspend fun getUser(): User =
//        authApi.getProfile().data.toEntity()

}
