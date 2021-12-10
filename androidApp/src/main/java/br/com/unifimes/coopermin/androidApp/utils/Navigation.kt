package br.com.unifimes.coopermin.androidApp.utils

import android.app.Activity
import android.content.Intent

class Navigation {
    fun abrirActivity(remetente: Activity?, destino: Class<*>?) {
        val intent = Intent(remetente, destino)
        remetente?.startActivity(intent)
    }
}