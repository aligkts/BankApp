package com.aligkts.bankapp.ui.screens.home

import android.app.Application
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel

/**
 * Created by Ali Göktaş on 29,August,2020
 */

interface HomeViewModelDelegate {

}

class HomeViewModel(application: Application) : BaseViewModel(application) {

    var delegate: HomeViewModelDelegate? = null


}