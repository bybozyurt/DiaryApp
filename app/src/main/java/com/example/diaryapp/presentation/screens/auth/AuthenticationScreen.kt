package com.example.diaryapp.presentation.screens.auth

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.diaryapp.presentation.google.GoogleSignInState
import com.example.diaryapp.presentation.google.SignInWithGoogle
import com.example.diaryapp.util.onButtonClicked

@Composable
fun AuthenticationScreen(
    state: GoogleSignInState,
    isLoading: Boolean,
    onButtonClick: onButtonClicked
) {
    Scaffold { paddingValues ->
        AuthenticationContent(
            paddingValues = paddingValues,
            onButtonClicked = onButtonClick,
            isLoading = isLoading
        )
    }

    SignInWithGoogle(
        state = state,
        onTokenIdReceived = { token ->

        },
        onDialogDismissed = { errorMessage ->
        }
    )
}