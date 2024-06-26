package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {

    private lateinit var btnSave: Button
    private lateinit var btnView: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        btnSave = findViewById(R.id.btnSave)
        btnView = findViewById(R.id.btnView)

        btnSave.setOnClickListener {
            // Code to save a document
            // For simplicity, showing a Toast message here
            Toast.makeText(this, "Save Document Clicked", Toast.LENGTH_SHORT).show()
            // Intent to open SaveDocumentActivity (you need to create this activity)
            startActivity(Intent(this, SaveDocumentActivity::class.java))
        }

        btnView.setOnClickListener {
            // Code to view saved documents
            // For simplicity, showing a Toast message here
            Toast.makeText(this, "View Documents Clicked", Toast.LENGTH_SHORT).show()
            // Intent to open ViewDocumentsActivity (you need to create this activity)
            startActivity(Intent(this, ViewDocumentsActivity::class.java))
        }
    }
}
