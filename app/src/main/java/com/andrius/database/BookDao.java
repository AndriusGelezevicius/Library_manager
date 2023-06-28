package com.andrius.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM " + Book.ENTITY_BOOK_TABLE)
    List<Book> getAll();

    @Query("SELECT * FROM " + Book.ENTITY_BOOK_TABLE+ " WHERE id =:id")
    Book getItem(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBooks(List<Book> books);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertBook(Book book);

    @Delete
    void deleteBook(Book book);

    @Delete
    void deleteBooks(List<Book> books);
}
