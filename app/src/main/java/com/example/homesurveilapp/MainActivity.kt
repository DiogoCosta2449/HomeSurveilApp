
package com.example.homesurveilapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registerButton = findViewById<android.widget.Button>(R.id.buttonRegister)
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val layoutAntonia = findViewById<android.widget.LinearLayout>(R.id.layoutAntonia)
        layoutAntonia.setOnClickListener {
            val intent = Intent(this, SelectCamara::class.java)
            startActivity(intent)
        }

        val layoutRicardo = findViewById<android.widget.LinearLayout>(R.id.layoutRicardo)
        layoutRicardo.setOnClickListener {
            val intent = Intent(this, SelectCamara::class.java)
            startActivity(intent)
        }

        val layoutMariana = findViewById<android.widget.LinearLayout>(R.id.layoutMariana)
        layoutMariana.setOnClickListener {
            val intent = Intent(this, SelectCamara::class.java)
            startActivity(intent)
        }

        }
}
