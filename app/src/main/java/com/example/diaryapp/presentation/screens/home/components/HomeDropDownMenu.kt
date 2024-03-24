package com.example.diaryapp.presentation.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.diaryapp.R
import com.example.diaryapp.common.onClick
import com.example.diaryapp.common.onDismissedRequest
import com.example.diaryapp.presentation.components.row.AppIconTextRow

@Composable
fun HomeDropdownMenu(
    modifier: Modifier = Modifier,
    onDismissedRequest: onDismissedRequest,
    expanded: Boolean,
    onDeleteClick: onClick,
    onLogoutClick: onClick
) {
    DropdownMenu(
        modifier = modifier,
        expanded = expanded,
        onDismissRequest = onDismissedRequest
    ) {
        DropdownMenuItem(
            text = {
                AppIconTextRow(
                    text = stringResource(id = R.string.delete_diaries),
                    imageVector = Icons.Default.Delete
                )
            },
            onClick = onDeleteClick
        )
        DropdownMenuItem(
            text = {
                AppIconTextRow(
                    text = stringResource(id = R.string.logout),
                    imageVector = Icons.Default.AccountCircle
                )
            },
            onClick = onLogoutClick
        )
    }
}