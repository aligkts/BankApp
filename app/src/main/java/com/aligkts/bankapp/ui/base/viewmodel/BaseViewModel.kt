package com.aligkts.bankapp.ui.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.aligkts.bankapp.ui.base.error.ErrorHandler

/**
 * Created by Ali Göktaş on 28,August,2020
 */
open class BaseViewModel(application: Application) : AndroidViewModel(application),
    LifecycleObserver {
    lateinit var baseVMDelegate: BaseViewModelDelegate
    val contentLoading = MutableLiveData<Boolean>()

    var errorHandler: ErrorHandler? = null

}