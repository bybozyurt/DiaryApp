package com.example.diaryapp.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.diaryapp.presentation.components.progressBar.AppProgressBar
import com.example.diaryapp.presentation.components.text.AppText

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    isLoading: Boolean
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading) {
            AppProgressBar()
        } else {
            AppText(text = "Home Screen")
        }
    }
}