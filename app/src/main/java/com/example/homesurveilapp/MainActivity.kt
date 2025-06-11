package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicia o SplashActivity após 5 segundos (não recomendado normalmente)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, SplashActivity::class.java))
            finish()
        }, 5000)
    }
}

