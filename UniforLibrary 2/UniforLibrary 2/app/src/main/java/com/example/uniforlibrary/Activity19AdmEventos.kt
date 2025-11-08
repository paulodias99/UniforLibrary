package com.example.uniforlibrary

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Activity19AdmEventos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity19_adm_eventos)


        val botaoProgramacao = findViewById<MaterialButton>(R.id.button_programacao_activity19_adm_eventos)
        val botaoCriar = findViewById<MaterialButton>(R.id.button_criar_activity19_adm_eventos)
        val botaoPermitir = findViewById<MaterialButton>(R.id.button_permitir_activity19_adm_eventos)


        botaoProgramacao.setOnClickListener {
            Intent(this, Activity20AdmProgramacao::class.java).also {
                startActivity(it)
            }
        }

        botaoCriar.setOnClickListener {
            Intent(this, Activity21AdmNovoEvento::class.java).also {
                startActivity(it)
            }
        }

        botaoPermitir.setOnClickListener {
            Intent(this, Activity22AdmPermitirEvento::class.java).also {
                startActivity(it)
            }
        }

        val btnHome = findViewById<ImageButton>(R.id.imageButtonHome)
        val btnBook = findViewById<ImageButton>(R.id.imageButtonUser)
        val btnChatbot = findViewById<ImageButton>(R.id.imageButtonMotherbord)
        val btnMore = findViewById<ImageButton>(R.id.imageButtonMore)

        // HOME
        btnHome.setOnClickListener {
            startActivity(Intent(this, Activity16AdmHome::class.java))
        }

        // ALUNOS
        btnBook.setOnClickListener {
            startActivity(Intent(this, Activity17AdmAlunos::class.java))
        }

        // ACERVOS
        btnChatbot.setOnClickListener {
            startActivity(Intent(this, Activity23AdmAcervos::class.java))
        }

        // MENU "MAIS"
        btnMore.setOnClickListener { view ->
            val popup = PopupMenu(this, view)
            popup.menuInflater.inflate(R.menu.menu_adm_opcoes, popup.menu)
            popup.setOnMenuItemClickListener { item: MenuItem ->
                when (item.itemId) {
                    R.id.menu_eventos -> {
                        startActivity(Intent(this, Activity19AdmEventos::class.java))
                        true
                    }
                    R.id.menu_avisos -> {
                        startActivity(Intent(this, Activity28AdmAvisos::class.java))
                        true
                    }
                    R.id.menu_penalidades -> {
                        startActivity(Intent(this, Activity31AdmPenalidades::class.java))
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
