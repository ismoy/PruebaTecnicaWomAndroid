package com.github.comismoy.pruebatecnicawomandroid.data.repository

import android.content.Context
import android.net.ConnectivityManager
import com.github.comismoy.pruebatecnicawomandroid.data.core.NetworkHelper
import javax.inject.Inject

class NetworkHelperImpl @Inject constructor(
    private val context: Context
):NetworkHelper {
    override fun isConnected(): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as
                ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnected
    }
}