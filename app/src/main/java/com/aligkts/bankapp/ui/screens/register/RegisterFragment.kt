package com.aligkts.bankapp.ui.screens.register

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.aligkts.bankapp.R
import com.aligkts.bankapp.data.util.observeNonNull
import com.aligkts.bankapp.databinding.FragmentRegisterBinding
import com.aligkts.bankapp.ui.base.adapter.CustomSpinnerAdapter
import com.aligkts.bankapp.ui.base.fragment.BaseFragment
import com.aligkts.bankapp.ui.base.model.GenderItem
import kotlinx.android.synthetic.main.spinner_layout.*
import org.joda.time.DateTime
import org.koin.android.ext.android.inject
import java.util.*


/**
 * Created by Ali Göktaş on 28,August,2020
 */

class RegisterFragment : BaseFragment<FragmentRegisterBinding, RegisterViewModel>(),
    RegisterViewModelDelegate, AdapterView.OnItemSelectedListener {

    var spinnerDropdownWidth = 150
    private var datePickerDialog: DatePickerDialog? = null

    override fun getFragmentView() = R.layout.fragment_register

    override val viewModel by inject<RegisterViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        viewModel.delegate = this
        registerObservers()
        showActionBar()
        viewModel.getGenderList()
    }

    private fun registerObservers() {
        viewModel.genderList.observeNonNull(this) {
            val spinnerAdapter = CustomSpinnerAdapter(requireContext(), it)
            binding.spinnerGender.apply {
                adapter = spinnerAdapter
                onItemSelectedListener = this@RegisterFragment
            }
        }
    }

    override fun showDatePickerDialog(view: View) {
        binding.layoutRoot.requestFocus()
        val dateTime = DateTime.now()
        val localDateTime = dateTime.toLocalDateTime()
        val mYear = localDateTime.year
        val mMonth = localDateTime.monthOfYear
        val mDay = localDateTime.dayOfMonth
        val mHour = localDateTime.hourOfDay
        val mMinute = localDateTime.minuteOfHour
        createDatePickerDialog(view, mDay, mMonth, mYear, mHour, mMinute)
    }

    private fun createDatePickerDialog(
        view: View?,
        day: Int,
        month: Int,
        year: Int,
        hour: Int,
        minute: Int) {
        var month = month
        month--
        val mTimeSetListener =
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                val cal = Calendar.getInstance(TimeZone.getDefault())
                cal.set(year, monthOfYear, dayOfMonth, 12, 0, 0)
                when (view?.id) {
                    R.id.edit_text_birth_date -> {
                        val dateTime = DateTime(cal.timeInMillis)
                        //viewModel.birthDate.value = dateTime.formatForView()
                    }
                }

                datePickerDialog?.dismiss()
            }

        datePickerDialog = DatePickerDialog(requireContext(), mTimeSetListener, year, month, day)
        datePickerDialog!!.setCancelable(true)
        datePickerDialog!!.show()
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        spinnerDropdownWidth = customSpinnerItem.width
        binding.spinnerGender.dropDownWidth = spinnerDropdownWidth
        Toast.makeText(requireContext(), (adapterView!!.selectedItem as GenderItem).spinnerItemGender.value, Toast.LENGTH_SHORT).show()
        //viewModel.gender.value = selectedGender.spinnerItemName
    }

    override fun onNothingSelected(adapterView: AdapterView<*>?) {
    }



}