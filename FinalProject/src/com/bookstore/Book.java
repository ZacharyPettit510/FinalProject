package com.bookstore;

// The Book class represents a book in the bookstore.
public class Book {
    // Title of the book.
    private String title;

    // Author of the book.
    private String author;

    // Price of the book.
    private double price;

    // Year of book's publication.
    private int publicationYear;

    // Constructor accepting individual attributes.
    public Book(String title, String author, double price, int publicationYear) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
    }

    // Constructor accepting a comma-separated string.
    public Book(String bookData) {
        String[] bookAttributes = bookData.split(",");
        this.title = bookAttributes[0];
        this.author = bookAttributes[1];
        this.price = Double.parseDouble(bookAttributes[2]);
        this.publicationYear = Integer.parseInt(bookAttributes[3]);
    }

    // Getter for title.
    public String getTitle() {
        return title;
    }

    // Getter for author.
    public String getAuthor() {
        return author;
    }

    // Getter for price.
    public double getPrice() {
        return price;
    }

    // Getter for publication year.
    public int getPublicationYear() {
        return publicationYear;
    }

    // Override toString() to return a formatted string representing a book.
    @Override
    public String toString() {
        return title + " by " + author + " (" + publicationYear + ")";
    }
}