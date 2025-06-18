package com.example.homesurveilapp

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("AppPreferences", Context.MODE_PRIVATE)

    var fontSize: String
        get() = sharedPreferences.getString("font_size", "Médio") ?: "Médio"
        set(value) = sharedPreferences.edit().putString("font_size", value).apply()

    var theme: String
        get() = sharedPreferences.getString("theme", "Sistema") ?: "Sistema"
        set(value) = sharedPreferences.edit().putString("theme", value).apply()

    var highContrast: Boolean
        get() = sharedPreferences.getBoolean("high_contrast", false)
        set(value) = sharedPreferences.edit().putBoolean("high_contrast", value).apply()
}