package com.example.diaryapp.presentation.screens.auth

data class AuthUiState(
    val message: String = "",
    val isError: Boolean = false,
    val isLoading: Boolean = false
)