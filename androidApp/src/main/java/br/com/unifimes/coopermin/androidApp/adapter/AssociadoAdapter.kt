package br.com.unifimes.coopermin.androidApp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import br.com.unifimes.coopermin.androidApp.R
import br.com.unifimes.coopermin.androidApp.utils.Popup
import br.com.unifimes.coopermin.shared.model.AssociadoModel

class AssociadoAdapter : RecyclerView.Adapter<AssociadoAdapter.ViewHolder>()  {
    var associadoList: ArrayList<AssociadoModel> = ArrayList()
    var activity: Activity? = null

    fun inicializeActivity(activity: Activity){
        this.activity = activity
    }

    fun inicializeAssociadoList(associadoList: ArrayList<AssociadoModel>){
        this.associadoList = associadoList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssociadoAdapter.ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_associado, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AssociadoAdapter.ViewHolder, position: Int) {
        holder.textView_nome?.setText(this.associadoList.get(position).nome)
        holder.textView_endereco?.setText(this.associadoList.get(position).logradouro)
        holder.textView_razaoSocial?.setText(this.associadoList.get(position).razaoSocial)
        holder.layout_associado?.setOnClickListener(View.OnClickListener {
            this.activity?.let { it1 -> Popup().showPopupAssociado(it1,this.associadoList.get(position)) }
        })

    }

    override fun getItemCount(): Int {
        return this.associadoList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var textView_nome: TextView? = null
        var textView_endereco: TextView? = null
        var textView_razaoSocial: TextView? = null
        var layout_associado: LinearLayout? = null

        init {
            textView_nome = itemView.findViewById(R.id.textView_nome)
            textView_endereco = itemView.findViewById(R.id.textView_endereco)
            textView_razaoSocial = itemView.findViewById(R.id.textView_razaoSocial)
            layout_associado = itemView.findViewById(R.id.layout_associado)
        }
    }
}