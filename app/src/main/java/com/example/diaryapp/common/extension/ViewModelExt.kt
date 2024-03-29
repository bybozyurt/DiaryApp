package com.example.diaryapp.common.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun ViewModel.launchInIo(
    launchBlock: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch {
        withContext(Dispatchers.IO) {
            launchBlock()
        }
    }
}