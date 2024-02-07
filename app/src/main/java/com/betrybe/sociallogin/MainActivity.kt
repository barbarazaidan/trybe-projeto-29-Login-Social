package com.betrybe.sociallogin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern



class MainActivity : AppCompatActivity() {

    // iniciando projeto

    // crio as variáveis, digo que vou dar o valor delas depois com o lateinit e defino o tipo
    // usei como referência para desenvolver a validação do botão de login o vídeo https://www.youtube.com/watch?v=Frv-6bDslxE
    private lateinit var buttonLogin: Button
    private lateinit var textPassword: TextInputEditText
    private lateinit var passwordInput: TextInputLayout
    private lateinit var textEmail: TextInputEditText
    private var isEmptyEmail = true
    private var isEmptyPassword = true
    private val emailRegex = "/S+@+w+.+[c]+[0]+[m]/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // atribuo valor às variáveis. Preciso fazer isso dentro do escopo desta função onCreate
        buttonLogin = findViewById(R.id.login_button)
        textPassword = findViewById(R.id.password_text)
        passwordInput = findViewById(R.id.password_text_input_layout)
        textEmail = findViewById(R.id.email_text)

        textPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                // preciso usar o .text , .toString() e o .trim() para conseguir
                // fazer a validação do campo vazio, incluindo quando a pessoa clica apenas
                // no backspace
                isEmptyPassword = textPassword.text.toString().trim().isEmpty()
                enableButtonLogin()
            }
        })

        textEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isEmptyEmail = textEmail.text.toString().trim().isEmpty()
                enableButtonLogin()
            }
        })

        buttonLogin.setOnClickListener {
            val passwordSize = textPassword.text.toString().length
            print(passwordSize)
            if (passwordSize <= 4) {
                passwordInput.error = "Senha deve ter mais de 4 caracteres"
            } else {
                passwordInput.error = null
            }
        }
    }
    private fun enableButtonLogin() {
        buttonLogin.isEnabled = !isEmptyEmail && !isEmptyPassword
    }
}

