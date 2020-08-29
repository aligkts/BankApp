package com.aligkts.bankapp.ui.screens.splash

import android.os.Bundle
import android.view.View
import com.aligkts.bankapp.R
import com.aligkts.bankapp.databinding.FragmentSplashBinding
import com.aligkts.bankapp.ui.base.fragment.BaseFragment
import com.aligkts.bankapp.ui.screens.login.LoginFragment

/**
 * Created by Ali Göktaş on 28,August,2020
 */

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(), SplashViewModelDelegate {


    override fun getFragmentView() = R.layout.fragment_splash

    override fun getViewModel() = SplashViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.delegate = this
        hideActionBar()
        viewModel.startSplashShownTimer()
    }

    override fun navigateLoginPage() {
        navigator.navigateAndClearBackStack(LoginFragment())
    }

}