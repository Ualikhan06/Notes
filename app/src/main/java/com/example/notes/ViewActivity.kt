package com.example.notes

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        Log.d("ViewActivity", "onCreate")

        val a = intent.getStringExtra("x") ?: ""
        val b = intent.getStringExtra("y") ?: ""

        val c = findViewById<TextView>(R.id.tv1)
        val d = findViewById<TextView>(R.id.tv2)
        val e = findViewById<TextView>(R.id.btnBack)

        c.text = a
        d.text = b

        e.setOnClickListener {
            finish()
        }
    }

    override fun onStart() { super.onStart(); Log.d("ViewActivity", "onStart") }
    override fun onResume() { super.onResume(); Log.d("ViewActivity", "onResume") }
    override fun onPause() { super.onPause(); Log.d("ViewActivity", "onPause") }
    override fun onStop() { super.onStop(); Log.d("ViewActivity", "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d("ViewActivity", "onDestroy") }
}