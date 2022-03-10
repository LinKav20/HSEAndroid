package com.example.happiness.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.happiness.CardController
import com.example.happiness.R

val cards =  CardController()

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager)

        addButton = findViewById(R.id.addNewCardButton)
        addButton.setOnClickListener{
            cards.shownCard = 10
        }
    }
}

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return FragmentCardActivity.newInstance(position)
    }

    override fun getCount(): Int {
        return cards.shownCard
    }
}