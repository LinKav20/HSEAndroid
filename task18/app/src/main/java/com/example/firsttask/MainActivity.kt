package com.example.firsttask

import android.gesture.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), GestureOverlayView.OnGesturePerformedListener {
    private lateinit var gLib: GestureLibrary
    private lateinit var gestures: GestureOverlayView
    private lateinit var name: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gLib = GestureLibraries.fromRawResource(this, R.raw.gestures)
        if (!gLib.load()) {
            finish()
        }

        name = findViewById(R.id.name_gesture)
        gestures = findViewById(R.id.gesture_overlay_view)
        gestures.addOnGesturePerformedListener(this)
    }

    override fun onGesturePerformed(overlay: GestureOverlayView?, gesture: Gesture?) {
        var predictions = gLib.recognize(gesture)
        if (predictions.size > 0) {
            var prediction = predictions[0]
            if (prediction.score > 1.0) {
                name.text = prediction.name
            } else {
                name.text = "Unrecognized"
            }
        }
    }
}