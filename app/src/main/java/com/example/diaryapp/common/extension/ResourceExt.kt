package com.example.diaryapp.common.extension

import com.example.diaryapp.common.AppResource

suspend fun <T : Any?> AppResource<T?>.onSuccess(block: suspend (data: T?) -> Unit): AppResource<T?> {
    if (this is AppResource.Success) {
        block.invoke(data)
    }
    return this
}

suspend fun <T : Any?> AppResource<T?>.onError(block: suspend (e: Exception) -> Unit): AppResource<T?> {
    if (this is AppResource.Fail) {
        block.invoke(e)
    }
    return this
}
