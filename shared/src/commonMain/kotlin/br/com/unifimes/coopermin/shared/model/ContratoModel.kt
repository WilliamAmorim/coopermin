package br.com.unifimes.coopermin.shared.model

class ContratoModel {

    var idContrato: Int? = 125
        get() = field
        set(value) {
            field = value
        }
    private var idAssociado: Int? = 12
        get() = field
        set(value) {
            field = value
        }
    private var idCliente: Int? = 2
        get() = field
        set(value) {
            field = value
        }
    private var dataEmissao: String? = "2021-11-04 10:15:14"
        get() = field
        set(value) {
            field = value
        }
    private var dataEntrega: String? = "2021-11-08 10:15:14"
        get() = field
        set(value) {
            field = value
        }
    private var valor: Float? = 10000F
        get() = field
        set(value) {
            field = value
        }
    private  var desconto: Float? = 0.1F
        get() = field
        set(value) {
            field = value
        }
    var status: Int? = 1
        get() = field
        set(value) {
            field = value
        }


}