package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity


class Activity01Login : FragmentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity01_login)

        findViewById<Button>(R.id.btn_entrar_activity01_login).setOnClickListener {
            var matricula = findViewById<EditText>(R.id.eT_matricula_activity01_login).text.toString()
            var senha = findViewById<EditText>(R.id.eT_senha_activity01_login).text.toString()

            if (matricula.isEmpty() or  senha.isEmpty()){
                Toast.makeText(this, "Por favor preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
            else{
                if(senha == "1"){
                    Intent(this, Activity04UserHome::class.java).also {
                        startActivity(it)
                    }
                }
                else if(senha == "2"){
                    Intent(this, Activity16AdmHome::class.java).also {
                        startActivity(it)
                    }
                }else{
                    Toast.makeText(this, "Credenciais incorretas, tente novamente", Toast.LENGTH_SHORT).show()
                }
            }


        }

        findViewById<TextView>(R.id.textView_esqueceu_activity01_login).setOnClickListener {
            Intent(this, Activity02EsqueceuSenha1::class.java).also {
                startActivity(it)
            }
        }

        findViewById<TextView>(R.id.textView_cadastro_activity01_login).setOnClickListener {
            Intent(this, Activity03Cadastro::class.java).also {
                startActivity(it)
            }
        }

    }
}