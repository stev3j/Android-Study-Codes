package com.example.androidstudycodes

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.androidstudycodes.login_practice.data.network.api.AuthApi
import com.example.androidstudycodes.login_practice.data.network.request.LoginRequest
import com.example.androidstudycodes.login_practice.data.repository.AuthRepositoryImpl
import com.example.androidstudycodes.login_practice.di.NetworkModule
import com.example.androidstudycodes.login_practice.domain.model.Login
import com.example.androidstudycodes.login_practice.domain.model.LoginDto
import com.example.androidstudycodes.login_practice.domain.repository.AuthRepository
import com.example.androidstudycodes.login_practice.presentation.auth.AuthViewModel
import com.example.androidstudycodes.login_practice.utils.App
import com.example.androidstudycodes.login_practice.utils.BASE_URL
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

class NetworkUnitTest() {

    private lateinit var authRepository: AuthRepository
    private lateinit var result: Login

    @Before
    fun setupTest() {
        authRepository = AuthRepositoryImpl(provideAuthApi2(retrofit2))
    }

    // TODO: Retrofit이 하는 것은 interface로 만들어진 Api를 구체화하는 것?


    @Test
    fun loginTest() {
        runBlocking {
            launch {
                result = authRepository.login(LoginDto("a", "b"))
                println("result------------------------")
                println(result.result)
            }
        }
    }



    private val httpLoggingInterceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    private val interceptor: Interceptor = Interceptor { chain ->
        with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("Authorization", "Bearer ${App.prefs.accessToken}")
                .build()
            proceed(newRequest)
        }
    }

    private val okHttpClient = okHttpClientBuilder2(httpLoggingInterceptor, interceptor)

    private fun provideAuthApi2(retrofit: Retrofit): AuthApi =
        retrofit.create(AuthApi::class.java)

    private val retrofit2: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    private fun okHttpClientBuilder2(
        LoggerInterceptor: HttpLoggingInterceptor,
        headerInterceptor: Interceptor
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient().newBuilder()

        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(LoggerInterceptor)
        okHttpClientBuilder.addInterceptor(headerInterceptor)

        return okHttpClientBuilder.build()
    }
}
