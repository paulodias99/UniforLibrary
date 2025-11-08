package com.example.uniforlibrary

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import com.google.android.material.button.MaterialButton

class Activity05UserChatbot : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity05_user_chatbot)

        // Botão de voltar
        findViewById<MaterialButton>(R.id.btn_voltar_activity05_user_chatbot).setOnClickListener {
            finish()
        }

        // Botão de enviar mensagem
        val editMensagem = findViewById<EditText>(R.id.eT_mensagem_activity05_user_chatbot)
        val btnEnviar = findViewById<ImageButton>(R.id.imageButton_enviar_activity05_user_chatbot)

        btnEnviar.setOnClickListener {
            val mensagem = editMensagem.text.toString()
            if (mensagem.isEmpty()) {
                Toast.makeText(this, "Mensagem vazia", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Mensagem enviada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
