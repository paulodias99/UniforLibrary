package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.fragment.app.FragmentActivity

class Activity17AdmAlunos : FragmentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity17_adm_alunos)

        findViewById<Button>(R.id.btn_voltar_activity17_adm_alunos).setOnClickListener {
            finish()
        }

        findViewById<LinearLayout>(R.id.linearLayout_lista_activity17_adm_alunos).setOnClickListener {
            Intent(this, Activity18AdmAlunoEsp::class.java).also {
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