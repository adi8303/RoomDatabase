package com.example.mynotes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey
    private int id;

    private String title;

    private String description;

    private int priority;

    public Note(String title, String description, int priority) {
//      this.id = id; // we dont need id here because id will be generated by itself.
        this.title = title;
        this.description = description;
        this.priority = priority;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setId(int id) {
        this.id = id;
    }
}