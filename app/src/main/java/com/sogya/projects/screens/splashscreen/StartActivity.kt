package com.sogya.projects.screens.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.sogya.projects.MainActivity
import com.sogya.projects.R
import com.sogya.projects.app.App
import kotlinx.coroutines.DelicateCoroutinesApi

@DelicateCoroutinesApi
class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (App.getInstance().isNightModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startMainScreen()
    }

    private fun startMainScreen() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(
                Intent(
                    baseContext,
                    MainActivity::class.java
                ).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            )
            finish()
            overridePendingTransition(0, 0)
        }, 1000)
    }
}