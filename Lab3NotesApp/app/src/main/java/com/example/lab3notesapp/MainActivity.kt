package com.example.lab3notesapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

/**
 * Main activity for the Persistent Notes App.
 * Handles user input, displays notes in a RecyclerView, and manages data persistence.
 */
class MainActivity : AppCompatActivity() {

    // --- Class-level Variables ---
    private lateinit var etNoteInput: EditText
    private lateinit var btnAddNote: Button
    private lateinit var rvNotesList: RecyclerView
    private lateinit var mainLayout: ConstraintLayout // For Snackbar

    private lateinit var noteAdapter: NoteAdapter
    private var noteList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by their ID
        etNoteInput = findViewById(R.id.etNoteInput)
        btnAddNote = findViewById(R.id.btnAddNote)
        rvNotesList = findViewById(R.id.rvNotesList)
        mainLayout = findViewById(R.id.main) // Find root layout

        // Initialize the RecyclerView
        setupRecyclerView()

        // Set click listener for the "Add Note" button
        btnAddNote.setOnClickListener {
            addNote()
        }
    }

    /**
     * Configures the RecyclerView with its LayoutManager and Adapter.
     */
    private fun setupRecyclerView() {
        // Initialize the adapter with the note list
        noteAdapter = NoteAdapter(noteList) { position ->
            // --- Handle the long click ---
            deleteNote(position)
        }

        rvNotesList.adapter = noteAdapter
        rvNotesList.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Handles adding a new note to the list.
     * ... (existing addNote code)
     */
    private fun addNote() {
    }

    /**
     * Deletes a note at a given position and shows a Snackbar with an UNDO option.
     *
     * @param position The index of the note to delete.
     */
    private fun deleteNote(position: Int) {
        // 1. Get the note to be deleted
        val deletedNote = noteList[position]

        // 2. Remove it from the list and notify the adapter
        noteList.removeAt(position)
        noteAdapter.notifyItemRemoved(position)
        noteAdapter.notifyItemRangeChanged(position, noteList.size) // Update positions

        // 3. Show Snackbar with UNDO
        Snackbar.make(mainLayout, "Note deleted", Snackbar.LENGTH_LONG)
            .setAction("UNDO") {
                // 4. UNDO action: re-add the note at its original position
                noteList.add(position, deletedNote)
                noteAdapter.notifyItemInserted(position)
                rvNotesList.scrollToPosition(position) // Scroll to the restored item
            }
            .show()
    }
}