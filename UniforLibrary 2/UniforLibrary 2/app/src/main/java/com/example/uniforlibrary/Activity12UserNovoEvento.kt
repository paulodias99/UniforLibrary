package com.example.uniforlibrary

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity12UserNovoEvento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity12_user_novo_evento)

        findViewById<Button>(R.id.btn_voltar_activity12_user_novo_evento).setOnClickListener {
            finish()
        }


        var spinner_sala = findViewById<Spinner>(R.id.spinner_sala_activity12_user_novo_evento)
        var spinner_horario = findViewById<Spinner>(R.id.spinner_horario_activity12_user_novo_evento)

        var salas = arrayOf("Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5", )
        var horarios = arrayOf("MAB", "MCD", "MEF", "TAB", "TCD", "TEF", "NAB", "NCD")

        var adpt_salas = ArrayAdapter(this, android.R.layout.simple_spinner_item, salas)
        var adpt_horarios = ArrayAdapter(this, android.R.layout.simple_spinner_item, horarios)

        adpt_salas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpt_horarios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_sala.adapter = adpt_salas
        spinner_horario.adapter = adpt_horarios

        findViewById<Button>(R.id.btn_requisitar_activity12_user_novo_evento).setOnClickListener {
            var nome_evento = findViewById<EditText>(R.id.eT_nomeEvento_activity12_user_novo_evento).text.toString()
            var data_evento = findViewById<EditText>(R.id.eT_data_activity12_user_novo_evento).text.toString()
            var descricao = findViewById<EditText>(R.id.eT_descricao_activity12_user_novo_evento).text.toString()
            var sala = spinner_sala.selectedItem.toString()
            var hora = spinner_horario.selectedItem.toString()

            if(nome_evento.isEmpty() or data_evento.isEmpty() or descricao.isEmpty()){
                Toast.makeText(this, "Por favor preencha todos os espaços.", Toast.LENGTH_SHORT).show()
            }
            else if (data_evento.equals("25122025") and sala.equals("Sala 1") and hora.equals("MAB")){
                Toast.makeText(this, "Um evento já está agendado para as informações fornecidas.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Evento Requisitado com Sucesso!.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}