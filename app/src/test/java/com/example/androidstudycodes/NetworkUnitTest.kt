package com.example.androidstudycodes

import com.example.androidstudycodes.login_practice.data.network.api.AuthApi
import com.example.androidstudycodes.login_practice.data.repository.AuthRepositoryImpl
import com.example.androidstudycodes.login_practice.domain.model.LoginDto
import dagger.hilt.android.AndroidEntryPoint
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

//@AndroidEntryPoint
class NetworkUnitTest {

//    @Inject
//    private lateinit var authApi: AuthApi
//    private lateinit var authRepository: AuthRepositoryImpl

//    @Before
//    fun init() {
//        authRepository = AuthRepositoryImpl(authApi)
//    }

    private fun testFun(a: Int, b: Int) {
        println(a+b)
    }

    @Test
    fun login(loginDto: LoginDto) {
        kotlin.runCatching {
//            authRepository.login(loginDto)
            testFun(1, 2)
        }.onSuccess {
            println("Login Success!")
        }.onFailure {
            println("Login Failed..")
        }
    }

}

