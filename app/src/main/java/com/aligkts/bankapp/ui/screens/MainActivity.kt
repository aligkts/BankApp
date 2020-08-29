package com.aligkts.bankapp.ui.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.aligkts.bankapp.R
import com.aligkts.bankapp.ui.navigation.Navigator
import com.aligkts.bankapp.ui.screens.splash.SplashFragment

class MainActivity : AppCompatActivity(), Navigator {
    private var isBackEnabled = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    override fun onBackPressed() {
        if(isBackEnabled.not()) {
            return
        }
        if (supportFragmentManager.backStackEntryCount > 1) {
            super.onBackPressed()
            return
        }
        finish()
    }

    private fun initUI() {
        navigateTo(SplashFragment())
    }

    override fun navigateTo(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.root_view, fragment).addToBackStack(null).commit()
    }

    override fun navigateAndClearBackStack(fragment: Fragment) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        navigateTo(fragment)
    }

    override fun navigateBack() = onBackPressed()

    override fun setBackButtonEnabled(isEnabled: Boolean) {
        isBackEnabled = isEnabled
    }

    fun hideActionBar() = supportActionBar?.hide()

    fun showActionBar() = supportActionBar?.show()
}