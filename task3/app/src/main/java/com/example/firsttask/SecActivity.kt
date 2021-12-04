package com.example.firsttask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class SecActivity : AppCompatActivity() {

    private lateinit var messageTextView: TextView;
    private lateinit var backBtn: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sec)

        messageTextView = findViewById(R.id.messageTextView);
        backBtn = findViewById(R.id.backBtn);

        val intent = getIntent()
        val message = intent.getStringExtra("message")
        messageTextView.text = message

        backBtn.setOnClickListener{
            var intent = Intent(this@SecActivity, MainActivity::class.java);
            startActivity(intent);
        };
    }
}