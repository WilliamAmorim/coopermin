package br.com.unifimes.coopermin.shared.Interface

import br.com.unifimes.coopermin.shared.model.AssociadoModel

interface AssociadoInterface {

    fun getAllAssociado() : ArrayList<AssociadoModel>
    fun getAssociado(id : String) : ArrayList<AssociadoModel>

    fun searchAssociado(query: String) : ArrayList<AssociadoModel>

}