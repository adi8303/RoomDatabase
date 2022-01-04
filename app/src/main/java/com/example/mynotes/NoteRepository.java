package com.example.mynotes;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes; //a var.allNotes  Livedata of type <list of note objects>.

    public  NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application); //    passing appln. as context
//        we can call notedao instead it is an abstract class becz. we have create instanceof
//        roomdb so room autogenerates all the code required.
        noteDao = database.noteDao();
        allNotes = noteDao.getAllNotes();

    }

//      room doesnt allow databs opn. on the main thread so using asynctask to
//      perform task in the background thread


    public void  insert (Note note){
        new InsertNoteAsyncTask(noteDao).execute(note);

    }
    public void  update (Note note){
        new UpdateNoteAsyncTask(noteDao).execute(note);

    }
    public void  delete (Note note){
        new DeleteNoteAsyncTask(noteDao).execute(note);

    }
    public void  deleteAllNotes(){
        new DeleteAllNoteAsyncTask(noteDao).execute();

    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }

//    Progressupdate = Void
//    Result = Void
    private static class InsertNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
//    Class is static so cant access notedao directly so using Constructor
        private  InsertNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        private  UpdateNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class DeleteNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        private  DeleteNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    private static class DeleteAllNoteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        private  DeleteAllNoteAsyncTask(NoteDao noteDao){
            this.noteDao=noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
}
