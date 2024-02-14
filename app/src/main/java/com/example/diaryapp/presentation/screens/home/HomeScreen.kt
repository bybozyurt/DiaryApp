package com.example.diaryapp.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.diaryapp.common.onClick
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarState

@Composable
fun HomeScreen(
    isLoading: Boolean,
    messageBarState: MessageBarState,
    onLogoutClick: onClick,
) {
    Scaffold {
        ContentWithMessageBar(messageBarState = messageBarState) {
            HomeScreenContent(
                modifier = Modifier.padding(it),
                isLoading = isLoading,
                onLogOutClick = onLogoutClick
            )
        }
    }
}