package com.andrius.database;

public class BookData {
    private String title;
    private String author;
    private String genre;
    private String language;
    private String description;
    private int id;
    private int year;
    private int page;

    public BookData(
            int id,
            String title,
            String author,
            String genre, String language, String description, int year, int page
    ) {
        this.id = id;
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
