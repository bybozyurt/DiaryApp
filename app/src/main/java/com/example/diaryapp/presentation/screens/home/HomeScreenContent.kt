package com.example.diaryapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.diaryapp.common.onClick
import com.example.diaryapp.presentation.components.button.SocialButton
import com.example.diaryapp.presentation.components.text.AppText

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    onLogOutClick: onClick,
    isLoading: Boolean
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(text = "Home Screen")
        SocialButton(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(70.dp),
            text = "Logout",
            isLoading = isLoading,
            onClick = onLogOutClick,
            containerColor = Color.Red.copy(alpha = 0.5f)
        )
    }
}