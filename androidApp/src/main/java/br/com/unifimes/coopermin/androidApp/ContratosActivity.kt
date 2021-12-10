package br.com.unifimes.coopermin.androidApp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifimes.coopermin.androidApp.adapter.ContratoAdapter
import br.com.unifimes.coopermin.androidApp.api.ContratoApi
import br.com.unifimes.coopermin.androidApp.utils.Popup
import br.com.unifimes.coopermin.shared.controller.ContratoController
import br.com.unifimes.coopermin.shared.model.ContratoModel
import br.com.unifimes.coopermin.shared.model.FiltroContratoModel

class ContratosActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var img_back: ImageView
    lateinit var textView_todos : TextView
    lateinit var textView_iniciado : TextView
    lateinit var textView_cancelado : TextView
    lateinit var textView_completo : TextView
    lateinit var recyclerView_contratos : RecyclerView
    lateinit var linearLayout_filter : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contratos)

        img_back = findViewById(R.id.img_back)
        textView_todos = findViewById(R.id.textView_todos)
        textView_iniciado = findViewById(R.id.textView_iniciado)
        textView_cancelado = findViewById(R.id.textView_cancelado)
        textView_completo = findViewById(R.id.textView_completo)
        linearLayout_filter = findViewById(R.id.linearLayout_filter)

        linearLayout_filter.setOnClickListener(View.OnClickListener {
            var popup = Popup()
            var filtro = FiltroContratoModel()
            popup.showPopupFiltroContrato(this,filtro)
        })

        img_back.setOnClickListener { onBackPressed() }

        textView_todos.setOnClickListener(this)
        textView_iniciado.setOnClickListener(this)
        textView_cancelado.setOnClickListener(this)
        textView_completo.setOnClickListener(this)
        recyclerView_contratos = findViewById(R.id.recyclerView_contratos)

        todos(true)
    }

    fun preencherLista(contratos : ArrayList<ContratoModel>){
        if(!contratos.isEmpty()) {
            var contratoAdapter = ContratoAdapter()
            contratoAdapter.contratosList = contratos
            contratoAdapter.setNavigation(this, DetalheContratoActivity::class.java)

            var layoutManager = LinearLayoutManager(this)
            recyclerView_contratos.setLayoutManager(layoutManager)

            recyclerView_contratos.adapter = contratoAdapter
        }else{
            Popup().showPopupError(this,"Nenhum dado foi encontrado","não achei nada")
        }
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            when (p0.id) {
                R.id.textView_todos -> {
                    todos(true); iniciado(false); cancelado(false);completo(false)
                }
                R.id.textView_iniciado -> {
                    todos(false); iniciado(true); cancelado(false);completo(false)

                }
                R.id.textView_cancelado -> {
                    todos(false); iniciado(false); cancelado(true);completo(false)
                }
                R.id.textView_completo -> {
                    todos(false); iniciado(false); cancelado(false);completo(true)
                }

            }
        }
    }

    fun todos(ativo: Boolean?){
        if(ativo == true){
            textView_todos.setBackgroundResource(R.drawable.rectangle_green_search)
            textView_todos.setTextColor(Color.parseColor("#ffffff"))
            preencherLista(ContratoApi().getAllContratos())
        }else{
            textView_todos.setBackgroundResource(R.drawable.rectangle_gray_search)
            textView_todos.setTextColor(Color.parseColor("#000000"))
        }
    }

    fun iniciado(ativo: Boolean?){
        if(ativo == true){
            textView_iniciado.setBackgroundResource(R.drawable.rectangle_green_search)
            textView_iniciado.setTextColor(Color.parseColor("#ffffff"))
            preencherLista(ContratoController().getIniciado())
        }else{
            textView_iniciado.setBackgroundResource(R.drawable.rectangle_gray_search)
            textView_iniciado.setTextColor(Color.parseColor("#000000"))
        }
    }

    fun cancelado(ativo: Boolean?){
        if(ativo == true){
            textView_cancelado.setBackgroundResource(R.drawable.rectangle_green_search)
            textView_cancelado.setTextColor(Color.parseColor("#ffffff"))
            preencherLista(ContratoController().getCancelado())
        }else{
            textView_cancelado.setBackgroundResource(R.drawable.rectangle_gray_search)
            textView_cancelado.setTextColor(Color.parseColor("#000000"))
        }
    }

    fun completo(ativo: Boolean?){
        if(ativo == true){
            textView_completo.setBackgroundResource(R.drawable.rectangle_green_search)
            textView_completo.setTextColor(Color.parseColor("#ffffff"))
            preencherLista(ContratoController().getCompleto())
        }else{
            textView_completo.setBackgroundResource(R.drawable.rectangle_gray_search)
            textView_completo.setTextColor(Color.parseColor("#000000"))
        }
    }




}