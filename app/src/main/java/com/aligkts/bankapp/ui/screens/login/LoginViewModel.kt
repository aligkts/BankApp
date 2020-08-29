package com.aligkts.bankapp.ui.screens.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligkts.bankapp.R
import com.aligkts.bankapp.data.base.models.AppResult
import com.aligkts.bankapp.data.model.request.LoginRequestModel
import com.aligkts.bankapp.data.model.response.LoginResponse
import com.aligkts.bankapp.data.repository.account.AccountRepository
import com.aligkts.bankapp.data.repository.authentication.AuthenticationRepository
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 28,August,2020
 */
interface LoginViewModelDelegate {
    fun navigateRegisterPage()
}

class LoginViewModel(application: Application,
                     private val repository: AuthenticationRepository) : BaseViewModel(application) {

    var delegate: LoginViewModelDelegate? = null
    val identifier: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    val loginResponse: MutableLiveData<LoginResponse> = MutableLiveData()

    private val context = getApplication<Application>().applicationContext

    fun login() {
        if (identifier.value.isNullOrEmpty() || password.value.isNullOrEmpty()) {
            errorHandler?.handleError(context.getString(R.string.fill_all_fields))
        } else {
            val loginRequestBody = LoginRequestModel(identifier.value!!, password.value!!)
            contentLoading.value = true
            viewModelScope.launch {
                val result =  repository.login(loginRequestBody)
                contentLoading.value = false
                when (result) {
                    is AppResult.Success -> {
                        loginResponse.value = result.successData
                    }
                    is AppResult.Error -> result.exception.message?.let {
                        errorHandler?.handleError(it)
                    }
                }
            }
        }
    }

}