package com.example.diaryapp.common.extension

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

fun Modifier.setVisibility(visible: Boolean) = if (visible) {
    alpha(1f)
} else {
    alpha(0f)
}