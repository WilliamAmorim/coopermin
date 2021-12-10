package br.com.unifimes.coopermin.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifimes.coopermin.androidApp.adapter.AssociadoAdapter
import br.com.unifimes.coopermin.androidApp.adapter.ContratoAdapter
import br.com.unifimes.coopermin.androidApp.api.AssociadoApi
import br.com.unifimes.coopermin.androidApp.utils.Popup
import br.com.unifimes.coopermin.shared.controller.AssociadoController
import br.com.unifimes.coopermin.shared.model.ContratoModel

class AssociadoActivity : AppCompatActivity() {
    lateinit var recyclerView_associado : RecyclerView
    lateinit var textView_total : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_associado)

        var img_back = findViewById<ImageView>(R.id.img_back)
        img_back.setOnClickListener { onBackPressed() }
        recyclerView_associado = findViewById(R.id.recyclerView_associado)
        textView_total = findViewById(R.id.textView_total)

        preencherLista()

    }

    fun preencherLista(){
        var associadoAdapter = AssociadoAdapter()
        associadoAdapter.inicializeActivity(this)
        associadoAdapter.inicializeAssociadoList(AssociadoApi().getAllAssociado())
        var layoutManager = LinearLayoutManager(this)
        recyclerView_associado.setLayoutManager(layoutManager)
        recyclerView_associado.adapter = associadoAdapter

        textView_total.setText("Total: "+AssociadoApi().getAllAssociado().size)
    }
}