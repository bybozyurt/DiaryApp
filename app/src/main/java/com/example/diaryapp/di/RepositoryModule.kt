package com.example.diaryapp.di

import com.example.diaryapp.data.repository.impl.AuthRepositoryImpl
import com.example.diaryapp.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(): AuthRepository = AuthRepositoryImpl()
}