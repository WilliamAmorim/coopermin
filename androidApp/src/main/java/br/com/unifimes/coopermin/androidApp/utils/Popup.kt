package br.com.unifimes.coopermin.androidApp.utils

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.unifimes.coopermin.androidApp.R
import br.com.unifimes.coopermin.androidApp.adapter.FilterGridAdapter
import br.com.unifimes.coopermin.shared.model.AssociadoModel
import br.com.unifimes.coopermin.shared.model.FiltroContratoModel


class Popup {
    private lateinit var slideDialog : Dialog

    fun close(){ slideDialog.cancel() }

    fun createPopup(actitvity: Activity,layout : Int,gravity : Int,cancelable : Boolean){
        slideDialog = Dialog(actitvity, R.style.CustomDialogAnimation)
        slideDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val window = slideDialog.window

        window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)

        slideDialog.setContentView(layout)

        val layoutParams = WindowManager.LayoutParams()
        slideDialog.window!!.attributes.windowAnimations = R.style.CustomDialogAnimation
        layoutParams.copyFrom(slideDialog.window!!.attributes)
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT
        layoutParams.gravity = gravity
        slideDialog.window!!.attributes = layoutParams
        slideDialog.setCancelable(cancelable)
        slideDialog.setCanceledOnTouchOutside(cancelable)
    }

    fun showPopupError(activity: Activity?, titulo: String,subtitulo: String){
        if (activity != null) {
            createPopup(activity,R.layout.popup_error,Gravity.BOTTOM,true)
        }

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

    fun showPopupLoaging(activity: Activity?){
        if (activity != null) {
            createPopup(activity,R.layout.popup_error,Gravity.BOTTOM,true)
        }

        slideDialog.show()
    }

    fun showPopupFiltroContrato(activity: Activity,filtro : FiltroContratoModel){
        createPopup(activity,R.layout.popup_filter_contrato,Gravity.CENTER_VERTICAL,true)

        var recyclerView_categories = slideDialog.findViewById<RecyclerView>(R.id.recyclerCategories)
        var recyclerView_order = slideDialog.findViewById<RecyclerView>(R.id.recyclerOrder)

        var categories: ArrayList<String> = ArrayList()
        categories.add("Tomate")
        categories.add("Cebola")
        categories.add("Alface")
        categories.add("Cenoura")


        var adapterCategory = FilterGridAdapter()
        adapterCategory.setConteudo(categories)
        adapterCategory.setSelectedCategory(filtro.order.toString())

        var layoutManager = GridLayoutManager(activity,3)
        recyclerView_categories.layoutManager = layoutManager
        recyclerView_categories.adapter = adapterCategory


        var order: ArrayList<String> = ArrayList()
        order.add("Mais Baixo")
        order.add("Mais Alto")
        order.add("Mais Novo")
        order.add("Mais Antigo")
        var adapterOrder = FilterGridAdapter()
        adapterOrder.setConteudo(order)
        adapterOrder.setSelectedCategory(filtro.categoria.toString())

        recyclerView_order.layoutManager = layoutManager
        recyclerView_order.adapter = adapterCategory

        slideDialog.show()
    }

    fun showPopupAssociado(activity: Activity,associado: AssociadoModel){
        createPopup(activity,R.layout.popup_associado,Gravity.CENTER,true)
        var img_back = slideDialog.findViewById<ImageView>(R.id.img_back);

        var textView_nome = slideDialog.findViewById<TextView>(R.id.textView_nome)
        var textView_razao = slideDialog.findViewById<TextView>(R.id.textView_razao)
        var textView_cpf = slideDialog.findViewById<TextView>(R.id.textView_cpf)
        var textView_inscricaoEstadual = slideDialog.findViewById<TextView>(R.id.textView_inscricaoEstadual)
        var textView_logradouro = slideDialog.findViewById<TextView>(R.id.textView_logradouro)
        var textView_complemento = slideDialog.findViewById<TextView>(R.id.textView_complemento)
        var textView_bairro = slideDialog.findViewById<TextView>(R.id.textView_bairro)
        var textView_cidade = slideDialog.findViewById<TextView>(R.id.textView_cidade)
        var textView_estado = slideDialog.findViewById<TextView>(R.id.textView_estado)
        var textView_cep = slideDialog.findViewById<TextView>(R.id.textView_cep)

        img_back.setOnClickListener(View.OnClickListener { close() })

        textView_nome.setText(associado.nome)
        textView_razao.setText(associado.razaoSocial)
        textView_cpf.setText(associado.cpfCnpj)
        textView_inscricaoEstadual.setText(associado.inscricaoEstadual)
        textView_logradouro.setText(associado.logradouro)
        textView_complemento.setText(associado.complemento)
        textView_bairro.setText(associado.bairro)
        textView_cidade.setText(associado.cidade)
        textView_estado.setText(associado.estado)
        textView_cep.setText(associado.cep)

        slideDialog.show()
    }
}