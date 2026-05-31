package com.example.roommvvmdemo.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 2, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao drk_noteDao();

    private static volatile NoteDatabase drk_instance;

    public static NoteDatabase drk_getInstance(Context context) {
        if (drk_instance == null) {
            synchronized (NoteDatabase.class) {
                if (drk_instance == null) {
                    drk_instance = Room.databaseBuilder(
                                    context.getApplicationContext(),
                                    NoteDatabase.class,
                                    "notes_database"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return drk_instance;
    }
}
