package com.example.uniforlibrary

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity10UserDetalhes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity10_user_detalhes)

        // botão voltar
        findViewById<Button>(R.id.btn_voltar_activity10_user_detalhes).setOnClickListener {
            finish()
        }

        // pega dados enviados pela intent
        val nomeLivro = intent.getStringExtra("nomeLivro")
        val autorLivro = intent.getStringExtra("autorLivro")

        // atualiza os textos
        findViewById<TextView>(R.id.textView_nome_activity10_user_detalhes).text = nomeLivro ?: "Desconhecido"
        findViewById<TextView>(R.id.textView_autor_activity10_user_detalhes).text = autorLivro ?: "Desconhecido"
    }
}
