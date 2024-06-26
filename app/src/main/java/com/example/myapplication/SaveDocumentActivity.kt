package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// Shared list to store documents
object DocumentStore {
    val documents = mutableListOf<String>()
}

class SaveDocumentActivity : AppCompatActivity() {

    private lateinit var documentContent: EditText
    private lateinit var btnSaveDoc: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_document)

        documentContent = findViewById(R.id.documentContent)
        btnSaveDoc = findViewById(R.id.btnSaveDoc)

        btnSaveDoc.setOnClickListener {
            val content = documentContent.text.toString()
            if (content.isNotEmpty()) {
                // Save the document content in the shared list
                DocumentStore.documents.add(content)
                Toast.makeText(this, "Document Saved", Toast.LENGTH_SHORT).show()
                finish()  // Close the activity after saving
            } else {
                Toast.makeText(this, "Document Content is empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
