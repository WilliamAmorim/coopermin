package br.com.unifimes.coopermin.androidApp.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import br.com.unifimes.coopermin.androidApp.R

class Popup {

    fun showPopupError(actitvity: Activity, titulo: String,subtitulo: String){
        var slideDialog = Dialog(actitvity, R.style.CustomDialogAnimation)
        slideDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = slideDialog.window
        window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT
        )
        slideDialog.setContentView(R.layout.popup_error)
        val layoutParams = WindowManager.LayoutParams()
        slideDialog.window!!.attributes.windowAnimations = R.style.CustomDialogAnimation
        layoutParams.copyFrom(slideDialog.window!!.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
        layoutParams.gravity = Gravity.BOTTOM
        slideDialog.window!!.attributes = layoutParams
        slideDialog.setCancelable(true)
        slideDialog.setCanceledOnTouchOutside(true)

        var close = slideDialog.findViewById<Button>(R.id.button_sairPopup)
        var textView_popupTitulo = slideDialog.findViewById<TextView>(R.id.textView_popupTitulo)
        var textView_popupSubTitulo = slideDialog.findViewById<TextView>(R.id.textView_popupSubTitulo)

        textView_popupTitulo.setText(titulo)
        textView_popupSubTitulo.setText(subtitulo)

        close.setOnClickListener(View.OnClickListener {
            slideDialog.cancel()
        })

        slideDialog.show()
    }
}