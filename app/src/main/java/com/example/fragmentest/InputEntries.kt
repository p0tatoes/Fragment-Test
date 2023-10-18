package com.example.fragmentest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class InputEntries : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_entries)

        val backButton: Button = findViewById(R.id.button_back)
        backButton.setOnClickListener {
            finish()
        }
    }
}