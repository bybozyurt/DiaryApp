package com.example.diaryapp.domain.usecase

import com.example.diaryapp.common.AppResource
import com.example.diaryapp.domain.repository.AuthRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class LoginWithGoogleUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(tokenId: String) : AppResource<Boolean?>{
        return authRepository.loginWithGoogle(tokenId)
    }
}