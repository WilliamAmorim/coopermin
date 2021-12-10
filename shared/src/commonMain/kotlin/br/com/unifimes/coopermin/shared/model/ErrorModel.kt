package br.com.unifimes.coopermin.shared.model

class ErrorModel {
    private var error: Boolean? = false
        get() = field
        set(value) {
            field = value
        }
    var message: String? = null
        get() = field
        set(value) {
            field = value
        }


    var title: String? = null
        get() = field
        set(value) {
            field = value
        }
}