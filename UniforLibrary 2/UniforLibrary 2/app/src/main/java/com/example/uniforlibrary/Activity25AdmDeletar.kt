package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity
import com.google.android.material.button.MaterialButton

/**
 * Loads [MainFragment17].
 */
class Activity25AdmDeletar : FragmentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity25_adm_deletar)

        findViewById<Button>(R.id.btn_voltar_activity25_adm_deletar).setOnClickListener {
            finish()
        }

        fun showConfirmDeleteDialog(
            bookName: String,
            onConfirm: () -> Unit,
            onCancel: (() -> Unit)? = null
        ) {
            val inflater = LayoutInflater.from(this) // se estiver em Fragment, use requireContext()
            val view = inflater.inflate(R.layout.dialog_confirm_delete, null)

            val tvMensagem = view.findViewById<TextView>(R.id.tvMensagem)
            val btnDeletar = view.findViewById<MaterialButton>(R.id.btnDeletar)
            val btnCancelar = view.findViewById<MaterialButton>(R.id.btnCancelar)

            tvMensagem.text = "Deseja mesmo deletar o livro “$bookName”?"

            val dialog = AlertDialog.Builder(this)
                .setView(view)
                .setCancelable(true)
                .create()

            // Fundo transparente da janela para manter o shape do layout
            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

            btnDeletar.setOnClickListener {
                dialog.dismiss()
                onConfirm()
            }

            btnCancelar.setOnClickListener {
                dialog.dismiss()
                onCancel?.invoke()
            }

            dialog.show()
        }


        findViewById<LinearLayout>(R.id.linearLayout_livros_activity25_adm_deletar).setOnClickListener {
            showConfirmDeleteDialog(
                bookName = "<nome_livro>",
                onConfirm = {
                    // lógica para deletar o livro
                    Toast.makeText(this, "Livro deletado", Toast.LENGTH_SHORT).show()
                },
                onCancel = {
                    Toast.makeText(this, "Ação de Deletar Cancelada", Toast.LENGTH_SHORT).show()
                }
            )
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