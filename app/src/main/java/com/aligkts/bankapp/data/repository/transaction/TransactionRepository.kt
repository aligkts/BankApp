package com.aligkts.bankapp.data.repository.transaction

import com.aligkts.bankapp.data.base.models.AppResult

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface TransactionRepository {
    suspend fun getTransactions() : AppResult<List<String>>
}