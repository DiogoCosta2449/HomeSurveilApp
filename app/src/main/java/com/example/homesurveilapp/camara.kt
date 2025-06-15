package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class camara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camara)

        val btnDefinicoes = findViewById<android.widget.ImageButton>(R.id.settingsButton)
        btnDefinicoes.setOnClickListener {
            val intent = Intent(this, SettingsScreen::class.java)
            startActivity(intent)
        }
    }
}
