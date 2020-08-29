package com.aligkts.bankapp.data.modules

import android.content.Context
import com.aligkts.bankapp.data.api.BankApi
import com.aligkts.bankapp.data.repository.account.AccountRepository
import com.aligkts.bankapp.data.repository.account.AccountRepositoryImpl
import com.aligkts.bankapp.data.repository.authentication.AuthenticationRepository
import com.aligkts.bankapp.data.repository.authentication.AuthenticationRepositoryImpl
import com.aligkts.bankapp.data.repository.transaction.TransactionRepository
import com.aligkts.bankapp.data.repository.transaction.TransactionRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Ali Göktaş on 28,August,2020
 */

val repositoryModule = module {

    fun provideAccountRepository(api: BankApi, context: Context): AccountRepository {
        return AccountRepositoryImpl(
            api,
            context
        )
    }
    single { provideAccountRepository(get(), androidContext()) }

    fun provideAuthenticationRepository(api: BankApi, context: Context): AuthenticationRepository {
        return AuthenticationRepositoryImpl(
            api,
            context
        )
    }
    single { provideAuthenticationRepository(get(), androidContext()) }

    fun provideTransactionRepository(api: BankApi, context: Context): TransactionRepository {
        return TransactionRepositoryImpl(
            api,
            context
        )
    }
    single { provideTransactionRepository(get(), androidContext()) }

}