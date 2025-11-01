/*
 * Course: MAD204 - Lab 3
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date: 2025-11-02
 * Description: Main activity for a persistent notes application. Allows users
 * to add, delete (with undo), and store notes persistently.
 */

package com.example.lab3notesapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson // <-- NEW IMPORT
import com.google.gson.reflect.TypeToken // <-- NEW IMPORT

/**
 * Main activity for the Persistent Notes App.
 * Handles user input, displays notes in a RecyclerView, and manages data persistence.
 */
class MainActivity : AppCompatActivity() {

    // --- Class-level Variables ---
    private lateinit var etNoteInput: EditText
    private lateinit var btnAddNote: Button
    private lateinit var rvNotesList: RecyclerView
    private lateinit var mainLayout: ConstraintLayout

    private lateinit var noteAdapter: NoteAdapter
    private var noteList = ArrayList<String>()

    // --- NEW: For Persistence ---
    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()
    private val PREFS_NAME = "NotePrefs"
    private val NOTES_KEY = "NoteList"
    // ---

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // --- Initialize SharedPreferences ---
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        // ---

        // Find views by their ID
        etNoteInput = findViewById(R.id.etNoteInput)
        btnAddNote = findViewById(R.id.btnAddNote)
        rvNotesList = findViewById(R.id.rvNotesList)
        mainLayout = findViewById(R.id.main)

        // --- Load notes *before* setting up RecyclerView ---
        loadNotes()
        // ---

        // Initialize the RecyclerView
        setupRecyclerView()

        // Set click listener for the "Add Note" button
        btnAddNote.setOnClickListener {
            addNote()
        }
    }

    // --- Save notes when the app is paused ---
    override fun onPause() {
        super.onPause()
        saveNotes()
    }
    // ---

    /**
     * Configures the RecyclerView with its LayoutManager and Adapter.
     */
    private fun setupRecyclerView() {
        // ... (no changes here)
    }

    /**
     * Handles adding a new note to the list.
     * ... (no changes here)
     */
    private fun addNote() {
        // ... (no changes here)
    }

    /**
     * Deletes a note at a given position and shows a Snackbar with an UNDO option.
     * ... (no changes here)
     */
    private fun deleteNote(position: Int) {
        // ... (no changes here)
    }


    /**
     * Saves the current note list to SharedPreferences as a JSON string.
     */
    private fun saveNotes() {
        val editor = sharedPreferences.edit()
        val json = gson.toJson(noteList) // Convert list to JSON string
        editor.putString(NOTES_KEY, json)
        editor.apply() // Save asynchronously
    }

    /**
     * Loads the note list from SharedPreferences.
     */
    private fun loadNotes() {
        val json = sharedPreferences.getString(NOTES_KEY, null)
        if (json != null) {
            val type = object : TypeToken<ArrayList<String>>() {}.type
            noteList = gson.fromJson(json, type) // Convert JSON string back to list
        }
    }
}