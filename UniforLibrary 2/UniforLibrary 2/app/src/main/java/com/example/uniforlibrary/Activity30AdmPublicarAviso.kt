package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class Activity30AdmPublicarAviso : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity30_adm_publicar_aviso)

        val btn_publicar = findViewById<Button>(R.id.btn_publicar_activity30_adm_publicar_aviso)
        btn_publicar.setOnClickListener{
            // Get the text from the fields
            var titulo = findViewById<TextInputEditText>(R.id.eT_titulo_activity30_adm_publicar_aviso).text.toString()
            var mensagem_Input = findViewById<TextInputEditText>(R.id.eT_mensagem_activity30_adm_publicar_aviso).text.toString()

            lateinit var tipo: String
            lateinit var mensagem: String

            if (titulo.isEmpty() || mensagem_Input.isEmpty()){
                tipo = "erro"
                mensagem = "Preencha os campos para continuar."

            }
            else{
                tipo = "sucesso"
                mensagem = "Mensagem publicada com Sucesso!"
                findViewById<TextInputEditText>(R.id.eT_titulo_activity30_adm_publicar_aviso).setText("")
                findViewById<TextInputEditText>(R.id.eT_mensagem_activity30_adm_publicar_aviso).setText("")
            }

            val dialogView = layoutInflater.inflate(R.layout.dialog_custom, null)

            val dialog = AlertDialog.Builder(this)
                .setView(dialogView)
                .create()

            val messageText = dialogView.findViewById<TextView>(R.id.dialogMessage)
            val okButton = dialogView.findViewById<Button>(R.id.dialogOk)
//            val background = dialogView.findViewById<LinearLayout>(R.id.dialogMessage).parent as LinearLayout

            messageText.text = mensagem

            // Muda cor de fundo conforme o tipo
            when (tipo) {
                "erro" -> dialogView.setBackgroundResource(R.drawable.bg_dialog_error)
                "sucesso" -> dialogView.setBackgroundResource(R.drawable.bg_dialog_sucess)
            }

            okButton.setOnClickListener {
                dialog.dismiss()
            }

            dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
            dialog.show()
        }

        val btn_voltar = findViewById<Button>(R.id.btn_voltar_activity30_adm_publicar_aviso)
        btn_voltar.setOnClickListener{
            finish()
        }
    }
}