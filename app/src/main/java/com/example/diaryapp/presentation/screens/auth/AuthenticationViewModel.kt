package com.example.diaryapp.presentation.screens.auth

import androidx.lifecycle.ViewModel
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
        setLoading(true)
        launchInIo {
            loginWithGoogleUseCase.invoke(tokenId).onSuccess {
                setMessage(
                    isError = false,
                    message = "Login Successful"
                )
            }.onError {
                setMessage(
                    isError = true,
                    message = "Login Failed"
                )
            }
        }
    }

    fun setLoading(isLoading: Boolean) {
        _uiState.update { state ->
            state.copy(isLoading = isLoading)
        }
    }

    fun setMessage(isError: Boolean, message: String) {
        _uiState.update { state ->
            state.copy(
                isError = isError,
                message = message
            )
        }
    }

    fun consumeMessage() {
       _uiState.update { state ->
            state.copy(
                message = "",
                isLoading = false
            )
        }
    }
}