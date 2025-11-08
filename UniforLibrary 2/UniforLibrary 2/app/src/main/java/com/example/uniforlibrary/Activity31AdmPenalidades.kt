package com.example.uniforlibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity31AdmPenalidades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity31_adm_penalidades)


        var btn_voltar: Button = findViewById<Button>(R.id.btn_voltar_activity31_adm_penalidades)
        var btn_add = findViewById<Button>(R.id.btn_aplicar_activity31_adm_penalidades)
        var btn_rm = findViewById<Button>(R.id.btn_remover_activity31_adm_penalidades)

        btn_voltar.setOnClickListener {
            finish()
        }

        btn_add.setOnClickListener {
            Intent(this, Activity32AdmAddPenalidades::class.java).also {
                startActivity(it)
            }
        }

        btn_rm.setOnClickListener {
            Intent(this, Activity33AdmRmPenalidades::class.java).also {
                startActivity(it)
            }
        }
    }
}