package com.example.diaryapp.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.diaryapp.R
import com.example.diaryapp.common.UiText
import com.example.diaryapp.common.extension.launchInIo
import com.example.diaryapp.common.extension.onError
import com.example.diaryapp.common.extension.onSuccess
import com.example.diaryapp.domain.usecase.LogOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val logOutUseCase: LogOutUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun logOut() {
        showLoading()
        launchInIo {
            logOutUseCase.invoke()
                .onSuccess { updateState(isLoggedOut = true) }
                .onError { updateState(isLoggedOut = false) }
        }
    }

    private fun showLoading() {
        _uiState.update { state ->
            state.copy(
                isLoading = true
            )
        }
    }

    private fun updateState(isLoggedOut: Boolean) {
        _uiState.update { state ->
            state.copy(
                isLoading = false,
                isLoggedOut = isLoggedOut
            )
        }
    }

}