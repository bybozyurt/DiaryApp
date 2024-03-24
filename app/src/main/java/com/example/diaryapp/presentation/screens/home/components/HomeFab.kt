package com.example.diaryapp.presentation.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.FloatingActionButton
import androidx.compose.runtime.Composable
import com.example.diaryapp.common.onClick
import com.example.diaryapp.presentation.components.icon.AppIcon

@Composable
fun HomeFab(
    onClick: onClick
) {
    FloatingActionButton(onClick = onClick) {
        AppIcon(imageVector = Icons.Default.Create)
    }
}