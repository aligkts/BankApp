package com.aligkts.bankapp.data.repository.account

import com.aligkts.bankapp.data.base.models.AppResult

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface AccountRepository {
    suspend fun getAccounts() : AppResult<List<String>>
}