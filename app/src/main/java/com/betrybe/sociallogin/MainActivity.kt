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
    private lateinit var inputEmail: TextInputLayout
    private lateinit var password: TextInputLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // atribuo valor às variáveis. Preciso fazer isso dentro do escopo desta função onCreate
        buttonLogin = findViewById(R.id.login_button)
        inputEmail = findViewById(R.id.email_text_input_layout)
        password = findViewById(R.id.password_text_input_layout)

        buttonLogin.setOnClickListener {
            enableButtonLogin()
        }
    }

    fun enableButtonLogin() {
        var emailText = inputEmail.editText.toString()
        var passwordText = password.editText.toString()

        if (!TextUtils.isEmpty(passwordText) && !TextUtils.isEmpty(emailText)) {
            buttonLogin.isEnabled
        }
    }
}

