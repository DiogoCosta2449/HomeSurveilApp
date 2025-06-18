package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class camara : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.camara)

        val userName = intent.getStringExtra("SELECTED_USER") ?: "Utilizador"
        val location = intent.getStringExtra("SELECTED_LOCATION") ?: "Local"
        val imageResId = intent.getIntExtra("IMAGE_RES_ID", -1)

        findViewById<TextView>(R.id.nameText).text = userName
        findViewById<TextView>(R.id.locationText).text = location.uppercase()

        if (imageResId != -1) {
            findViewById<ImageView>(R.id.mainImage).setImageResource(imageResId)
        }

        findViewById<ImageButton>(R.id.settingsButton).setOnClickListener {
            startActivity(Intent(this, SettingsScreen::class.java))
        }
    }
}