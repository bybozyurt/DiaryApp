package com.example.diaryapp.data.repository.impl

import com.example.diaryapp.common.AppResource
import com.example.diaryapp.common.Constants
import com.example.diaryapp.data.base.BaseRepository
import com.example.diaryapp.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials
import io.realm.kotlin.mongodb.GoogleAuthType

@ViewModelScoped
class AuthRepositoryImpl: AuthRepository, BaseRepository() {

    override suspend fun loginWithGoogle(tokenId: String): AppResource<Boolean?> {
        return safeApiCall {
            App.create(Constants.appId).login(
                Credentials.google(tokenId, GoogleAuthType.ID_TOKEN)
            ).loggedIn
        }
    }

}