package com.example.mynotes;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        asking android sys. for viewmodel
        NoteViewModel noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
//        hello this is the master branch

    noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                //update RecyclerView
                Toast.makeText(MainActivity.this, "Hello APP Changed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
