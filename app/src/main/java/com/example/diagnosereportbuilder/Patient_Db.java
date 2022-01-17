package com.example.diagnosereportbuilder;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Model.class, version = 1)
public abstract class Patient_Db extends RoomDatabase {

    private static final String DB_Name = "Patient_Info";
    private static Patient_Db instance;

    public static synchronized Patient_Db getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Patient_Db.class, DB_Name)
                    .fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;

    }

    public abstract Patient_Dao patient_dao();


}
