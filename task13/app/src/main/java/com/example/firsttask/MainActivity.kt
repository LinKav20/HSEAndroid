package com.example.firsttask

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView

class MainActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoView)
        videoView.setVideoURI(
            Uri.parse(
                "android.resource://" +
                        packageName + "/" + R.raw.cat
            )
        )

        videoView.setMediaController(MediaController(this))
        videoView.start()
        videoView.requestFocus()
    }


}