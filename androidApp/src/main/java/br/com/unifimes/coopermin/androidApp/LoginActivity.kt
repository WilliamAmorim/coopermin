package br.com.unifimes.coopermin.androidApp

import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


private var passwordNotVisible = 1
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val img_back = findViewById<ImageView>(R.id.img_back)
        val textView_forgotSenha = findViewById<TextView>(R.id.textView_forgotSenha)
        val textView_semConta = findViewById<TextView>(R.id.textView_semConta)
        val editText_email = findViewById<EditText>(R.id.editText_email)
        val button_entrar = findViewById<Button>(R.id.button_entrar)
        val editText_password = findViewById<EditText>(R.id.editText_password)
        val frame_eye = findViewById<FrameLayout>(R.id.frame_eye)
        val img_eye1 = findViewById<ImageView>(R.id.img_eye1)
        val img_eye2 = findViewById<ImageView>(R.id.img_eye2)

        img_back.setOnClickListener { onBackPressed() }
        frame_eye.setOnClickListener {
            if (passwordNotVisible == 1) {
                img_eye1.visibility = View.VISIBLE
                img_eye2.visibility = View.GONE
                editText_password.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                passwordNotVisible = 0
            } else {
                img_eye1.visibility = View.GONE
                img_eye2.visibility = View.VISIBLE
                editText_password.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                passwordNotVisible = 1
            }
            editText_password.setSelection(editText_password.length())
        }

    }
}