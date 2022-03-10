package com.example.happiness.activities

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.example.happiness.R
import com.example.happiness.ViewPagerAdapter
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    var position = 0
    lateinit var installed: Date

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        savePosition()

        val context = this;
        installed = Date(
            context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime
        )

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, installed)
        viewPager.currentItem = position

    }

    override fun onStop() {
        super.onStop()

        position = viewPager.currentItem

        val save: SharedPreferences = getSharedPreferences("POSIITON", 0);
        val editor = save.edit()
        editor.putInt("position", position)
        editor.commit()
    }

    private fun savePosition() {
        val save: SharedPreferences = getSharedPreferences("POSIITON", 0);
        position = save.getInt("position", position)
    }
}
