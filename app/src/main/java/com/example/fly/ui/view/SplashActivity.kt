package com.example.fly.ui.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.fly.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay for a few seconds
        Handler(Looper.getMainLooper()).postDelayed({
            // Move to the main activity
            startActivity(Intent(this, MainActivity::class.java))
            finish() // Close the splash activity
        }, 4000) // 2000 milliseconds = 2 seconds
    }
}