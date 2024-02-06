package com.betrybe.sociallogin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    // iniciando projeto

    // crio as variáveis, digo que vou dar o valor delas depois com o lateinit e defino o tipo
    private lateinit var buttonLogin: Button
    private lateinit var inputEmail: TextInputEditText
    private lateinit var password: TextInputEditText
    private var isInputEmail = false
    private var isPassword = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // atribuo valor às variáveis. Preciso fazer isso dentro do escopo desta função onCreate
        buttonLogin = findViewById(R.id.login_button)
        inputEmail = findViewById(R.id.email_text_input_layout)
        password = findViewById(R.id.password_text_input_layout)


        inputEmail.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                enableButtonLogin()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                enableButtonLogin()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }
    fun enableButtonLogin() {
        if (password.length() > 0 && inputEmail.length() > 0 ) {
            buttonLogin.isEnabled
        }
    }
}

