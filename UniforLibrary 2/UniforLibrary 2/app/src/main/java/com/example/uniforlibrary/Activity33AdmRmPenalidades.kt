package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity33AdmRmPenalidades : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity33_adm_rm_penalidades)

        findViewById<Button>(R.id.btn_voltar_activity33_adm_rm_penalidades).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_remover_activity33_adm_rm_penalidades).setOnClickListener {
            var matricula = findViewById<EditText>(R.id.eT_matricula_activity33_adm_rm_penalidades).text.toString()

            if (matricula.isEmpty()){
                Toast.makeText(this, "Preencha os campos para continuar.", Toast.LENGTH_SHORT).show()
            }
            else if (matricula == "1"){
                Toast.makeText(this, "O aluno com a matricula fornecida não possui penalidades", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Penalidade removida com Sucesso!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}