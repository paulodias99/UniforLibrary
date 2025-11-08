package com.example.uniforlibrary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity27AdmEdicao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity27_adm_edicao)

        findViewById<Button>(R.id.btn_voltar_activity27_adm_edicao).setOnClickListener {
            finish()
        }


        findViewById<Button>(R.id.btn_editar_activity27_adm_edicao).setOnClickListener {
            var nome = findViewById<EditText>(R.id.eT_nome_activity27_adm_edicao).text.toString()
            var autor = findViewById<EditText>(R.id.eT_autor_activity27_adm_edicao).text.toString()
            var codigo = findViewById<EditText>(R.id.eT_codigo_activity27_adm_edicao).text.toString()
            var descricao = findViewById<EditText>(R.id.eT_descricao_activity27_adm_edicao).text.toString()

            if (nome.isEmpty() or autor.isEmpty() or codigo.isEmpty() or descricao.isEmpty()){
                Toast.makeText(this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Livro editado com Sucesso!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}