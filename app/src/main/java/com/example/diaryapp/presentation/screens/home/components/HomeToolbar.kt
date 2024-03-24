package com.example.diaryapp.presentation.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.diaryapp.common.ScreenNames
import com.example.diaryapp.common.onClick
import com.example.diaryapp.presentation.components.icon.AppIconButton
import com.example.diaryapp.presentation.components.text.AppText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarWithMenu(
    modifier: Modifier = Modifier,
    onLogoutClick: onClick
) {
    var isExpanded by remember { mutableStateOf(false) }
    TopAppBar(
        modifier = modifier,
        title = {
            AppText(text = ScreenNames.Home)
        },
        actions = {
            AppIconButton(
                imageVector = Icons.Default.DateRange,
                onClick = { /*TODO */ }
            )
            AppIconButton(
                imageVector = Icons.Default.Menu,
                onClick = { isExpanded = true }
            )
            HomeDropdownMenu(
                expanded = isExpanded,
                onDismissedRequest = { isExpanded = false },
                onDeleteClick = { /*TODO*/ },
                onLogoutClick = {
                    isExpanded = false
                    onLogoutClick()
                }
            )
        }
    )
}