package com.example.uniforlibrary

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity15SalaDeEstudos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity15_sala_de_estudos)

        var spinner_sala = findViewById<Spinner>(R.id.spinner_sala_activity15_sala_de_estudos)
        var spinner_cabine = findViewById<Spinner>(R.id.spinner_cabine_activity15_sala_de_estudos)

        var salas = arrayOf("Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5")
        var cabines = arrayOf("Cabine 1", "Cabine 2", "Cabine 3", "Cabine 4", "Cabine 5")

        var adpt_salas = ArrayAdapter(this, android.R.layout.simple_spinner_item, salas)
        var adpt_cabines = ArrayAdapter(this, android.R.layout.simple_spinner_item, cabines)

        adpt_salas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adpt_cabines.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner_sala.adapter = adpt_salas
        spinner_cabine.adapter = adpt_cabines


        var btn_circ = findViewById<Button>(R.id.btn_status_activity15_sala_de_estudos)
        btn_circ.tag = "Livre"

        // Função para verificar e atualizar o estado do botão
        fun atualizarEstadoBotao() {
            val salaSelecionada = spinner_sala.selectedItem.toString()
            val cabineSelecionada = spinner_cabine.selectedItem.toString()

            if (salaSelecionada == "Sala 1" && cabineSelecionada == "Cabine 2") {
                // Sala 1 + Cabine 2 = Ocupado (bloqueado)
                btn_circ.tag = "Ocupado_Bloqueado"
                btn_circ.text = "OCUPADO"
                btn_circ.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#F44336"))
            } else {
                // Qualquer outra combinação = Livre
                btn_circ.tag = "Livre"
                btn_circ.text = "LIVRE"
                btn_circ.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#4CAF50"))
            }
        }

// Listener para quando a sala mudar
        spinner_sala.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                atualizarEstadoBotao()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

// Listener para quando a cabine mudar
        spinner_cabine.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                atualizarEstadoBotao()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

// Listener do botão
        btn_circ.setOnClickListener {
            if (btn_circ.tag.equals("Ocupado_Bloqueado")) {
                // Se for Sala 1 + Cabine 2, mostrar Toast e não permitir mudança
                Toast.makeText(this, "A cabine está ocupada por outro usuário", Toast.LENGTH_SHORT).show()
            } else if (btn_circ.tag.equals("Livre")) {
                // Mudar para Ocupado
                btn_circ.tag = "Ocupado"
                btn_circ.text = "OCUPADO"
                btn_circ.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#F44336"))
            } else if (btn_circ.tag.equals("Ocupado")) {
                // Mudar para Livre
                btn_circ.tag = "Livre"
                btn_circ.text = "LIVRE"
                btn_circ.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#4CAF50"))
            }
        }


        val btnHome = findViewById<ImageButton>(R.id.imageButtonHome)
        val btnBook = findViewById<ImageButton>(R.id.imageButtonBook)
        val btnChatbot = findViewById<ImageButton>(R.id.imageButtonMotherbord)
        val btnMore = findViewById<ImageButton>(R.id.imageButtonMore)

        // HOME
        btnHome.setOnClickListener {
            startActivity(Intent(this, Activity04UserHome::class.java))
        }

        // ACERVOS
        btnBook.setOnClickListener {
            startActivity(Intent(this, Activity06UserAcervos::class.java))
        }

        // CHATBOT
        btnChatbot.setOnClickListener {
            startActivity(Intent(this, Activity05UserChatbot::class.java))
        }

        // MENU "MAIS"
        btnMore.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            popup.menuInflater.inflate(R.menu.menu_user_opcoes, popup.menu)
            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.menu_pedidos -> {
                        startActivity(Intent(this, Activity09UserPedidos::class.java))
                        true
                    }
                    R.id.menu_eventos -> {
                        startActivity(Intent(this, Activity11UserEventos::class.java))
                        true
                    }
                    R.id.menu_sala_estudos -> {
                        startActivity(Intent(this, Activity15SalaDeEstudos::class.java))
                        true
                    }
                    R.id.menu_sair -> {
                        startActivity(Intent(this, Activity01Login::class.java))
                        finish()
                        true
                    }
                    else -> false
                }
            }
            popup.show()
        }
    }
}