package com.aligkts.bankapp.ui.screens.login

import android.os.Bundle
import android.view.View
import com.aligkts.bankapp.R
import com.aligkts.bankapp.databinding.FragmentLoginBinding
import com.aligkts.bankapp.ui.base.fragment.BaseFragment
import com.aligkts.bankapp.ui.screens.register.RegisterFragment

/**
 * Created by Ali Göktaş on 28,August,2020
 */
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(), LoginViewModelDelegate {

    override fun getFragmentView() = R.layout.fragment_login

    override fun getViewModel() = LoginViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.delegate = this
        showActionBar()
    }

    override fun navigateHomePage() {
        //navigator.navigateAndClearBackStack(DashboardFragment())
    }

    override fun navigateRegisterPage() {
        navigator.navigateTo(RegisterFragment())
    }

}