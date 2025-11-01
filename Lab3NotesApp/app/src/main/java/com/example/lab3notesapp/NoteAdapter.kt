/*
 * Course: MAD204 - Lab 3
 * Student Name: Darshilkumar Karkar
 * Student ID: A00203357
 * Date: 2025-11-02
 */

package com.example.lab3notesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for the RecyclerView in MainActivity. Manages the list of note strings.
 *
 * @param notes The list of notes to display.
 * @param onNoteLongClicked A listener to handle long-press events for deletion.
 */
class NoteAdapter(
    private val notes: ArrayList<String>,
    private val onNoteLongClicked: (Int) -> Unit // Lambda for long click
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    /**
     * ViewHolder class to hold the view for a single note item.
     */
    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTextView: TextView = itemView.findViewById(R.id.tvNoteText)

        init {
            // Set the long click listener for the item view
            itemView.setOnLongClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onNoteLongClicked(position) // Trigger the lambda
                }
                true // Consume the long click
            }
        }
    }

    /**
     * Inflates the layout for a single item row.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row, parent, false)
        return NoteViewHolder(view)
    }

    /**
     * Returns the total number of items in the list.
     */
    override fun getItemCount(): Int {
        return notes.size
    }

    /**
     * Binds the data (a note string) to the views in the ViewHolder.
     */
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.noteTextView.text = notes[position]
    }
}