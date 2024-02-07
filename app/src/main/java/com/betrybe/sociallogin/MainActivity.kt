package com.betrybe.sociallogin

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class MainActivity : AppCompatActivity() {

    // iniciando projeto

    // crio as variáveis, digo que vou dar o valor delas depois com o lateinit e defino o tipo
    private lateinit var buttonLogin: Button
    private lateinit var textPassword: TextInputEditText
    private lateinit var textEmail: TextInputEditText
    private var isEmptyEmail = true
    private var isEmptyPassword = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // atribuo valor às variáveis. Preciso fazer isso dentro do escopo desta função onCreate
        buttonLogin = findViewById(R.id.login_button)
        textPassword = findViewById(R.id.password_text)
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
    }
    private fun enableButtonLogin() {
        buttonLogin.isEnabled = !isEmptyEmail && !isEmptyPassword
    }
}

