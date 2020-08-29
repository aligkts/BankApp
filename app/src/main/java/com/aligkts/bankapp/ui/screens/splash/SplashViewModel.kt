package com.aligkts.bankapp.ui.screens.splash

import android.app.Application
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel
import com.aligkts.bankapp.ui.screens.login.LoginFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface SplashViewModelDelegate {
    fun navigateLoginPage()
}

class SplashViewModel(application: Application) : BaseViewModel(application) {

    var delegate: SplashViewModelDelegate? = null

    fun startSplashShownTimer() {
        CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            delegate?.navigateLoginPage()
        }
    }

}