package com.bookstore;

public class FictionBook extends Book {
    private String genre;
    private String targetAudience;

    public FictionBook(String title, String author, double price, int publicationYear, String genre, String targetAudience) {
        super(title, author, price, publicationYear);
        this.genre = genre;
        this.targetAudience = targetAudience;
    }

    // Getters and setters for the additional fields
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    // Optionally, you can override abstract methods from the parent class
    // if you defined any in the Book class.
}