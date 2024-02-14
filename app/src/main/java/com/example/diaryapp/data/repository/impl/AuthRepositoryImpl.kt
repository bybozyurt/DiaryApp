package com.example.diaryapp.data.repository.impl

import com.example.diaryapp.common.AppResource
import com.example.diaryapp.common.Constants
import com.example.diaryapp.data.base.BaseRepository
import com.example.diaryapp.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import io.realm.kotlin.mongodb.App
import io.realm.kotlin.mongodb.Credentials

@ViewModelScoped
class AuthRepositoryImpl: AuthRepository, BaseRepository() {

    override suspend fun loginWithGoogle(tokenId: String): AppResource<Boolean?> {
        return safeApiCall {
            getMongoDbApp().login(
                Credentials.jwt(tokenId)
            ).loggedIn
        }
    }

    override suspend fun logout(): AppResource<Unit?> {
        return safeApiCall {
            getMongoDbApp().currentUser?.logOut()
        }
    }

    override fun getMongoDbApp(): App {
        return App.Companion.create(Constants.appId)
    }
}