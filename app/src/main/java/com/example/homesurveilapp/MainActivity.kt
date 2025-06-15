
package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutAntonia = findViewById<android.widget.LinearLayout>(R.id.layoutAntonia)
        layoutAntonia.setOnClickListener {
            val intent = Intent(this, camara::class.java)
            startActivity(intent)
        }
    }
}