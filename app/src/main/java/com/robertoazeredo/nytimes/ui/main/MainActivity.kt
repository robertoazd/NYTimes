package com.robertoazeredo.nytimes.ui.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.robertoazeredo.nytimes.R
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSavedTheme()
    }

    private fun setupSavedTheme() {
        val sharedPreferences = getSharedPreferences("SharedPrefs", Context.MODE_PRIVATE)
        val modeNightEnabled = sharedPreferences.getBoolean("MODE_NIGHT", false)

        if (modeNightEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}