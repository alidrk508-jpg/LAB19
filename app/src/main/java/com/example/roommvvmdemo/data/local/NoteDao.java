package com.example.roommvvmdemo.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert
    void drk_insert(Note drk_note);

    @Delete
    void drk_delete(Note drk_note);

    @Query("DELETE FROM notes_table")
    void drk_deleteAllNotes();

    @Query("SELECT * FROM notes_table ORDER BY drk_id DESC")
    LiveData<List<Note>> drk_getAllNotes();
}
