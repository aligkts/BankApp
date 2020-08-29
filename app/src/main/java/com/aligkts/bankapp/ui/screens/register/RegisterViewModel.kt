package com.aligkts.bankapp.ui.screens.register

import android.app.Application
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface RegisterViewModelDelegate {
    fun navigateHomePage()
}

class RegisterViewModel(application: Application) : BaseViewModel(application) {

    var delegate: RegisterViewModelDelegate? = null

    fun register() {

    }

}