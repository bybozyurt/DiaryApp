package com.example.diaryapp.presentation.screens.auth

import androidx.compose.runtime.Stable
import com.example.diaryapp.R
import com.example.diaryapp.common.UiText

@Stable
data class AuthUiState(
    val uiText: UiText = UiText.Default,
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val isLoggedIn: Boolean = false
) {
    companion object {
        fun getLoginFailState(): AuthUiState {
            return AuthUiState(
                uiText = UiText.StringResource(R.string.login_fail),
                isError = true,
                isLoading = false,
                isLoggedIn = false
            )
        }
    }
}