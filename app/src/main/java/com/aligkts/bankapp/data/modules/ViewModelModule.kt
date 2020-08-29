package com.aligkts.bankapp.data.modules

import com.aligkts.bankapp.BankApplication
import com.aligkts.bankapp.ui.screens.login.LoginViewModel
import com.aligkts.bankapp.ui.screens.register.RegisterViewModel
import com.aligkts.bankapp.ui.screens.splash.SplashViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import org.koin.android.viewmodel.dsl.viewModel

/**
 * Created by Ali Göktaş on 28,August,2020
 */

val viewModelModule = module {

    viewModel {
        SplashViewModel(androidApplication())
        LoginViewModel(androidApplication())
        RegisterViewModel(androidApplication())
    }

}