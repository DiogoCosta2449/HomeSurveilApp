package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SelectCamara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_camara)

        // Receber o nome do utilizador e atualizar o TextView
        val userName = intent.getStringExtra("SELECTED_USER") ?: "Mariana"
        findViewById<TextView>(R.id.textViewTitle).text = userName

        val btnDefinicoes = findViewById<android.widget.ImageButton>(R.id.settingsButton)
        btnDefinicoes.setOnClickListener {
            val intent = Intent(this, SettingsScreen::class.java)
            startActivity(intent)
        }

        val btnEscritorio = findViewById<android.widget.ImageButton>(R.id.btnEscritorio)
        btnEscritorio.setOnClickListener {
            navigateToCamera(userName, "Escritório")
        }

        val btnSalaDeEstar = findViewById<android.widget.ImageButton>(R.id.btnSalaDeEstar)
        btnSalaDeEstar.setOnClickListener {
            navigateToCamera(userName, "Sala de Estar")
        }

        val btnQuintal = findViewById<android.widget.ImageButton>(R.id.btnQuintal)
        btnQuintal.setOnClickListener {
            navigateToCamera(userName, "Quintal")
        }
    }

    private fun navigateToCamera(userName: String, location: String) {
        val intent = Intent(this, camara::class.java).apply {
            putExtra("SELECTED_USER", userName)
            putExtra("SELECTED_LOCATION", location)
        }
        startActivity(intent)
    }
}