package com.example.diaryapp.presentation.screens.home

import com.example.diaryapp.common.UiText

data class HomeUiState(
    val isLoading: Boolean = false,
    val errorMessage: UiText = UiText.Default,
    val successMessage: UiText = UiText.Default
)