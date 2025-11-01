
package com.example.lab3notesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * Main activity for the Persistent Notes App.
 * Handles user input, displays notes in a RecyclerView, and manages data persistence.
 */
// ... (imports and class definition)

class MainActivity : AppCompatActivity() {

    // ... (class variables)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their ID
        etNoteInput = findViewById(R.id.etNoteInput)
        btnAddNote = findViewById(R.id.btnAddNote)
        rvNotesList = findViewById(R.id.rvNotesList)

        // Initialize the RecyclerView
        setupRecyclerView()


        // Set click listener for the "Add Note" button
        btnAddNote.setOnClickListener {
            addNote()
        }
    }

    /**
     * Configures the RecyclerView...
     */
    private fun setupRecyclerView() {
        // ... (existing setupRecyclerView code)
    }

    /**
     * Handles adding a new note to the list.
     * Reads text from the EditText, adds it to the list, and updates the adapter.
     */
    private fun addNote() {
        val noteText = etNoteInput.text.toString().trim()

        if (noteText.isNotEmpty()) {
            noteList.add(noteText) // Add to the list
            noteAdapter.notifyItemInserted(noteList.size - 1) // Tell adapter
            rvNotesList.scrollToPosition(noteList.size - 1) // Scroll to the new item
            etNoteInput.text.clear() // Clear the input field

            // Show Toast confirmation
            android.widget.Toast.makeText(this, "Note added", android.widget.Toast.LENGTH_SHORT).show()
        } else {
            android.widget.Toast.makeText(this, "Note cannot be empty", android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}