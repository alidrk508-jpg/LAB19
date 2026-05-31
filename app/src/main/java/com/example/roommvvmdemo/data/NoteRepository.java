package com.example.roommvvmdemo.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.roommvvmdemo.data.local.Note;
import com.example.roommvvmdemo.data.local.NoteDao;
import com.example.roommvvmdemo.data.local.NoteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private final NoteDao drk_noteDao;
    private final LiveData<List<Note>> drk_allNotes;
    private final ExecutorService drk_executorService;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.drk_getInstance(application);
        drk_noteDao = database.drk_noteDao();
        drk_allNotes = drk_noteDao.drk_getAllNotes();
        drk_executorService = Executors.newSingleThreadExecutor();
    }

    public void drk_insert(Note note) {
        drk_executorService.execute(() -> drk_noteDao.drk_insert(note));
    }

    public void drk_delete(Note note) {
        drk_executorService.execute(() -> drk_noteDao.drk_delete(note));
    }

    public void drk_deleteAllNotes() {
        drk_executorService.execute(drk_noteDao::drk_deleteAllNotes);
    }

    public LiveData<List<Note>> drk_getAllNotes() {
        return drk_allNotes;
    }
}
