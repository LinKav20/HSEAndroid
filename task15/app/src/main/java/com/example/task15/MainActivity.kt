package com.example.task15

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var db: SQLiteDatabase
    private lateinit var dbTextView: TextView
    private lateinit var addNameButton: Button

    private var position = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        dbTextView = findViewById(R.id.dataBaseTextView)
        addNameButton = findViewById(R.id.addNameButton)
        saveTextInEditText()

        db = openOrCreateDatabase(
            "MyDataBase", MODE_PRIVATE,
            null
        )

        workDataBase()

        addNameButton.setOnClickListener {
            db = openOrCreateDatabase(
                "MyDataBase", MODE_PRIVATE,
                null
            )
            dbTextView.setText(
                dbTextView.text.toString() + "\n" + position + ") " + editText.getText()
                    .toString()
            );
            db.execSQL(
                "INSERT INTO PERSON VALUES('" + position + "', '" + editText.getText()
                    .toString() + "');"
            );
            position++;
            db.close();
        }
    }

    override fun onStop() {
        super.onStop()
        val save: SharedPreferences = getSharedPreferences("SAVE", 0);
        val editor = save.edit()
        editor.putString("text", editText.text.toString())
        editor.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optional_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.aboutProgram -> showAboutProgramDialog()
            R.id.settings -> goToSettings()
        }
        return super.onOptionsItemSelected(item);
    }

    private fun showAboutProgramDialog() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("About program")
        dialog.setMessage("Maltseva Angelina 206")
        dialog.setNeutralButton("Ok", { dialogInterface: DialogInterface, i: Int -> })
        dialog.show()
    }

    private fun goToSettings() {
        val myIntent = Intent(this@MainActivity, SettingsActivity::class.java)
        startActivity(myIntent)
    }

    private fun saveTextInEditText() {
        val save: SharedPreferences = getSharedPreferences("SAVE", 0);
        editText.setText(save.getString("text", ""))
    }

    @SuppressLint("Range")
    private fun workDataBase() {
        db.execSQL("CREATE TABLE IF NOT EXISTS PERSON (id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR);");

        val cursor = db.rawQuery("SELECT * FROM PERSON", null);

        if (cursor.moveToFirst()) {
            do {
                var id = cursor.getLong(cursor.getColumnIndex("id"));
                var name = cursor.getString(cursor.getColumnIndex("name"))
                dbTextView.setText(dbTextView.text.toString() + "\n" + id + ") " + name);
            } while (cursor.moveToNext())
        }

        position = cursor.getCount() + 1;

        db.close()
    }
}