package br.com.unifimes.coopermin.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class DetalheContratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_contrato)

        var img_close = findViewById<ImageView>(R.id.img_close)
        img_close.setOnClickListener { onBackPressed() }
    }
}