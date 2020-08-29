package com.aligkts.bankapp.data.repository.account

import android.content.Context
import com.aligkts.bankapp.data.api.BankApi
import com.aligkts.bankapp.data.base.models.AppResult
import com.aligkts.bankapp.data.util.ApiResultUtils.handleApiError
import com.aligkts.bankapp.data.util.ApiResultUtils.handleSuccess
import com.aligkts.bankapp.ui.utils.extension.isConnectionAvailable
import com.aligkts.bankapp.ui.utils.extension.networkConnectivityError

/**
 * Created by Ali Göktaş on 28,August,2020
 */

class AccountRepositoryImpl(private val api: BankApi,
                            private val context: Context) : AccountRepository {

    override suspend fun getAccounts(): AppResult<List<String>> {
        return if (context.isConnectionAvailable()) {
            try {
                val response = api.getAccounts()
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