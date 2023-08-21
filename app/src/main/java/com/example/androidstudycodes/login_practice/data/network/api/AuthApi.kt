package com.example.androidstudycodes.login_practice.data.network.api

import com.example.androidstudycodes.login_practice.data.network.request.LoginRequest
import com.example.androidstudycodes.login_practice.data.network.request.TokenRequest
import com.example.androidstudycodes.login_practice.data.network.response.Response
import com.example.androidstudycodes.login_practice.data.network.response.auth.LoginResponse
import com.example.androidstudycodes.login_practice.data.network.response.auth.RefreshTokenResponse
import com.example.androidstudycodes.login_practice.data.network.response.auth.TokenResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// 서버 통신
// 왜 인터페이스? -> 레트로핏이 구현체를 만들어주기 때문
interface AuthApi {

    @POST("login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>

    @GET("login/refreshToken")
    suspend fun refreshToken(
    ): Response<RefreshTokenResponse>

    @POST("token")
    suspend fun token(
        @Body tokenRequest: TokenRequest
    ): Response<TokenResponse>

//    @POST("auth/register")
//    suspend fun register(
//        @Body registerRequest: RegisterRequest
//    ): Response<Unit>
//
//    @GET("auth/myProfile")
//    suspend fun getProfile(
//    ): Response<UserResponse>

}