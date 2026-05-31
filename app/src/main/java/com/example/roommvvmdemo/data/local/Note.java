package com.example.roommvvmdemo.data.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int drk_id;

    private String drk_title;
    private String drk_description;

    public Note(String drk_title, String drk_description) {
        this.drk_title = drk_title;
        this.drk_description = drk_description;
    }

    public int getDrk_id() {
        return drk_id;
    }

    public void setDrk_id(int drk_id) {
        this.drk_id = drk_id;
    }

    public String getDrk_title() {
        return drk_title;
    }

    public String getDrk_description() {
        return drk_description;
    }
}
