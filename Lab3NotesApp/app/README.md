* Course: MAD204 - Lab 3
* Student Name: Darshilkumar Karkar
* Student ID: A00203357
* Date: 2025-11-02

Description: Main activity for a persistent notes application. Allows users to add, delete (with undo), and store notes persistently.This project is a Persistent Notes App for Android, created for the MAD204 course (Lab 3). It allows a user to create a simple list of notes that remains saved even after the app is closed and reopened.

Key features include:

Add Notes: Users can type a note into a text field and add it to a list.

View Notes: All notes are displayed in a dynamic, scrolling list using RecyclerView.

Delete with Undo: A long-press on any note in the list deletes it. A Snackbar then appears, offering an UNDO option to immediately restore the deleted note.

Persistence: The app uses SharedPreferences to save the entire list of notes. The ArrayList of notes is converted to a JSON string using the GSON library before saving, and then parsed back into a list when the app starts.

This project demonstrates the use of RecyclerView for dynamic lists, handling user touch events (clicks and long-presses), implementing a Snackbar with an action, and managing persistent data storage with SharedPreferences and GSON.