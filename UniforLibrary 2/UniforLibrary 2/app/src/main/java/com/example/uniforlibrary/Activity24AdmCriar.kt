package com.example.uniforlibrary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity24AdmCriar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity24_adm_criar)

        findViewById<Button>(R.id.btn_voltar_activity24_adm_criar).setOnClickListener {
            finish()
        }


        findViewById<Button>(R.id.btn_criar_activity24_adm_criar).setOnClickListener {
            var nome = findViewById<EditText>(R.id.eT_nome_activity24_adm_criar).text.toString()
            var autor = findViewById<EditText>(R.id.eT_autor_activity24_adm_criar).text.toString()
            var codigo = findViewById<EditText>(R.id.eT_codigo_activity24_adm_criar).text.toString()
            var descricao = findViewById<EditText>(R.id.eT_descricao_activity24_adm_criar).text.toString()

            if (nome.isEmpty() or autor.isEmpty() or codigo.isEmpty() or descricao.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Livro criado com Sucesso.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}