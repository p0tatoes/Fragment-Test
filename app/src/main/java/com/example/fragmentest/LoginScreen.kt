package com.example.fragmentest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val loginButton: Button = findViewById(R.id.buttonLogin)
        loginButton.setOnClickListener {
            val toDashboard: Intent = Intent(this, MainActivity::class.java)
            startActivity(toDashboard)
        }
    }
}