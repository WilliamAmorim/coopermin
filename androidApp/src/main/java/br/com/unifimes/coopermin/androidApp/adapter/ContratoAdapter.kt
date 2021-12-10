package br.com.unifimes.coopermin.androidApp.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unifimes.coopermin.androidApp.R
import br.com.unifimes.coopermin.androidApp.utils.Navigation
import br.com.unifimes.coopermin.androidApp.utils.Popup
import br.com.unifimes.coopermin.androidApp.utils.Utils
import br.com.unifimes.coopermin.shared.controller.DetalheContratoController
import br.com.unifimes.coopermin.shared.model.ContratoModel

class ContratoAdapter : RecyclerView.Adapter<ContratoAdapter.ViewHolder>() {
    var contratosList: ArrayList<ContratoModel> = ArrayList()

    fun ContratoAdapter(contratosList: ArrayList<ContratoModel>){
        this.contratosList = contratosList
    }

    var remetente: Activity? = null
    var destino: Class<*>? = null
    fun setNavigation(remetente: Activity?, destino: Class<*>?) {
        this.remetente = remetente
        this.destino = destino
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_order, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView_idContrato?.text = "Contrato numero : "+this.contratosList.get(position).idContrato

        holder.contratoLayout?.setOnClickListener(View.OnClickListener {
            if(Utils().verificarConexao(remetente)) {
                var popup = Popup()
                popup.showPopupLoaging(remetente)
                if (DetalheContratoController().openContrato(this.contratosList.get(position).idContrato)) {
                    Navigation().abrirActivity(remetente, destino)
                    popup.close()
                }else{
                    popup.close()
                    popup.showPopupError(remetente,remetente?.getString(R.string.titulo_error).toString(),remetente?.getString(R.string.mensagem_error).toString())
                }
            }else{
                Popup().showPopupError(remetente,
                    remetente?.getString(R.string.sem_internet).toString(),remetente?.getString(R.string.sem_internet_3).toString())
            }
        })

        if(this.contratosList.get(position).status == 1){
            holder.img_bg?.setImageResource(R.drawable.rectangle_left_cure_blue)
            holder.textView_status?.setText("Aberto")
        }else if(this.contratosList.get(position).status == 2){
            holder.img_bg?.setImageResource(R.drawable.rectangle_left_cure_red)
            holder.textView_status?.setText("Cancelado")
        }else if(this.contratosList.get(position).status == 3){
            holder.img_bg?.setImageResource(R.drawable.rectangle_left_cure_green)
            holder.textView_status?.setText("Concluido")
        }

    }

    override fun getItemCount(): Int { return this.contratosList.size }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var img_bg: ImageView? = null
        var textView_idContrato: TextView? = null
        var textView_dateTime: TextView? = null
        var textView_status: TextView? = null
        var textView_itemCount: TextView? = null
        var textView_valor: TextView? = null
        var contratoLayout: LinearLayout? = null

        init {
            img_bg = itemView.findViewById(R.id.img_bg)
            textView_idContrato = itemView.findViewById(R.id.textView_idContrato)
            textView_dateTime = itemView.findViewById(R.id.textView_dateTime)
            textView_status = itemView.findViewById(R.id.textView_status)
            textView_itemCount = itemView.findViewById(R.id.textView_itemCount)
            textView_valor = itemView.findViewById(R.id.textView_valor)
            contratoLayout = itemView.findViewById(R.id.contratoLayout)

        }
    }




}