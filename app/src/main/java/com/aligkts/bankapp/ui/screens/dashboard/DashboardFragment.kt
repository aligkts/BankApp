package com.aligkts.bankapp.ui.screens.dashboard

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aligkts.bankapp.R
import com.aligkts.bankapp.data.model.response.AccountResponseItem
import com.aligkts.bankapp.data.model.response.LoginResponse
import com.aligkts.bankapp.data.util.observeNonNull
import com.aligkts.bankapp.databinding.FragmentDashboardBinding
import com.aligkts.bankapp.databinding.RecyclerviewItemAccountBinding
import com.aligkts.bankapp.ui.base.adapter.GenericAdapter
import com.aligkts.bankapp.ui.base.fragment.BaseFragment
import com.aligkts.bankapp.ui.screens.login.LoginFragment.Companion.LOGIN_RESPONSE
import org.koin.android.ext.android.inject

/**
 * Created by Ali Göktaş on 28,August,2020
 */

class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>(), DashboardViewModelDelegate {

    override fun getFragmentView() = R.layout.fragment_dashboard

    override val viewModel by inject<DashboardViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.delegate = this
        requireArguments().getParcelable<LoginResponse>(LOGIN_RESPONSE)?.let {
            viewModel.userInformations.value = it
        }
        viewModel.getAccounts()
        registerObservers()
    }

    private fun registerObservers() {
        viewModel.accounts.observeNonNull(this) {
            setupAccountRecyclerview(it)
        }
    }

    private fun setupAccountRecyclerview(accounts: List<AccountResponseItem>) {
        val genericAdapter = GenericAdapter<AccountResponseItem>(R.layout.recyclerview_item_account)

        genericAdapter.setOnListItemViewClickListener(object : GenericAdapter.OnListItemViewClickListener{
            override fun onClick(view: View, position: Int) {
                //TODO navigate account detail with accounts.get(position)
            }
        })
        genericAdapter.addItems(accounts)
        binding.rvAccounts.adapter = genericAdapter
    }

    companion object {
        val TAG = "DashboardFragment"
    }
}