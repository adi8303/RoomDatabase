package com.example.mynotes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository repository;
    private LiveData<List<Note>> allNOtes;
    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new NoteRepository(application);
        allNOtes = repository.getAllNotes();
    }

    public void  insert (Note note){
      repository.insert(note);

    }
    public void  update (Note note){
        repository.update(note);
    }
    public void  delete (Note note){
        repository.delete(note);
    }
    public void  deleteAllNotes (Note note){
        repository.deleteAllNotes();
    }

}


