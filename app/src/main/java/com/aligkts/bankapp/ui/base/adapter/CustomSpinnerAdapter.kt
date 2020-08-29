package com.aligkts.bankapp.ui.base.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.aligkts.bankapp.R
import com.aligkts.bankapp.ui.base.model.GenderItem
import java.util.*

class CustomSpinnerAdapter(context: Context, genderList: ArrayList<GenderItem>) : ArrayAdapter<GenderItem>(context, 0, genderList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView =
                LayoutInflater.from(context).inflate(R.layout.spinner_layout, parent, false)
        }
        val item = getItem(position)
        val spinnerIV =
            convertView!!.findViewById<ImageView>(R.id.imgSpinnerLayout)
        val spinnerTV = convertView.findViewById<TextView>(R.id.txtSpinnerLayout)
        if (item != null) {
            spinnerIV.setImageResource(item.spinnerItemImage)
            spinnerTV.text = item.spinnerItemGender.value
        }
        return convertView
    }

    override fun getDropDownView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                .inflate(R.layout.spinner_item_with_icon, parent, false)
        }
        val item = getItem(position)
        val dropDownIV =
            convertView!!.findViewById<ImageView>(R.id.imgDropDownLayout)
        val dropDownTV = convertView.findViewById<TextView>(R.id.txtDropDownLayout)
        if (item != null) {
            dropDownIV.setImageResource(item.spinnerItemImage)
            dropDownTV.text = item.spinnerItemGender.value
        }
        return convertView
    }
}