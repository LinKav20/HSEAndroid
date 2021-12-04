package com.example.firsttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var editEditText: EditText;
    private lateinit var nextBtn: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editEditText = findViewById(R.id.editEditText);
        nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener{
            var intent = Intent(this@MainActivity, SecActivity::class.java);
            intent.putExtra("message", editEditText.text.toString());
            startActivity(intent);
        };
    }
}