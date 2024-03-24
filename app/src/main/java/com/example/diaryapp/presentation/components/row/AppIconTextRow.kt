package com.example.diaryapp.presentation.components.row

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.diaryapp.presentation.components.icon.AppIcon
import com.example.diaryapp.presentation.components.text.AppText

@Composable
fun AppIconTextRow(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    text: String
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppIcon(
            imageVector = imageVector
        )
        Spacer(modifier = Modifier.width(8.dp))
        AppText(text = text)
    }
}