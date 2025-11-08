package com.example.uniforlibrary

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

/**
 * Loads [MainFragment6].
 */
class Activity03EsqueceuSenha2 : FragmentActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity03_esqueceu_senha2)

        findViewById<Button>(R.id.btn_voltar_activity03_esqueceu_senha2).setOnClickListener {
            finish()
        }

        findViewById<Button>(R.id.btn_redefinir_activity03_esqueceu_senha).setOnClickListener {
            var text1 = findViewById<EditText>(R.id.eT_nova_activity03_esqueceu_senha2).text.toString()
            var text2 = findViewById<EditText>(R.id.eT_confirmar_activity03_esqueceu_senha2).text.toString()

            if (text1.isEmpty() or text2.isEmpty()){
                Toast.makeText(this, "Por favor preencha todos os espaços.", Toast.LENGTH_SHORT).show()
            }
            else if(text1 != text2){
                Toast.makeText(this, "Senhas não coincidem.", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Redefinição realizada com sucesso.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}