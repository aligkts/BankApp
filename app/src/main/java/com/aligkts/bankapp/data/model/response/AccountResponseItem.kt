package com.aligkts.bankapp.data.model.response


import com.aligkts.bankapp.ui.base.adapter.BaseRecyclerviewItem
import com.google.gson.annotations.SerializedName

data class AccountResponseItem(
    @SerializedName("active")
    val active: String?,
    @SerializedName("customer_id")
    val customerId: String?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("iban")
    val iban: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("type")
    val type: String?
): BaseRecyclerviewItem()