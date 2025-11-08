package com.example.uniforlibrary

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.fragment.app.FragmentActivity

class Activity04UserHome : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity04_user_home)

        val btnHome = findViewById<ImageButton>(R.id.imageButtonHome)
        val btnBook = findViewById<ImageButton>(R.id.imageButtonBook)
        val btnChatbot = findViewById<ImageButton>(R.id.imageButtonMotherboard)
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
