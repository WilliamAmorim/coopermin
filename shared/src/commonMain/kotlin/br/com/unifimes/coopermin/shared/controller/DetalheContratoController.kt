package br.com.unifimes.coopermin.shared.controller

import br.com.unifimes.coopermin.shared.model.AssociadoModel
import br.com.unifimes.coopermin.shared.model.ClienteModel

class DetalheContratoController {

    var clienteModel = ClienteModel()
        get() = field
        set(value) {
            field = value
        }
    var associadoModel = AssociadoModel()
        get() = field
        set(value) {
            field = value
        }


    fun openContrato(idContrato: Int?): Boolean{
        try{
            return true
        }catch(ex : Exception){
            return false
        }
    }
}