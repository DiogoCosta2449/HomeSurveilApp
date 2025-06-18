package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SelectCamara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_camara)

        val userName = intent.getStringExtra("SELECTED_USER") ?: "Mariana"
        findViewById<TextView>(R.id.textViewTitle).text = userName

        val btnDefinicoes = findViewById<ImageButton>(R.id.settingsButton)
        btnDefinicoes.setOnClickListener {
            startActivity(Intent(this, SettingsScreen::class.java))
        }

        findViewById<ImageButton>(R.id.btnEscritorio).setOnClickListener {
            navigateToCamera(userName, "Escritório", R.drawable.escritorio)
        }

        findViewById<ImageButton>(R.id.btnSalaDeEstar).setOnClickListener {
            navigateToCamera(userName, "Sala de Estar", R.drawable.saladeestar)
        }

        findViewById<ImageButton>(R.id.btnQuintal).setOnClickListener {
            navigateToCamera(userName, "Quintal", R.drawable.quintal)
        }
    }

    private fun navigateToCamera(userName: String, location: String, imageResId: Int) {
        Intent(this, camara::class.java).apply {
            putExtra("SELECTED_USER", userName)
            putExtra("SELECTED_LOCATION", location)
            putExtra("IMAGE_RES_ID", imageResId)
            startActivity(this)
        }
    }
}