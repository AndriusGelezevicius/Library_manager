package com.andrius.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(
        entities = {Book.class},
        version = MainDatabase.NEW_VERSION,
        exportSchema = false
)
@TypeConverters({Converter.class})
public abstract class MainDatabase extends RoomDatabase {
    private static MainDatabase instance;
    private static final int PREVIOUS_VERSION = 0;
    public static final int NEW_VERSION = 1;
    private static final int OLD_VERSION = PREVIOUS_VERSION - 1;

    public abstract BookDao bookDao(); //interface

    public static MainDatabase getInstance(Context context) {

        if (instance == null) {
            instance =
                    Room.databaseBuilder( //prisijungimas
                                    context,
                                    MainDatabase.class,
                                    "BookList.db"
                            )
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }

        return instance;
    }
}
