package com.aligkts.bankapp.ui.navigation

import androidx.fragment.app.Fragment

/**
 * Created by Ali Göktaş on 28,August,2020
 */
interface Navigator {
    fun navigateTo(fragment: Fragment)
    fun navigateAndClearBackStack(fragment: Fragment)
    fun navigateBack()
    fun setBackButtonEnabled(isEnabled: Boolean)
}