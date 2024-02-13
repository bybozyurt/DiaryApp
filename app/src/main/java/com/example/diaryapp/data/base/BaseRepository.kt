package com.example.diaryapp.data.base

import com.example.diaryapp.common.AppResource

abstract class BaseRepository {

    suspend fun <T : Any?> safeApiCall(
        apiCall: (suspend () -> T?)
    ) : AppResource<T?> {
        return try {
            AppResource.Success(apiCall.invoke())
        } catch (e: Exception) {
            AppResource.Fail(e)
        }
    }

}