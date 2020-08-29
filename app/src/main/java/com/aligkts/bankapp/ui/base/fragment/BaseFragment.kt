package com.aligkts.bankapp.ui.base.fragment

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.aligkts.bankapp.BR
import com.aligkts.bankapp.R
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModel
import com.aligkts.bankapp.ui.base.viewmodel.BaseViewModelDelegate
import com.aligkts.bankapp.ui.base.error.ErrorHandler
import com.aligkts.bankapp.ui.navigation.Navigator
import com.aligkts.bankapp.ui.screens.MainActivity
import com.aligkts.bankapp.ui.utils.extension.inflate

/**
 * Created by Ali Göktaş on 28,August,2020
 */

abstract class BaseFragment <T: ViewDataBinding, VM: BaseViewModel> : Fragment(),
    BaseViewModelDelegate,
    ErrorHandler {

    private val activity by lazy { (requireActivity() as MainActivity) }
    protected val navigator: Navigator by lazy { context as Navigator }
    private var progressDialog: ProgressDialog? = null

    protected lateinit var binding: T
    protected lateinit var viewModel: VM

    //region Abstract Methods
    abstract fun getViewModel(): Class<VM>
    abstract fun getFragmentView() : Int
    //endregion

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = container.inflate(getFragmentView(), false)
        viewModel = ViewModelProvider(this).get(getViewModel())
        binding.apply {
            lifecycleOwner = this@BaseFragment
        }
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    fun showActionBar() = activity.supportActionBar?.show()

    fun hideActionBar() = activity.supportActionBar?.hide()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.lifecycle.addObserver(viewModel)
        viewModel.baseVMDelegate = this
        viewModel.contentLoading.observe(viewLifecycleOwner, Observer {
            if (it) showProgress()
            else dismissProgress()
        })
        viewModel.errorHandler = this
    }

    override fun onDestroy() {
        super.onDestroy()
        this.lifecycle.removeObserver(viewModel)
    }

    protected open fun showProgress() {
        context?.let { c ->
            progressDialog?.dismiss()
            progressDialog = ProgressDialog.show(c, null, getString(R.string.please_wait))
        }
    }

    protected open fun dismissProgress() {
        progressDialog?.dismiss()
    }

    override fun handleError(message: String) {
        activity.let { activity ->
            AlertDialog.Builder(activity)
                .setTitle(R.string.error_dialog_title)
                .setMessage(message)
                .setPositiveButton(R.string.done) { dialogInterface: DialogInterface, _: Int ->
                    dialogInterface.dismiss()
                }.show()
        }
    }
}