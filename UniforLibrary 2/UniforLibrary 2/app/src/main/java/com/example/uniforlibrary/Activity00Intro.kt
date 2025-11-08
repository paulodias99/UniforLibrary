package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Activity00Intro : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity00_intro)

        var imagem = findViewById<ImageView>(R.id.imageView_logos_activity00_intro)
        var btnNext = findViewById<Button>(R.id.btn_proximo_activity00_intro)
        var texto1 = findViewById<TextView>(R.id.textView_titulo_activity00_intro)
        var texto2 = findViewById<TextView>(R.id.textView_subtitulo_activity00_intro)
        var textoPular = findViewById<TextView>(R.id.textView_pular_activity00)
        var ir_login : String

        var contador: Int = 0

        btnNext.setOnClickListener {
            ir_login = treatPress(contador, imagem, texto1, texto2)
            if (ir_login == "SAIR"){
                var intent = Intent(this, Activity01Login::class.java)
                startActivity(intent)
            }
            contador ++
        }

        textoPular.setOnClickListener {
            var intent = Intent(this, Activity01Login::class.java)
            startActivity(intent)
        }

    }

    fun treatPress(contador: Int, imagem: ImageView, texto1: TextView, texto2: TextView): String{
        if(contador == 0){
            texto1.text = "Verifique em tempo \n real a disponibilidade!"
            texto2.text = "Consiga livros de forma \n on-line sem sair de casa!"
            imagem.setImageResource(R.drawable.logo_pc)
            return "NAO"
        }
        else if(contador == 1){
            texto1.text = "Converse com uma \n inteligencia Artificial!"
            texto2.text = "Descubra os melhores \n livros disponíveis!"
            imagem.setImageResource(R.drawable.logo_gpt)
            return "NAO"
        }
        else if (contador == 2){
            return "SAIR"
        }
        return "NAO"
    }

    }