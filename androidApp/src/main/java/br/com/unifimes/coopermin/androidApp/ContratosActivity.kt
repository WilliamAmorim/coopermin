package br.com.unifimes.coopermin.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContratosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contratos)

        val textView_todos = findViewById<TextView>(R.id.textView_todos)
        val textView_iniciado = findViewById<TextView>(R.id.textView_iniciado)
        val textView_cancelado = findViewById<TextView>(R.id.textView_cancelado)
        val textView_completo = findViewById<TextView>(R.id.textView_completo)

        val recyclerView_contratos = findViewById<RecyclerView>(R.id.recyclerView_contratos)
    }
}