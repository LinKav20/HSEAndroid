package com.example.firsttask

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var playButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playButton = findViewById(R.id.playButton)

        playButton.setOnClickListener {
            playAudio()
        }
    }

    private fun playAudio() {
        val mediaPlayer = MediaPlayer.create(this@MainActivity, R.raw.knife)
        mediaPlayer.start()
    }
}