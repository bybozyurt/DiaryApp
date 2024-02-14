package com.example.diaryapp.common.extension

import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier
import com.example.diaryapp.common.onClick

fun Modifier.addSafeOnClick(onClick: onClick?): Modifier {
    return conditional(onClick != null) {
        clickable(
            onClick = { onClick?.invoke() }
        )
    }
}

fun Modifier.conditional(condition: Boolean, modifier: Modifier.() -> Modifier): Modifier {
    return if (condition) {
        then(modifier(Modifier))
    } else {
        this
    }
}