package com.example.diaryapp.presentation.screens.auth

import androidx.lifecycle.ViewModel
import com.example.diaryapp.R
import com.example.diaryapp.common.UiText
import com.example.diaryapp.common.extension.launchInIo
import com.example.diaryapp.common.extension.onError
import com.example.diaryapp.common.extension.onSuccess
import com.example.diaryapp.domain.usecase.LoginWithGoogleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val loginWithGoogleUseCase: LoginWithGoogleUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState = _uiState.asStateFlow()

    fun loginWithGoogle(tokenId: String) {
        showLoading()
        launchInIo {
            loginWithGoogleUseCase.invoke(tokenId).onSuccess { isSuccess ->
                if (isSuccess == false) {
                    setUiState(AuthUiState.getLoginFailState())
                    return@onSuccess
                }
                setUiState(
                    AuthUiState(
                        isError = false,
                        uiText = UiText.StringResource(R.string.login_success),
                        isLoggedIn = true
                    )
                )
            }.onError {
                setUiState(AuthUiState.getLoginFailState())
            }
        }
    }

    fun setUiState(authUiState: AuthUiState) {
        _uiState.update {
            authUiState
        }
    }

    fun consumeMessage() {
       _uiState.update { state ->
            state.copy(
                uiText = UiText.Default,
                isLoading = false
            )
        }
    }

    private fun showLoading() {
        _uiState.update { state ->
            state.copy(isLoading = true)
        }
    }
}