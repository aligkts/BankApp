package com.aligkts.bankapp.ui.screens.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

/**
 * Created by Ali Göktaş on 28,August,2020
 */
interface LoginViewModelDelegate {
    fun navigateRegisterPage()
    fun navigateHomePage()
}

class LoginViewModel(application: Application) : BaseViewModel(application) {

    var delegate: LoginViewModelDelegate? = null
    val identifier: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    private val context = getApplication<Application>().applicationContext

    fun login() {
        /*contentLoading.value = true
        viewModelScope.launch {
            val result =  repository.getAllCountries()

            showLoading.set(false)
            when (result) {
                is AppResult.Success -> {
                    countriesList.value = result.successData
                    showError.value = null
                }
                is AppResult.Error -> showError.value = result.exception.message
            }
        }
        if (identifier.value.isNullOrEmpty() || password.value.isNullOrEmpty()) {
            errorHandler?.handleError(context.getString(R.string.fill_all_fields))
        } else {
            contentLoading.value = true
            viewModelScope.launch(context = Dispatchers.Default) {
                userRepository.getUser({ user ->
                    withContext(Dispatchers.Main) {
                        contentLoading.value = false
                        delegate?.navigateHomePage()
                    }
                }, {
                    withContext(Dispatchers.Main) {
                        contentLoading.value = false
                        errorHandler?.handleError(
                            it?.errorMessageForUser
                                ?: this@LoginViewModel.context.getString(R.string.general_error_message)
                        )
                    }
                })
            }
        }*/

    }

}