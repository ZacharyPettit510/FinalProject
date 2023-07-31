package com.bookstore;

public class Book {
    private String title;
    private String author;
    private double price;
    private int publicationYear;

    public Book(String title, String author, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    // New constructor to parse book data from text file
    public Book(String bookData) {
        String[] bookAttributes = bookData.split(",");
        this.title = bookAttributes[0];
        this.author = bookAttributes[1];
        this.price = Double.parseDouble(bookAttributes[2]);
        this.publicationYear = Integer.parseInt(bookAttributes[3]);
    }

    // Getters and setters (if needed) for the fields

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}