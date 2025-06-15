package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SelectCamara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_camara)

        val btnDefinicoes = findViewById<android.widget.ImageButton>(R.id.settingsButton)
        btnDefinicoes.setOnClickListener {
            val intent = Intent(this, SettingsScreen::class.java)
            startActivity(intent)
        }

        val btnEscritorio = findViewById<android.widget.ImageButton>(R.id.btnEscritorio)
        btnEscritorio.setOnClickListener {
            val intent = Intent(this, camara::class.java)
            startActivity(intent)
        }

        val btnSalaDeEstar = findViewById<android.widget.ImageButton>(R.id.btnSalaDeEstar)
        btnSalaDeEstar.setOnClickListener {
            val intent = Intent(this, camara::class.java)
            startActivity(intent)
        }

        val btnQuintal = findViewById<android.widget.ImageButton>(R.id.btnQuintal)
        btnQuintal.setOnClickListener {
            val intent = Intent(this, camara::class.java)
            startActivity(intent)
        }
    }
}
