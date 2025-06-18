package com.example.homesurveilapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class SettingsScreen : AppCompatActivity() {
    private lateinit var prefs: AppPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_screen)

        prefs = AppPreferences(this)
        applyCurrentSettings()
        setupFontSizeSpinner()
        setupThemeSpinner()
        setupHighContrastSwitch()
    }

    private fun applyCurrentSettings() {
        // Apply current settings when activity starts
        applyTheme()
        if (prefs.highContrast) {
            applyHighContrast(true)
        }
    }

    private fun setupFontSizeSpinner() {
        val spinner = findViewById<Spinner>(R.id.spinnerTamanho)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.tamanhos_array,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner.adapter = adapter
        spinner.setSelection(adapter.getPosition(prefs.fontSize))

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val newSize = parent?.getItemAtPosition(position).toString()
                if (prefs.fontSize != newSize) {
                    prefs.fontSize = newSize
                    notifyFontSizeChanged()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupThemeSpinner() {
        val spinner = findViewById<Spinner>(R.id.spinnerTema)
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.temas_array,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner.adapter = adapter
        spinner.setSelection(adapter.getPosition(prefs.theme))

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                val newTheme = parent?.getItemAtPosition(position).toString()
                if (prefs.theme != newTheme) {
                    prefs.theme = newTheme
                    applyTheme()
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun setupHighContrastSwitch() {
        val switch = findViewById<SwitchCompat>(R.id.switchHighContrast)
        switch.isChecked = prefs.highContrast

        switch.setOnCheckedChangeListener { _, isChecked ->
            if (prefs.highContrast != isChecked) {
                prefs.highContrast = isChecked
                applyHighContrast(isChecked)
                notifyThemeChanged()
            }
        }
    }

    private fun applyTheme() {
        when (prefs.theme) {
            "Claro" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            "Escuro" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            "Sistema" -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }

        // Reapply high contrast if needed
        if (prefs.highContrast) {
            applyHighContrast(true)
        }
    }

    private fun applyHighContrast(enabled: Boolean) {
        if (enabled) {
            // Apply high contrast colors
            window.decorView.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
            // You can add more high contrast styling here
        } else {
            // Revert to normal theme colors
            window.decorView.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
        }
    }

    private fun notifyFontSizeChanged() {
        LocalBroadcastManager.getInstance(this)
            .sendBroadcast(Intent("UPDATE_FONT_SIZE"))
    }

    private fun notifyThemeChanged() {
        LocalBroadcastManager.getInstance(this)
            .sendBroadcast(Intent("UPDATE_THEME"))
    }

    override fun onDestroy() {
        super.onDestroy()
        // Notify activities to refresh when settings change
        notifyFontSizeChanged()
        notifyThemeChanged()
    }
}