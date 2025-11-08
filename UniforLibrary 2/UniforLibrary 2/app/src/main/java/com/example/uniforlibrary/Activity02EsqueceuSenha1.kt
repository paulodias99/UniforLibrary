package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

class Activity02EsqueceuSenha1 : FragmentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity02_esqueceu_senha1)

        findViewById<Button>(R.id.btn_voltar_activity02_esqueceu_senha).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_continuar_activity02_esqueceu_senha).setOnClickListener {
            var text = findViewById<EditText>(R.id.eT_matricula_activity02_esqueceu_senha).text.toString()

            if (text.isEmpty()){
                Toast.makeText(this, "A matricula informada não existe", Toast.LENGTH_SHORT).show()
            }
            else{
                Intent(this, Activity03EsqueceuSenha2::class.java).also {
                    startActivity(it)
                }
            }
        }



    }
}