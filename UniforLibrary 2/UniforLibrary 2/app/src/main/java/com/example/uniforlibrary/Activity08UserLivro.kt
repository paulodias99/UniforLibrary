package com.example.uniforlibrary

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity08UserLivro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity08_user_livro)

        findViewById<Button>(R.id.btn_voltar_activity08_user_livro).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_reservar_activity08_user_livro).setOnClickListener{
            Toast.makeText(this, "Livro reservado com sucesso", Toast.LENGTH_SHORT).show()
        }

        var coracao = findViewById<ImageButton>(R.id.btn_coracao_activity08_user_livro)

        coracao.tag = "empty"

        coracao.setOnClickListener {
            if (coracao.tag == "empty"){
                coracao.setBackgroundResource(R.drawable.ic_heart_full)
                coracao.tag = "full"
            }
            else{
                coracao.setBackgroundResource(R.drawable.ic_heart_empty)
                coracao.tag = "empty"
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