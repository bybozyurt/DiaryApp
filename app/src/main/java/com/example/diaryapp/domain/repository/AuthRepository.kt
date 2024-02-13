package com.example.diaryapp.domain.repository

import com.example.diaryapp.common.AppResource

interface AuthRepository {

    suspend fun loginWithGoogle(
        tokenId: String
    ): AppResource<Boolean?>

}