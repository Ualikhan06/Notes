package com.example.notes

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


data class Task(val title: String, val detail: String)

class MainActivity : AppCompatActivity() {

    companion object {

        val tasksList = mutableListOf<Task>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate")

        val btnAdd = findViewById<Button>(R.id.btnAddNew)
        btnAdd.setOnClickListener {
            val intent = Intent(    this, EditActivity::class.java)
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume")
        updateList()
    }

    private fun updateList() {
        val container = findViewById<LinearLayout>(R.id.tasksContainer)
        container.removeAllViews()


        for (i in tasksList.indices) {
            val task = tasksList[i]


            val view = LayoutInflater.from(this).inflate(R.layout.item_task, container, false)

            val tvTitle = view.findViewById<TextView>(R.id.tvTaskTitle)
            val tvDetail = view.findViewById<TextView>(R.id.tvTaskDetail)
            val btnDelete = view.findViewById<TextView>(R.id.btnDelete)


            tvTitle.text = task.title
            tvDetail.text = task.detail


            view.setOnClickListener {
                val intent = Intent(this, ViewActivity::class.java)
                intent.putExtra("x", task.title)
                intent.putExtra("y", task.detail)
                startActivity(intent)
            }


            btnDelete.setOnClickListener {
                tasksList.removeAt(i)
                updateList()
            }


            container.addView(view)
        }
    }

    override fun onStart() { super.onStart(); Log.d("MainActivity", "onStart") }
    override fun onPause() { super.onPause(); Log.d("MainActivity", "onPause") }
    override fun onStop() { super.onStop(); Log.d("MainActivity", "onStop") }
    override fun onDestroy() { super.onDestroy(); Log.d("MainActivity", "onDestroy") }
}