package com.example.diaryapp.common

sealed class AppResource<out T : Any?> {
    data class Success<out T : Any?>(val data: T? = null) : AppResource<T?>()

    data class Fail(val e: Exception) : AppResource<Nothing>()

    data class Loading<out T : Any?>(val data: T? = null) : AppResource<T?>()
}