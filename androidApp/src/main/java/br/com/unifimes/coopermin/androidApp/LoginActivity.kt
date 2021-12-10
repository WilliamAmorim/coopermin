package br.com.unifimes.coopermin.androidApp

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import br.com.unifimes.coopermin.androidApp.api.HttpHelper
import br.com.unifimes.coopermin.androidApp.api.LoginApi
import br.com.unifimes.coopermin.androidApp.controller.LoginControllerAndroid
import br.com.unifimes.coopermin.androidApp.utils.Popup
import br.com.unifimes.coopermin.androidApp.utils.Utils
import br.com.unifimes.coopermin.shared.controller.LoginController
import org.jetbrains.anko.doAsync


private lateinit var img_back: ImageView
private lateinit var textView_forgotSenha: TextView
private lateinit var textView_semConta: TextView
private lateinit var editText_email: EditText
private lateinit var editText_password: EditText
private lateinit var button_entrar: Button
private lateinit var frame_eye: FrameLayout
private lateinit var img_eye1: ImageView
private lateinit var img_eye2: ImageView
private var popup = Popup()


private var passwordNotVisible = 1
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        img_back = findViewById(R.id.img_back)
        textView_forgotSenha = findViewById(R.id.textView_forgotSenha)
        textView_semConta = findViewById(R.id.textView_semConta)
        editText_email = findViewById(R.id.editText_email)
        button_entrar = findViewById(R.id.button_entrar)
        editText_password = findViewById(R.id.editText_password)
        frame_eye = findViewById(R.id.frame_eye)
        img_eye1 = findViewById(R.id.img_eye1)
        img_eye2 = findViewById(R.id.img_eye2)

        validateEmailFormat(editText_email)

        img_back.setOnClickListener { onBackPressed() }

        button_entrar.setOnClickListener(View.OnClickListener {
            popup.showPopupLoaging(this)

            val resposta = LoginControllerAndroid().logar(editText_email, editText_password)

            popup.close()

            if(!resposta){
                popup.showPopupError(this,getString(R.string.titulo_error),getString(R.string.mensagem_error))
            }else{
                Utils().abrirActivity(this,HomeActivity::class.java)
            }
        })

        visualizarSenha()
    }

    /**
     * Metodo criado para visualizar a senha a senha
     */
    private fun visualizarSenha(){
        frame_eye.setOnClickListener {
            if (passwordNotVisible == 1) {
                img_eye1.visibility = View.VISIBLE
                img_eye2.visibility = View.GONE
                editText_password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                passwordNotVisible = 0
            } else {
                img_eye1.visibility = View.GONE
                img_eye2.visibility = View.VISIBLE
                editText_password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                passwordNotVisible = 1
            }
            editText_password.setSelection(editText_password.length())
        }
    }

    /**
     * Validar se o formate de email digitado pelo usuario esta certo
     */
    private fun validateEmailFormat(txtEmail: EditText) {
        txtEmail.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
            } else {
                var retorno = Patterns.EMAIL_ADDRESS.matcher(txtEmail.getText().toString()).matches()

                if (retorno) {
                    txtEmail.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_check_circle,
                        0
                    );
                    txtEmail.setTextColor(Color.parseColor("#000000"))
                } else {
                    txtEmail.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    txtEmail.setTextColor(Color.parseColor("#f22c2c"))
                }
            }
        }
    }
}