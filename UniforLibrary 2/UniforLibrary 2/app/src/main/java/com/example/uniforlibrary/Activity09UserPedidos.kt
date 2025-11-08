package com.example.uniforlibrary

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import androidx.fragment.app.FragmentActivity

class Activity09UserPedidos : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity09_user_pedidos)

        // Lista de IDs e nomes dos livros
        val livros = listOf(
            R.id.itemLivro1 to "Livro 1",
            R.id.itemLivro2 to "Livro 2",
            R.id.itemLivro3 to "Livro 3",
            R.id.itemLivro4 to "Livro 4",
            R.id.itemLivro5 to "Livro 5",
            R.id.itemLivro6 to "Livro 6",
            R.id.itemLivro7 to "Livro 7",
            R.id.itemLivro8 to "Livro 8",
            R.id.itemLivro9 to "Livro 9",
            R.id.itemLivro10 to "Livro 10",
        )

        // Define clique para cada item
        livros.forEach { (id, nomeLivro) ->
            val item = findViewById<LinearLayout>(id)
            item.setOnClickListener {
                val intent = Intent(this, Activity10UserDetalhes::class.java)
                intent.putExtra("nomeLivro", nomeLivro)
                startActivity(intent)
            }
        }

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
