package com.example.notes

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        Log.d("EditActivity", "onCreate")

        val btnBack = findViewById<TextView>(R.id.btnBack)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etDetail = findViewById<EditText>(R.id.etDetail)

        btnBack.setOnClickListener {
            finish()
        }

        btnAdd.setOnClickListener {
            val titleText = etTitle.text.toString()
            val detailText = etDetail.text.toString()

            if (titleText.isNotEmpty()) {
                 MainActivity.tasksList.add(Task(titleText, detailText))

                Log.i("EditActivity", "Добавлено: $titleText")
                Toast.makeText(this, "Задача добавлена!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Сначала введите заголовок", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() { super.onStart(); Log.d("EditActivity", "onStart") }
    override fun onResume() { super.onResume(); Log.d("EditActivity", "onResume") }
    override fun onPause() { super.onPause(); Log.d("EditActivity", "onPause") }
    override fun onStop() { super.onStop(); Log.d("EditActivity", "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d("EditActivity", "onDestroy") }
}