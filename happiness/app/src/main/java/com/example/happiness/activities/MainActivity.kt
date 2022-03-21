package com.example.happiness.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.happiness.CardController
import com.example.happiness.R
import com.example.happiness.ViewPagerAdapter
import com.example.happiness.models.Card

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var addButton: Button

    private val cards = CardController()

    val REQUEST_CODE = 999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, cards)

        addButton = findViewById(R.id.addNewCardButton)

        addButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            Log.d("ADD CARD", "meh")
            cards.addCardByIndex(Card("myCard", data?.getStringExtra("data")!!), 1)

            viewPager.adapter = ViewPagerAdapter(supportFragmentManager, cards)
            viewPager.currentItem = 1
        }
    }
}
