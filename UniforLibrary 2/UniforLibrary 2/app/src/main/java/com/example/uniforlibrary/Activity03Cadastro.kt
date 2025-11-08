package com.example.uniforlibrary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity03Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_activity03_cadastro)


        findViewById<Button>(R.id.btn_voltar_activity03_cadastro).setOnClickListener {
            finish()
        }


        findViewById<Button>(R.id.btn_cadastrar_activity03_cadastro).setOnClickListener {
            var matricula = findViewById<EditText>(R.id.et_matricula_activity03_cadastro).text.toString()
            var senha = findViewById<EditText>(R.id.et_senha_activity03_cadastro).text.toString()

            if(matricula.isEmpty() or senha.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos e tente novamente", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Matriculas criadas com sucesso", Toast.LENGTH_SHORT).show()
            }
        }

    }
}