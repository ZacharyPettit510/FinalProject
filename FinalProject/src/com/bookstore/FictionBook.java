package com.bookstore;

// FictionBook is a subclass of Book.
public class FictionBook extends Book {
    // Genre of the fiction book.
    private String genre;

    // The target audience of the book.
    private String targetAudience;

    // Constructor, includes parameters for the superclass and new attributes.
    public FictionBook(String title, String author, double price, int publicationYear, String genre, String targetAudience) {
        // Call to superclass constructor.
        super(title, author, price, publicationYear);

        // Initialization of new attributes.
        this.genre = genre;
        this.targetAudience = targetAudience;
    }

    // Getter for genre.
    public String getGenre() {
        return genre;
    }

    // Setter for genre.
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter for target audience.
    public String getTargetAudience() {
        return targetAudience;
    }

    // Setter for target audience.
    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }
}