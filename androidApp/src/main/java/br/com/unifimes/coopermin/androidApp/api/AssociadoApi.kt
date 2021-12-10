package br.com.unifimes.coopermin.androidApp.api

import br.com.unifimes.coopermin.shared.Interface.AssociadoInterface
import br.com.unifimes.coopermin.shared.model.AssociadoModel

class AssociadoApi : AssociadoInterface {
    override fun getAllAssociado(): ArrayList<AssociadoModel> {
        var associadoList: ArrayList<AssociadoModel> = ArrayList()
        var associado = AssociadoModel()
        associado.nome = "Lucas"
        associado.logradouro = "Avenida Antônio Carlos"
        associado.razaoSocial = "Razão"
        associado.cpfCnpj = "597.657.221-92"
        associado.inscricaoEstadual = "1654873551"
        associado.complemento = "Quadra 119 Lote 02"
        associado.bairro = "Setor Costa Nery"
        associado.cidade = "Mineiros"
        associado.estado = "GO"
        associado.cep = "75834-970"
        associadoList.add(associado)

        associado = AssociadoModel()
        associado.nome = "Mateus"
        associado.logradouro = "Avenida Quarta 62"
        associado.razaoSocial = "Fazenda Montes claros"
        associado.cpfCnpj = "574.702.171-00"
        associado.inscricaoEstadual = "4654457"
        associado.complemento = ""
        associado.bairro = "Setor Central"
        associado.cidade = "Mineiros"
        associado.estado = "GO"
        associado.cep = "75834-970"

        associadoList.add(associado)

        associado = AssociadoModel()
        associado.nome = "Algusto"
        associado.logradouro = "Setor Central"
        associado.razaoSocial = "Fazenda Montes claros"
        associado.cpfCnpj = "059.129.381-15"
        associado.inscricaoEstadual = "15645489"
        associado.complemento = "Quadra 34 Lote 5"
        associado.bairro = "Cunha Rezende"
        associado.cidade = "Mineiros"
        associado.estado = "GO"
        associado.cep = "75834-970"
        associadoList.add(associado)

        return associadoList
    }

    override fun getAssociado(id: String): ArrayList<AssociadoModel> {
        TODO("Not yet implemented")
    }

    override fun searchAssociado(query: String): ArrayList<AssociadoModel> {
        TODO("Not yet implemented")
    }


}