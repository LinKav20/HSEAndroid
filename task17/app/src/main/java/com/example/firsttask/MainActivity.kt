package com.example.firsttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.TextView
import java.lang.Math.abs
import kotlin.math.sign

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener,
    GestureDetector.OnDoubleTapListener {
    private lateinit var signTextView: TextView
    private lateinit var gestureDetector: GestureDetector
    var x2: Float = 0.0f
    var x1: Float = 0.0f
    var y2: Float = 0.0f
    var y1: Float = 0.0f

    companion object {
        const val MIN_DISTANCE = 150
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signTextView = findViewById(R.id.signTextView)
        gestureDetector = GestureDetector(this, this)
        gestureDetector.setOnDoubleTapListener(this);

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)

        when (event?.action) {
            0 -> {
                x1 = event.x
                y1 = event.y
            }
            1 -> {
                x2 = event.x
                y2 = event.y

                motion();
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        signTextView.text = "On down";
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
        signTextView.text = "On show press ";
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        signTextView.text = "On single tap up " ;
        return false
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        signTextView.text = "On scroll: " ;
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
        signTextView.text = "On long press " ;
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        signTextView.text = "On fling: ";
        return false
    }

    private fun motion() {
        val valueX: Float = x2 - x1
        val valueY: Float = y2 - y1

        if (abs(valueX) > MIN_DISTANCE) {
            if (x2 > x1) {
                signTextView.text = "Right swipe"
            } else {
                signTextView.text = "Left swipe"
            }
        } else if (abs(valueY) > MIN_DISTANCE) {
            if (y2 > y1) {
                signTextView.text = "Bottom swipe"
            } else {
                signTextView.text = "Top swipe"
            }
        }
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        signTextView.text = "On single tap confirmed " ;
        return false;
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        signTextView.text = "On double tap ";
        return false;
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        signTextView.text = "On double tap event " ;
        return false;
    }
}