package com.example.mynotes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface    NoteDao {

    @Insert  // it tells  which query should be performed by the funcn. made
    void insert (Note note);

    @Update
    void update (Note note);

    @Delete
    void delete (Note note);

    @Query("DELETE FROM note_table")  //note_table is the table made by us in the DAO.
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();  // it returns the lists of Notes
//    here we make the list of data as Livedata
//Livedata is an wrapper above the data like here the list of naotes is stored in the Livedata
//Livedata can be Observe from anywher = benefit
//room supports LiveData
//    so we will know automatically that when our List is updated
}
