package com.example.diaryapp.presentation.screens.auth

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.diaryapp.presentation.google.GoogleSignInState
import com.example.diaryapp.presentation.google.SignInWithGoogle
import com.example.diaryapp.common.onButtonClicked
import com.example.diaryapp.common.onDialogDismissed
import com.example.diaryapp.common.onTokenIdReceived
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarState

@Composable
fun AuthenticationScreen(
    state: GoogleSignInState,
    messageBarState: MessageBarState,
    isLoading: Boolean,
    onTokenIdReceived: onTokenIdReceived,
    onDialogDismissed: onDialogDismissed
) {
    Scaffold { paddingValues ->
        ContentWithMessageBar(
            messageBarState = messageBarState,
            showToastOnCopy = false
        ) {
            AuthenticationContent(
                paddingValues = paddingValues,
                onButtonClicked = {
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