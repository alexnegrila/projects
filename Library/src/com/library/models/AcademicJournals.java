package com.library.models;

public class AcademicJournals {

    //Attributes that describe com.library.models.AcademicJournals
    private String title;
    private String author;
    private int year;
    private String articles;
    private int frequency;
    private int cost;
    private String journal_size;
    private String article_length;



    // Methods to set the values of the attributes and get them
    public void setAcademicJournals(String title, String author, int year, String articles, int frequency, int cost, String journal_size, String article_length) {
        this.title=title;
        this.author=author;
        this.year=year;
        this.articles=articles;
        this.frequency=frequency;
        this.cost=cost;
        this.journal_size=journal_size;
        this.article_length=article_length;


    }

    public String getTitle() {
        return title;

    }



    public String GetAuthor() {
        return author;

    }


    public int getYear() {
        return year;

    }


    public String getArticles() {
        return articles;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCost() {
        return cost;

    }

    public String getJournal_Size() {
        return journal_size;

    }


    public String getArticle_Length() {
        return article_length;

    }

}

