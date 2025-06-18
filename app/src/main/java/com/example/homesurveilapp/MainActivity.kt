package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView  // Importação adicionada

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton = findViewById<Button>(R.id.buttonRegister)
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val layoutAntonia = findViewById<LinearLayout>(R.id.layoutAntonia)
        layoutAntonia.setOnClickListener {
            navigateToSelectCamera("Antónia")
        }

        val layoutRicardo = findViewById<LinearLayout>(R.id.layoutRicardo)
        layoutRicardo.setOnClickListener {
            navigateToSelectCamera("Ricardo")
        }

        val layoutMariana = findViewById<LinearLayout>(R.id.layoutMariana)
        layoutMariana.setOnClickListener {
            navigateToSelectCamera("Mariana")
        }
    }

    override fun applyFontSize() {
        // Aplicar tamanho de fonte aos elementos da UI
        val scale = when (prefs.fontSize) {
            "Pequeno" -> 0.8f
            "Grande" -> 1.2f
            else -> 1.0f // Médio
        }

        // Exemplo para um TextView - aplicar a todos os elementos necessários
        findViewById<TextView>(R.id.textViewTitle)?.apply {
            textSize = 36f * scale
        }
    }

    private fun navigateToSelectCamera(userName: String) {
        val intent = Intent(this, SelectCamara::class.java).apply {
            putExtra("SELECTED_USER", userName)
        }
        startActivity(intent)
    }
}