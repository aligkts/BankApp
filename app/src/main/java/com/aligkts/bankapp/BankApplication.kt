package com.aligkts.bankapp

import android.app.Application
import com.aligkts.bankapp.data.modules.apiModule
import com.aligkts.bankapp.data.modules.networkModule
import com.aligkts.bankapp.data.modules.repositoryModule
import com.aligkts.bankapp.data.modules.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Ali Göktaş on 28,August,2020
 */

class BankApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BankApplication)
            modules(
                apiModule,
                viewModelModule,
                repositoryModule,
                networkModule)
        }
    }
}