package com.example.firsttask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView;
    private lateinit var editEditText: EditText;
    private lateinit var doneBtn: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView);
        editEditText = findViewById(R.id.editEditText);
        doneBtn = findViewById(R.id.doneBtn);

        resultTextView.text = "";

        doneBtn.setOnClickListener{
            resultTextView.text = editEditText.text;
        };
    }
}