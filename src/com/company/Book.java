package com.company;

public class Book {


    private long id;
    private String title;
    private String  author;
    private String yearofpublication;
    private String ISBNnumber;
    private  boolean borrowed;

    public Book() {
        borrowed=false;
    }

    public Book(String title, String author, String yearofpublication, String ISBNnumber) {
        this.title = title;
        this.author = author;
        this.yearofpublication = yearofpublication;
        this.ISBNnumber = ISBNnumber;
        borrowed=false;
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

    public String getYearofpublication() {
        return yearofpublication;
    }

    public void setYearofpublication(String yearofpublication) {
        this.yearofpublication = yearofpublication;
    }

    public String getISBNnumber() {
        return ISBNnumber;
    }

    public void setISBNnumber(String ISBNnumber) {
        this.ISBNnumber = ISBNnumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
