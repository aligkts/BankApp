package com.aligkts.bankapp.ui.screens.login

import android.os.Bundle
import android.view.View
import com.aligkts.bankapp.R
import com.aligkts.bankapp.data.util.observeNonNull
import com.aligkts.bankapp.databinding.FragmentLoginBinding
import com.aligkts.bankapp.ui.base.fragment.BaseFragment
import com.aligkts.bankapp.ui.screens.dashboard.DashboardFragment
import com.aligkts.bankapp.ui.screens.home.HomeFragment
import com.aligkts.bankapp.ui.screens.register.RegisterFragment
import com.aligkts.bankapp.ui.screens.register.RegisterViewModel
import com.aligkts.bankapp.ui.utils.extension.hideKeyboard
import org.koin.android.ext.android.inject

/**
 * Created by Ali Göktaş on 28,August,2020
 */
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(), LoginViewModelDelegate {

    override fun getFragmentView() = R.layout.fragment_login

    override val viewModel by inject<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.delegate = this
        showActionBar()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.loginResponse.observeNonNull(this) {
            requireActivity().hideKeyboard()
            val homeFragment = HomeFragment()
            val bundle = Bundle()
            bundle.putParcelable(LOGIN_RESPONSE, it)
            homeFragment.arguments = bundle
            navigator.navigateAndClearBackStack(homeFragment)
        }
    }

    override fun navigateRegisterPage() {
        navigator.navigateTo(RegisterFragment())
    }

    companion object {
        val LOGIN_RESPONSE = "LOGIN_RESPONSE"
    }

}