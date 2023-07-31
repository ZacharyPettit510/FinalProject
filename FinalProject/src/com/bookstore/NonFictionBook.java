package com.bookstore;

public class NonFictionBook extends Book {
    private String subject;
    private String format; // Hardcover, Paperback, eBook, etc.

    public NonFictionBook(String title, String author, double price, int publicationYear, String subject, String format) {
        super(title, author, price, publicationYear);
        this.subject = subject;
        this.format = format;
    }

    // Getters and setters for the additional fields
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    // Optionally, you can override abstract methods from the parent class
    // if you defined any in the Book class.
}