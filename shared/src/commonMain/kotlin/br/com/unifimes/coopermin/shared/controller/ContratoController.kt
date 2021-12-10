package br.com.unifimes.coopermin.shared.controller

import br.com.unifimes.coopermin.shared.model.ContratoModel

class ContratoController {

    fun getAllContratos() : ArrayList<ContratoModel> {
        var contratosList: ArrayList<ContratoModel> = ArrayList()

        var contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)
        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 1
        contratosList.add(contrato)

        contrato = ContratoModel()
        contrato.idContrato = 15465
        contrato.status = 2
        contratosList.add(contrato)



        return contratosList
    }

    fun getIniciado(): ArrayList<ContratoModel>{
        var contratosList: ArrayList<ContratoModel> = ArrayList()

        var contrato = ContratoModel()


        return contratosList
    }

    fun getCancelado(): ArrayList<ContratoModel>{
        var contratosList: ArrayList<ContratoModel> = ArrayList()

        var contrato = ContratoModel()


        return contratosList

    }

    fun getCompleto(): ArrayList<ContratoModel>{
        var contratosList: ArrayList<ContratoModel> = ArrayList()

        var contrato = ContratoModel()


        return contratosList
    }
}