package com.andrius.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = Book.ENTITY_BOOK_TABLE)
public class Book {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "BOOK_TITLE")
    private String title;
    @ColumnInfo(name = "BOOK_AUTHOR")
    private String author;
    @ColumnInfo(name = "BOOK_GENRE")
    private String genre;
    @ColumnInfo(name = "BOOK_LANGUAGE")
    private String language;
    @ColumnInfo(name = "BOOK_DESCRIPTION")
    private String description;
    @ColumnInfo(name = "BOOK_YEAR")
    private int year;
    @ColumnInfo(name = "BOOK_PAGE")
    private int page;

    @Ignore
    public static final String ENTITY_BOOK_TABLE = "BOOK_TABLE";


    public Book(
            String title,
            String author,
            String genre,
            String language,
            String description,
            int year,
            int page
    ) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.language = language;
        this.description = description;
        this.year = year;
        this.page = page;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.page = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "BookData{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", page=" + page +
                '}';
    }
}
