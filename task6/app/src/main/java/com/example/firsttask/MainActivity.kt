package com.example.firsttask

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.TransitionDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.button);

        val animationResize: Animation = AnimationUtils.loadAnimation(
            this@MainActivity, R.anim.animation
        )
        button.startAnimation(animationResize)

        val colorFrom = Color.parseColor("#E69AF0")
        val colorTo =  Color.parseColor("#0A548F")
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(), colorFrom, colorTo)
        colorAnimation.duration = 5000 // milliseconds

        colorAnimation.addUpdateListener { animator -> button.setBackgroundColor(animator.animatedValue as Int) }
        colorAnimation.start()

    }
}