package com.example.happiness.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.happiness.R

class SecondActivity : AppCompatActivity() {
    private lateinit var done: Button
    private lateinit var text: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_second)

        done = findViewById(R.id.done_btn)
        text = findViewById(R.id.textViewMemoryBack)

        done.setOnClickListener {
           sendIntent()
        }
    }

    fun sendIntent(){
        val intent = Intent(this@SecondActivity, MainActivity::class.java)
        intent.putExtra("data", text.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}