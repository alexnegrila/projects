package com.library.models;

public class Book
{

    //Attributes that describe com.library.models.Book
    private String title;
    private String author;
    private int year;
    private String genre;

    public Book()
    {

    }

    public Book(String title, String author, int year, String genre) {
        this.title=title;
        this.author=author;
        this.year=year;
        this.genre=genre;
    }

    // Methods to set the values of the attributes and get them
    public void setBooks (String title, String author, int year, String genre) {
        this.title=title;
        this.author=author;
        this.year=year;
        this.genre=genre;

    }

    public String getTitle() {
        return title;

    }



    public String getAuthor() {
        return author;

    }


    public int getYear() {
        return year;

    }


    public String getGenre() {
        return genre;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    public void setAuthor(final String author)
    {
        this.author = author;
    }

    public void setYear(final int year)
    {
        this.year = year;
    }

    public void setGenre(final String genre)
    {
        this.genre = genre;
    }
}

