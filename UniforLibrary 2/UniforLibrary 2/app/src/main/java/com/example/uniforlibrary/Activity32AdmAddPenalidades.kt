package com.example.uniforlibrary

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class Activity32AdmAddPenalidades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity32_adm_add_penalidades)

        findViewById<Button>(R.id.btn_voltar_activity32_adm_add_penalidades).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_aplicar_activity32_adm_penalidades).setOnClickListener {
            var matricula = findViewById<EditText>(R.id.eT_matricula_activity32_adm_add_penalidades).text.toString()
            var reserva = findViewById<EditText>(R.id.eT_reservas_activity32_adm_add_penalidades).text.toString()
            var agenda = findViewById<EditText>(R.id.eT_agendar_activity32_adm_add_penalidades).text.toString()

            if (matricula.isEmpty() or reserva.isEmpty() or agenda.isEmpty()){
                Toast.makeText(this, "Preencha os campos para continuar.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Mensagem publicada com sucesso.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}