package com.bookstore;

import java.util.ArrayList;

// Class to represent a shopping cart.
public class ShoppingCart {
    
    // ArrayList to hold the books added to the cart.
    private ArrayList<Book> books;

    // Constructor initializes the books ArrayList.
    public ShoppingCart() {
        books = new ArrayList<>();
    }

    // Method to add a book to the cart.
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the cart.
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to get the list of books in the cart.
    public ArrayList<Book> getBooks() {
        return books;
    }

    // Method to calculate the total price of the books in the cart.
    public double getTotal() {
        double total = 0.0;
        // Iterating over each book in the cart.
        for (Book book : books) {
            // Adding the price of each book to the total.
            total += book.getPrice();
        }
        // Returning the total price.
        return total;
    }
}