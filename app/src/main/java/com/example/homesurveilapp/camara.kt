package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class camara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camara)

        // Receber dados da intent
        val userName = intent.getStringExtra("SELECTED_USER") ?: "Utilizador"
        val location = intent.getStringExtra("SELECTED_LOCATION") ?: "Local"

        // Atualizar os TextViews
        findViewById<TextView>(R.id.nameText).text = userName
        findViewById<TextView>(R.id.locationText).text = location.uppercase()

        val btnDefinicoes = findViewById<android.widget.ImageButton>(R.id.settingsButton)
        btnDefinicoes.setOnClickListener {
            val intent = Intent(this, SettingsScreen::class.java)
            startActivity(intent)
        }
    }
}