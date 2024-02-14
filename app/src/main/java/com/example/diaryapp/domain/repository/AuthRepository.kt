package com.example.diaryapp.domain.repository

import com.example.diaryapp.common.AppResource
import io.realm.kotlin.mongodb.App

interface AuthRepository {

    suspend fun loginWithGoogle(
        tokenId: String
    ): AppResource<Boolean?>

    suspend fun logout(): AppResource<Unit?>

    fun getMongoDbApp(): App

}