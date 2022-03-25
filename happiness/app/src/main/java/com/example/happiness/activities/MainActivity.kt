package com.example.happiness.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.viewpager.widget.ViewPager
import com.example.happiness.controllers.CardController
import com.example.happiness.R
import com.example.happiness.controllers.ViewPagerAdapter
import com.example.happiness.datas.Generation
import com.example.happiness.models.Card

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var addButton: Button

    private val cards = CardController()
    private val generation = Generation()
    private lateinit var db: SQLiteDatabase

    private var posToDataBase = 1
    var position = 0

    private val action =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                val text = result.data?.extras?.get("data") as String
                val back_text = generation.getText()
                cards.addCardByIndex(Card(text, back_text), 1)

                viewPager.adapter = ViewPagerAdapter(supportFragmentManager, cards)
                viewPager.currentItem = 1

                openDB()
                db.execSQL(
                    "INSERT INTO CARD VALUES('" + text + "', '" + back_text + "');"
                );
                posToDataBase++;
                db.close();
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        openDB()
        workDataBase()
        savePosition()

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, cards)
        viewPager.currentItem = position

        addButton = findViewById(R.id.addNewCardButton)

        addButton.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            action.launch(intent);
        }
    }

    fun openDB() {
        db = openOrCreateDatabase(
            "CARDS", MODE_PRIVATE,
            null
        )
    }

    @SuppressLint("Range")
    private fun workDataBase() {
        db.execSQL("CREATE TABLE IF NOT EXISTS CARD (front_text VARCHAR, back_text VARCHAR);");

        val cursor = db.rawQuery("SELECT * FROM CARD", null);

        if (cursor.moveToFirst()) {
            do {
                var ft = cursor.getString(cursor.getColumnIndex("front_text"))
                var bt = cursor.getString(cursor.getColumnIndex("back_text"))
                cards.addCardByIndex(Card(ft, bt), 1);
            } while (cursor.moveToNext())
        }

        posToDataBase = cursor.getCount() + 1;

        db.close()
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
