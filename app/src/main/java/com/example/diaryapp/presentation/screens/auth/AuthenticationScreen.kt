package com.example.diaryapp.presentation.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.diaryapp.presentation.google.GoogleSignInState
import com.example.diaryapp.presentation.google.SignInWithGoogle
import com.example.diaryapp.common.onDialogDismissed
import com.example.diaryapp.common.onTokenIdReceived
import com.example.diaryapp.presentation.google.rememberGoogleSignInState
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarState

@Composable
fun AuthenticationScreen(
    state: GoogleSignInState = rememberGoogleSignInState(),
    messageBarState: MessageBarState,
    isLoading: Boolean,
    onTokenIdReceived: onTokenIdReceived,
    onDialogDismissed: onDialogDismissed
) {
    Scaffold(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .statusBarsPadding()
            .navigationBarsPadding()
    ) { paddingValues ->
        ContentWithMessageBar(
            messageBarState = messageBarState,
            showToastOnCopy = false,
            successContainerColor = Color.Green.copy(alpha = 0.7f),
            errorContainerColor = Color.Red.copy(alpha = 0.5f)
        ) {
            AuthenticationContent(
                paddingValues = paddingValues,
                onClick = {
                    state.open()
                },
                isLoading = isLoading
            )
        }
    }

    SignInWithGoogle(
        state = state,
        onTokenIdReceived = { token ->
            onTokenIdReceived(token)
        },
        onDialogDismissed = { errorMessage ->
            onDialogDismissed(errorMessage)
        }
    )
}