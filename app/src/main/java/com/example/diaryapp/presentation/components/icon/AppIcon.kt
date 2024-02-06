package com.example.diaryapp.presentation.components.icon

import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun AppIcon(
    modifier: Modifier = Modifier,
    id: Int,
    contentDescription: String = "",
    tintColor: Color = Color.Unspecified
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = id),
        contentDescription = contentDescription,
        tint = tintColor
    )
}