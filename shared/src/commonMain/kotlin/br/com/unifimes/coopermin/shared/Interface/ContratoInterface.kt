package br.com.unifimes.coopermin.shared.Interface

import br.com.unifimes.coopermin.shared.model.ContratoModel

interface ContratoInterface {

    fun getAllContratos() : ArrayList<ContratoModel>
    fun getAllContratos(id : String) : ArrayList<ContratoModel>

    fun getIniciado(): ArrayList<ContratoModel>
    fun getIniciado(id: String): ArrayList<ContratoModel>

    fun getCancelado(): ArrayList<ContratoModel>
    fun getCancelado(id: String): ArrayList<ContratoModel>

    fun getCompleto(): ArrayList<ContratoModel>
    fun getCompleto(id: String): ArrayList<ContratoModel>
}