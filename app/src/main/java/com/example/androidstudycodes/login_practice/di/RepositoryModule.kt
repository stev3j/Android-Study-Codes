package com.example.androidstudycodes.login_practice.di

import com.example.androidstudycodes.login_practice.data.network.api.AuthApi
import com.example.androidstudycodes.login_practice.data.repository.AuthRepositoryImpl
import com.example.androidstudycodes.login_practice.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        api: AuthApi
    ): AuthRepository {
        return AuthRepositoryImpl(api)
    }

}