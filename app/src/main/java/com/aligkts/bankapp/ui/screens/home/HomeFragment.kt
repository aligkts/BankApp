package com.aligkts.bankapp.ui.screens.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aligkts.bankapp.R
import com.aligkts.bankapp.data.model.response.AccountResponse
import com.aligkts.bankapp.data.model.response.LoginResponse
import com.aligkts.bankapp.data.util.observeNonNull
import com.aligkts.bankapp.databinding.FragmentHomeBinding
import com.aligkts.bankapp.ui.base.fragment.BaseFragment
import com.aligkts.bankapp.ui.screens.dashboard.DashboardFragment
import com.aligkts.bankapp.ui.screens.login.LoginFragment
import com.aligkts.bankapp.ui.screens.login.LoginFragment.Companion.LOGIN_RESPONSE
import org.koin.android.ext.android.inject

/**
 * Created by Ali Göktaş on 29,August,2020
 */

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(),
    HomeViewModelDelegate {

    override fun getFragmentView() = R.layout.fragment_home

    override val viewModel by inject<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.delegate = this
        requireArguments().getParcelable<LoginResponse>(LOGIN_RESPONSE)?.let {
            val dashboardFragment = DashboardFragment()
            val bundle = Bundle()
            bundle.putParcelable(LOGIN_RESPONSE, it)
            dashboardFragment.arguments = bundle
            navigateTo(dashboardFragment, DashboardFragment.TAG)
        }

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {  item ->
            when( item.itemId) {
                R.id.menu_item_dashboard -> {
                    if(childFragmentManager.findFragmentByTag(DashboardFragment.TAG) == null) {
                        navigateTo(DashboardFragment(), DashboardFragment.TAG)
                    }
                    else {
                        return@setOnNavigationItemSelectedListener false
                    }
                }

                R.id.menu_item_account_list -> {
                    //TODO change with related fragment
                    if(childFragmentManager.findFragmentByTag(DashboardFragment.TAG) == null) {
                        navigateTo(DashboardFragment(), DashboardFragment.TAG)
                    }
                    else {
                        return@setOnNavigationItemSelectedListener false
                    }

                }
            }
            true
        }
    }

    private fun navigateTo(fragment: Fragment, tag: String) {
        childFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        childFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment, tag)
            .addToBackStack(null).commit()
    }

}