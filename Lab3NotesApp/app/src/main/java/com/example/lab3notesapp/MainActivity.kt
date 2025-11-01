
package com.example.lab3notesapp // <-- Make sure this package name matches yours!

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
class MainActivity : AppCompatActivity() {

    // --- Class-level Variables ---
    private lateinit var etNoteInput: EditText
    private lateinit var btnAddNote: Button
    private lateinit var rvNotesList: RecyclerView

    private lateinit var noteAdapter: NoteAdapter
    private var noteList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their ID
        etNoteInput = findViewById(R.id.etNoteInput)
        btnAddNote = findViewById(R.id.btnAddNote)
        rvNotesList = findViewById(R.id.rvNotesList)

        // Initialize the RecyclerView
        setupRecyclerView()
    }

    /**
     * Configures the RecyclerView with its LayoutManager and Adapter.
     */
    private fun setupRecyclerView() {
        // Initialize the adapter with the note list and a placeholder long-click listener
        noteAdapter = NoteAdapter(noteList) { position ->
            // We will implement deletion in a future step
        }

        rvNotesList.adapter = noteAdapter
        rvNotesList.layoutManager = LinearLayoutManager(this)
    }
}