package com.example.diaryapp.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.diaryapp.common.onClick
import com.example.diaryapp.presentation.screens.home.components.HomeFab
import com.example.diaryapp.presentation.screens.home.components.ToolbarWithMenu
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.rememberMessageBarState

@Composable
fun HomeScreen(
    isLoading: Boolean,
    isInitial: Boolean,
    onLogoutClick: onClick,
) {
    val messageBarState = rememberMessageBarState()
    LaunchedEffect(key1 = isInitial) {
        if (isInitial) {
            messageBarState.addSuccess("You signed in successfully!")
        }
    }

    ContentWithMessageBar(messageBarState = messageBarState) {
        Scaffold(
            topBar = { ToolbarWithMenu(onLogoutClick = onLogoutClick) },
            floatingActionButton = { HomeFab(onClick = {}) }
        ) {
            HomeScreenContent(
                modifier = Modifier.padding(it),
                isLoading = isLoading
            )
        }
    }

}