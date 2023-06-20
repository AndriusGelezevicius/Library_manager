package com.andrius.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBase extends SQLiteOpenHelper {
    public static final String BOOKS_TABLE = "BOOKS_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_BOOK_TITLE = "BOOK_TITLE";
    public static final String COLUMN_BOOK_AUTHOR = "BOOK_AUTHOR";
    public static final String COLUMN_BOOK_GENRE = "BOOK_GENRE";
    public static final String COLUMN_BOOK_YEAR = "BOOK_YEAR";
    public static final String COLUMN_BOOK_PAGE = "BOOK_PAGE";
    public static final String COLUMN_BOOK_LANGUAGE = "BOOK_LANGUAGE";
    public static final String COLUMN_BOOK_DESCRIPTION = "BOOK_DESCRIPTION";

    public DataBase(@Nullable Context context) {
        super(context, "BookList", null, 1); //BookList db - name
    }

    // this is called the firsty time a database is accessed. Code to create a new database. Its implement methods automatically
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableQuery ="CREATE TABLE " + BOOKS_TABLE + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_BOOK_TITLE + " TEXT, " +
                COLUMN_BOOK_AUTHOR + " TEXT, " +
                COLUMN_BOOK_GENRE + " TEXT, " +
                COLUMN_BOOK_YEAR + " INT, " +
                COLUMN_BOOK_PAGE + " INT, " +
                COLUMN_BOOK_LANGUAGE + " TEXT, " +
                COLUMN_BOOK_DESCRIPTION + " TEXT) ";

        sqLiteDatabase.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOneEntry(BookData bookData){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues(); //for store data

        cv.put(COLUMN_BOOK_TITLE, bookData.getTitle());
        cv.put(COLUMN_BOOK_AUTHOR, bookData.getAuthor());
        cv.put(COLUMN_BOOK_GENRE, bookData.getGenre());
        cv.put(COLUMN_BOOK_YEAR, bookData.getYear());
        cv.put(COLUMN_BOOK_PAGE, bookData.getPage());
        cv.put(COLUMN_BOOK_LANGUAGE, bookData.getLanguage());
        cv.put(COLUMN_BOOK_DESCRIPTION, bookData.getDescription());

        long insert = db.insert(BOOKS_TABLE, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }
    }

    public List<BookData> getEveryone(){
        List<BookData> returnList = new ArrayList<>();
        String query = "SELECT * FROM " + BOOKS_TABLE;
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        //check if the curoso has any rows
        if(cursor.moveToFirst()){
            //loop through the cursor and create new book objects.Put them into the return List
            do {
                String bookTitle = cursor.getString(1);
                String bookAuthor = cursor.getString(2);
                String bookGenre = cursor.getString(3);
                int bookYear = cursor.getInt(4);
                int bookPage = cursor.getInt(5);
                String bookLanguage = cursor.getString(6);
                String bookDescription = cursor.getString(7);

                BookData newBookData = new BookData(bookTitle, bookAuthor, bookGenre, bookLanguage, bookDescription, bookYear, bookPage);
                returnList.add(newBookData);
            }while(cursor.moveToNext());
        }else{
            //failure do not add to list
        }
        cursor.close();
        db.close();
        return returnList;
    }
}
