package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var numOne: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numOne = findViewById(R.id.button1)
        resultTextView = findViewById(R.id.textView12)

        resultTextView.text = ""

        numOne.setOnClickListener(){
            resultTextView.append("1")
        }

    }
}