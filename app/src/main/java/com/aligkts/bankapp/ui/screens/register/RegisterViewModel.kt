package com.aligkts.bankapp.ui.screens.register

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.aligkts.bankapp.R
import com.aligkts.bankapp.data.model.enum.GenderEnum
import com.aligkts.bankapp.data.repository.authentication.AuthenticationRepository
import com.aligkts.bankapp.ui.base.model.GenderItem
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel

/**
 * Created by Ali Göktaş on 28,August,2020
 */

interface RegisterViewModelDelegate {
    fun showDatePickerDialog(view: View)
}

class RegisterViewModel(application: Application,
                        private val repository: AuthenticationRepository) : BaseViewModel(application) {

    var delegate: RegisterViewModelDelegate? = null
    val name: MutableLiveData<String> = MutableLiveData()
    val surname: MutableLiveData<String> = MutableLiveData()
    //val gender: MutableLiveData<GenderEnum> = MutableLiveData()
    val birthDate: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val password: MutableLiveData<String> = MutableLiveData()

    val genderList: MutableLiveData<ArrayList<GenderItem>> = MutableLiveData()

    fun register() {

    }

    fun getGenderList() {
        genderList.value = ArrayList<GenderItem>().apply {
            add(GenderItem(GenderEnum.Male, R.drawable.icon_male))
            add(GenderItem(GenderEnum.Female, R.drawable.icon_female))
        }
    }


}