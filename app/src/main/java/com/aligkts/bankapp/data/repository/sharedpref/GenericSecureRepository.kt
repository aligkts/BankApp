package com.aligkts.bankapp.data.repository.sharedpref

import com.aligkts.bankapp.BankApplication

interface GenericSecureRepository {
    companion object {
        val default: GenericSecureRepository by lazy {
            SecureSharedPref(context = BankApplication().applicationContext)
        }
    }

    fun put(key: String, value: String)
    fun put(key: String, value: Int)
    fun put(key: String, value: Boolean)
    fun put(key: String, value: Long)
    fun put(key: String, value: Float)

    fun getString(key: String): String?
    fun getInt(key: String): Int?
    fun getBoolean(key: String): Boolean?
    fun getLong(key: String): Long?
    fun getFloat(key: String): Float?

    fun contains(key: String): Boolean
    fun remove(key: String)
}