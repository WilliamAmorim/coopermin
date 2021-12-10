package br.com.unifimes.coopermin.androidApp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.unifimes.coopermin.androidApp.R

class FilterGridAdapter : RecyclerView.Adapter<FilterGridAdapter.ViewHolder>() {

    var categories: ArrayList<String> = ArrayList()
    lateinit var selected : String
    var myPos = -1

    fun setConteudo(categories : ArrayList<String>){
        this.categories = categories
    }

    fun getSelectedCategory(): String{
        return categories.get(myPos)
    }

    fun setSelectedCategory(selecionada : String){
        selected = selecionada
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(
            R.layout.adapter_filter_categories,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtMilkProduct!!.setText(this.categories.get(position))

        if (myPos == position) {
            holder.txtMilkProduct!!.setBackgroundResource(R.drawable.rectangle_green_btn)
            holder.txtMilkProduct!!.setTextColor(Color.parseColor("#ffffff"))

        } else {
            holder.txtMilkProduct!!.setBackgroundColor(Color.parseColor("#00000000"))
            holder.txtMilkProduct!!.setTextColor(Color.parseColor("#a2a2a2"))
        }

        if(selected.equals(this.categories.get(position))){
            holder.txtMilkProduct!!.setBackgroundResource(R.drawable.rectangle_green_btn)
            holder.txtMilkProduct!!.setTextColor(Color.parseColor("#ffffff"))
            selected = null.toString()
        }
        holder.txtMilkProduct!!.setOnClickListener {
            myPos = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
       return this.categories.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtMilkProduct: TextView? = null
        init{
            txtMilkProduct = itemView.findViewById(R.id.txtMilkProduct)
        }
    }
}