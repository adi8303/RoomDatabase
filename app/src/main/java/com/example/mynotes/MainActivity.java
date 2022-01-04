package com.example.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.Application;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        asking android sys. for viewmodel
//        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

    }
}