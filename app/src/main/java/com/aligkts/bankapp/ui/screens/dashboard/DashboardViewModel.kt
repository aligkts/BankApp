package com.aligkts.bankapp.ui.screens.dashboard

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligkts.bankapp.data.base.models.AppResult
import com.aligkts.bankapp.data.model.response.AccountResponse
import com.aligkts.bankapp.data.model.response.AccountResponseItem
import com.aligkts.bankapp.data.model.response.LoginResponse
import com.aligkts.bankapp.data.repository.account.AccountRepository
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface DashboardViewModelDelegate {

}

class DashboardViewModel(application: Application,
                     private val repository: AccountRepository) : BaseViewModel(application) {

    var delegate: DashboardViewModelDelegate? = null

    val userInformations: MutableLiveData<LoginResponse> = MutableLiveData()
    val accounts: MutableLiveData<List<AccountResponseItem>> = MutableLiveData()

    fun getAccounts() {
        contentLoading.value = true
        viewModelScope.launch {
            val result = userInformations.value?.id?.let { repository.getAccounts(it) }
            contentLoading.value = false
            when (result) {
                is AppResult.Success -> {
                    accounts.value = result.successData.take(3)
                }
                is AppResult.Error -> result.exception.message?.let {
                    errorHandler?.handleError(it)
                }
            }
        }
    }

}