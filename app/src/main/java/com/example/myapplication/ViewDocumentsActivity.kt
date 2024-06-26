package com.example.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ViewDocumentsActivity : AppCompatActivity() {

    private lateinit var documentsListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_documents)

        documentsListView = findViewById(R.id.documentsListView)

        // Get documents from the shared list
        val documents = DocumentStore.documents

        if (documents.isEmpty()) {
            Toast.makeText(this, "No documents saved", Toast.LENGTH_SHORT).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, documents)
        documentsListView.adapter = adapter

        // Handle click on document item
        documentsListView.setOnItemClickListener { _, _, position, _ ->
            val documentContent = documents[position]
            showDocumentContent(documentContent)
        }
    }

    private fun showDocumentContent(content: String) {
        AlertDialog.Builder(this)
            .setTitle("Document Content")
            .setMessage(content)
            .setPositiveButton("OK", null)
            .show()
    }
}
