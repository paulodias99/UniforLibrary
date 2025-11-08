package com.example.uniforlibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity22AdmPermitirEvento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity22_adm_permitir_evento)

        findViewById<Button>(R.id.btn_voltar_activity22_adm_permitir_evento).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_recursar_activity22_adm_permitir_evento).setOnClickListener {
            Intent(this, Activity22AdmPermitirEvento2::class.java).also {
                startActivity(it)
            }
        }

        findViewById<Button>(R.id.btn_permitir_activity22_adm_permitir_evento).setOnClickListener {
            Intent(this, Activity22AdmPermitirEvento2::class.java).also {
                startActivity(it)
            }
        }

    }
}