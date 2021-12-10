package br.com.unifimes.coopermin.androidApp.controller

import android.graphics.Color
import android.util.Patterns
import android.widget.EditText
import br.com.unifimes.coopermin.androidApp.*
import br.com.unifimes.coopermin.shared.controller.LoginController

class LoginControllerAndroid {


    fun logar(txtEmail: EditText,txtSenha: EditText): Boolean{
        if (getValidateEmailFormat(txtEmail) && getValidateSenha(txtSenha)) {
                return LoginController().fazerLogin(txtEmail.getText().toString(), txtSenha.getText().toString())
        } else {
            return false
        }
    }


    private fun getValidateEmailFormat(txtEmail: EditText): Boolean{
        var retorno = Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches()
        if(retorno){
            txtEmail.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_check_circle, 0);
            txtEmail.setTextColor(Color.parseColor("#000000"))
        }else{
            txtEmail.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            txtEmail.setTextColor(Color.parseColor("#f22c2c"))
        }
        return retorno
    }

    private fun getValidateSenha(txtSenha: EditText): Boolean{
        if(txtSenha.getText().isEmpty()){
            return false
        }
        return true
    }
}