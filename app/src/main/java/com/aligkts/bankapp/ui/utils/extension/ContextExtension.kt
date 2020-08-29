package com.aligkts.bankapp.ui.utils.extension

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import com.aligkts.bankapp.R
import com.aligkts.bankapp.data.base.models.AppResult

/**
 * Created by Ali Göktaş on 28,August,2020
 */

fun Context.networkConnectivityError(): AppResult.Error {
    return AppResult.Error(Exception(this.resources.getString(R.string.error_network_connection)))
}

fun Context.isConnectionAvailable(): Boolean {
    var result = false
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        connectivityManager?.run {
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)?.run {
                result = when {
                    hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
                    else -> false
                }
            }
        }
    } else {
        connectivityManager?.run {
            val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
            return activeNetwork?.isConnected == true
        }
    }
    return result
}