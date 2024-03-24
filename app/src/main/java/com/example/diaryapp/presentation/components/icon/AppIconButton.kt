package com.example.diaryapp.presentation.components.icon

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.diaryapp.common.onClick

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    contentDescription: String = "",
    onClick: onClick
) {
    IconButton(
        modifier = modifier,
        onClick = onClick
    ) {
        AppIcon(
            imageVector = imageVector,
            contentDescription = contentDescription
        )
    }
}