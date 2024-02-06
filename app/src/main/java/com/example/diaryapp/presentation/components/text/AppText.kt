package com.example.diaryapp.presentation.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    fontSize: TextUnit = TextUnit.Unspecified,
    fontWeight: FontWeight = FontWeight.Normal
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
}