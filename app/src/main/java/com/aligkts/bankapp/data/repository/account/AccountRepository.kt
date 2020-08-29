package com.aligkts.bankapp.data.repository.account

import com.aligkts.bankapp.data.base.models.AppResult
import com.aligkts.bankapp.data.model.response.AccountResponse

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface AccountRepository {
    suspend fun getAccounts(id: Int) : AppResult<AccountResponse>
}