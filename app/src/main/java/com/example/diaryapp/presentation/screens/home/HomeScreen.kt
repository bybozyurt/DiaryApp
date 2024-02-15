package com.example.diaryapp.presentation.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.diaryapp.common.onClick
import com.example.diaryapp.presentation.components.icon.AppIconButton
import com.example.diaryapp.presentation.components.text.AppText
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
            topBar = { ToolbarWithMenu(onLogoutClick = onLogoutClick) }
        ) {
            HomeScreenContent(
                modifier = Modifier.padding(it),
                isLoading = isLoading
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolbarWithMenu(
    modifier: Modifier = Modifier,
    onLogoutClick: onClick
) {
    var isExpanded by remember { mutableStateOf(false) }
    TopAppBar(
        modifier = modifier,
        title = {
            AppText(text = "Home")
        },
        actions = {
            AppIconButton(
                imageVector = Icons.Default.Menu,
                onClick = { isExpanded = true }
            )
            DropdownMenu(
                modifier = modifier,
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                DropdownMenuItem(
                    text = { AppText(text = "Logout") },
                    onClick = {
                        onLogoutClick()
                        isExpanded = false
                    }
                )
            }
        }
    )
}