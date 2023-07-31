package com.bookstore;

// NonFictionBook is a subclass of Book.
public class NonFictionBook extends Book {
    // Subject of the non-fiction book.
    private String subject;

    // Format of the book (e.g., Hardcover, Paperback, eBook, etc.).
    private String format;

    // Constructor, includes parameters for the superclass and new attributes.
    public NonFictionBook(String title, String author, double price, int publicationYear, String subject, String format) {
        // Call to superclass constructor.
        super(title, author, price, publicationYear);
        
        // Initialization of new attributes.
        this.subject = subject;
        this.format = format;
    }

    // Getter for subject.
    public String getSubject() {
        return subject;
    }

    // Setter for subject.
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Getter for format.
    public String getFormat() {
        return format;
    }

    // Setter for format.
    public void setFormat(String format) {
        this.format = format;
    }
}