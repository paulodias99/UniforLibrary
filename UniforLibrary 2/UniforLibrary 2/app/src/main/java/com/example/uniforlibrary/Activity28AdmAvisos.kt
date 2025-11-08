package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Activity28AdmAvisos : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity28_adm_avisos)

        findViewById<Button>(R.id.btn_voltar_activity28_adm_avisos).setOnClickListener {
            finish()
        }


        val botaoHistorico = findViewById<MaterialButton>(R.id.button_historico_activity28_adm_avisos)
        val botaoMensagem = findViewById<MaterialButton>(R.id.button_mensagem_activity28_adm_avisos)


        val telaHistorico = findViewById<View>(R.id.layout_historico) //AQUI ALTERA
        val telaMensagem = findViewById<View>(R.id.layout_mensagem) // AQUI ALTERA

        botaoHistorico.setOnClickListener {
            Intent(this, Activity29AdmHistorico::class.java).also {
                startActivity(it)
            }
        }

        botaoMensagem.setOnClickListener {
            Intent(this, Activity30AdmPublicarAviso::class.java).also{
                startActivity(it)
            }
        }

    }
}
