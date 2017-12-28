package com.library.models;

public class DVDs {

    //Attributes that describe com.library.models.DVDs
    private String title;
    private String author;
    private String genre;
    private int year;
    private String more_info;






    // Methods to set the values of the attributes and get them
    public void setDVDs (String title, String author, String genre, int year, String more_info) {
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.year=year;
        this.more_info=more_info;



    }

    public String getTitle() {
        return title;

    }



    public String getAuthor() {
        return author;

    }



    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    public String getMore_Info() {
        return more_info;

    }



}
