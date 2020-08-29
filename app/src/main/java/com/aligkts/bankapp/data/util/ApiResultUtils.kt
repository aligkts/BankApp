package com.aligkts.bankapp.data.util

import com.aligkts.bankapp.data.base.models.ApiErrorUtils
import com.aligkts.bankapp.data.base.models.AppResult
import retrofit2.Response

object ApiResultUtils {
    fun <T : Any> handleApiError(response: Response<T>): AppResult.Error {
        val error = ApiErrorUtils.parseError(response)
        return AppResult.Error(Exception(error.message))
    }

    fun <T : Any> handleSuccess(response: Response<T>): AppResult<T> {
        response.body()?.let {
            return AppResult.Success(it)
        } ?: return handleApiError(response)
    }
}