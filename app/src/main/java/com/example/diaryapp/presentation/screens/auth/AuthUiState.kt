package com.example.diaryapp.presentation.screens.auth

import androidx.compose.runtime.Stable
import com.example.diaryapp.R
import com.example.diaryapp.common.UiText

@Stable
data class AuthUiState(
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false
) {
    companion object {
        fun getLoginFailState(): AuthUiState {
            return AuthUiState(
                isError = true,
                isLoading = false,
                isLoggedIn = false
            )
        }
    }
}