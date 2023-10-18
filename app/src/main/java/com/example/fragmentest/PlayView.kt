package com.example.fragmentest

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PlayView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_view)

        var isMute: Boolean = false
        var image: Int;

        val muteButton: ImageButton = findViewById(R.id.button_mute)
        muteButton.setOnClickListener {
            isMute = !isMute
            image = if (isMute) R.drawable.icon_mute else R.drawable.icon_unmute
            muteButton.setImageResource(image)
        }

        val backButton: Button = findViewById(R.id.play_button_back)
        backButton.setOnClickListener { finish() }
    }
}