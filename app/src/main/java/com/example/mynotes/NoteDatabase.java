package com.example.mynotes;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


//this class is made for room database which will connect different  and will make
// an instance of database which will be used in the project.

@Database(entities={Note.class},version = 1) // here we are defining entities
// that we want our database to contain. Here we can have more than 1 element.
// Migration =  version is increased whenever we update the Schema of the table


//An Abstract Class so we cant m=make the object of it only its childens objects can be made.
public abstract class NoteDatabase extends RoomDatabase{

    private static NoteDatabase instance;  //variable

//   to convert class into singleton
//    singleton: means we cant create multiple instances of database
//            instead we will always use the same instance everywhere

    public abstract  NoteDao noteDao(); // to access dao and dont need to provide body becz.
//    room takes of it.



    // syn. means only one thread at a time can get access to the database.
    public static synchronized NoteDatabase getInstance(Context context){

        if(instance==null){
            instance=Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class,"note_database") //KIs database ka hmko Object achahiye and us database ka name
                    .addCallback(roomcallback)
                    .fallbackToDestructiveMigration()
        .build();
        }
        return instance;
    }

    private  static RoomDatabase.Callback roomcallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
    private  NoteDao noteDao;

    private PopulateDbAsyncTask(NoteDatabase db){
        noteDao = db.noteDao();
    }
        @Override
        protected Void doInBackground(Void... voids) {
        noteDao.insert(new Note("Title 1","Description 1",1));
        noteDao.insert(new Note("Title 2","Description 2",2));
        noteDao.insert(new Note("Title 3","Description 3",3));
            return null;
        }
    }

}

