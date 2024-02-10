package com.example.diaryapp.presentation.google

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Stable
class GoogleSignInState(open: Boolean = false) {
    var opened by mutableStateOf(open)
        private set

    fun open() {
        opened = true
    }

    fun close() {
        opened = false
    }
}

@Composable
fun rememberGoogleSignInState(): GoogleSignInState {
    return rememberSaveable(
        saver = GoogleSignInStateSaver
    ) { GoogleSignInState() }
}

private val GoogleSignInStateSaver: Saver<GoogleSignInState, Boolean> = Saver(
    save = { state -> state.opened },
    restore = { opened -> GoogleSignInState(open = opened) },
)