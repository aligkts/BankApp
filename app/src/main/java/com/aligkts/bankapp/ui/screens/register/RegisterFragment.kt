package com.aligkts.bankapp.ui.screens.register

import android.os.Bundle
import android.view.View
import com.aligkts.bankapp.R
import com.aligkts.bankapp.databinding.FragmentRegisterBinding
import com.aligkts.bankapp.ui.base.fragment.BaseFragment

/**
 * Created by Ali Göktaş on 28,August,2020
 */

class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>(), RegisterViewModelDelegate {

    override fun getFragmentView() = R.layout.fragment_register

    override fun getViewModel() = RegisterViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.delegate = this
        showActionBar()
    }

    override fun navigateHomePage() {
        //navigator.navigateAndClearBackStack(DashboardFragment())
    }

}