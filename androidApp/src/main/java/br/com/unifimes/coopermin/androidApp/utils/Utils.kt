package br.com.unifimes.coopermin.androidApp.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.ImageView

class Utils {

    fun verificarConexao(context: Activity? = null) : Boolean{
        try {
            val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val n = cm.activeNetwork
            val nc = cm.getNetworkCapabilities(n)
            var isConection = nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
            if(isConection) return true
        }catch(ex : Exception){
            return false
        }
        return false
        return false
    }

    fun abrirActivity(remetente: Activity, destino: Class<*>?) {
        val intent = Intent(remetente, destino)
        remetente.startActivity(intent)
    }


}