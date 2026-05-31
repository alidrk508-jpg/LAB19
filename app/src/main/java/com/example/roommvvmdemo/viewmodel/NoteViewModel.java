package com.example.roommvvmdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.roommvvmdemo.data.NoteRepository;
import com.example.roommvvmdemo.data.local.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private final NoteRepository drk_repository;
    private final LiveData<List<Note>> drk_allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        drk_repository = new NoteRepository(application);
        drk_allNotes = drk_repository.drk_getAllNotes();
    }

    public void drk_insert(Note note) {
        drk_repository.drk_insert(note);
    }

    public void drk_delete(Note note) {
        drk_repository.drk_delete(note);
    }

    public void drk_deleteAllNotes() {
        drk_repository.drk_deleteAllNotes();
    }

    public LiveData<List<Note>> drk_getAllNotes() {
        return drk_allNotes;
    }
}
