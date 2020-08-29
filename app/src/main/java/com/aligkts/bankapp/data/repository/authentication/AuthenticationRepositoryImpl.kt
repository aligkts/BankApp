package com.aligkts.bankapp.data.repository.authentication

import android.content.Context
import com.aligkts.bankapp.data.api.BankApi
import com.aligkts.bankapp.data.base.models.AppResult
import com.aligkts.bankapp.data.model.request.LoginRequestModel
import com.aligkts.bankapp.data.model.response.LoginResponse
import com.aligkts.bankapp.data.util.ApiResultUtils.handleApiError
import com.aligkts.bankapp.data.util.ApiResultUtils.handleSuccess
import com.aligkts.bankapp.ui.utils.extension.isConnectionAvailable
import com.aligkts.bankapp.ui.utils.extension.networkConnectivityError

/**
 * Created by Ali Göktaş on 28,August,2020
 */

class AuthenticationRepositoryImpl(private val api: BankApi,
                                   private val context: Context) : AuthenticationRepository {

    override suspend fun login(loginRequest: LoginRequestModel): AppResult<LoginResponse> {
        return if (context.isConnectionAvailable()) {
            try {
                val response = api.login(loginRequest)
                if (response.isSuccessful) {
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            context.networkConnectivityError()
        }
    }

}