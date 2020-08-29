package com.aligkts.bankapp.data.modules

import com.aligkts.bankapp.data.api.BankApi
import org.koin.dsl.module
import retrofit2.Retrofit

/**
 * Created by Ali Göktaş on 28,August,2020
 */

val apiModule = module {

    fun provideBankApi(retrofit: Retrofit): BankApi {
        return retrofit.create(BankApi::class.java)
    }
    single { provideBankApi(get()) }

}