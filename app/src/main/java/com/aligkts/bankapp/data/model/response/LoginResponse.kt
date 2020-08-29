package com.aligkts.bankapp.data.model.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("dob")
    val dob: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("First Name")
    val firstName: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("Last Name")
    val lastName: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("phone")
    val phone: String?
): Parcelable