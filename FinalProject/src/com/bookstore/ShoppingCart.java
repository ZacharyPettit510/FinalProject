package com.bookstore;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Book> books;

    public ShoppingCart() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public double getTotal() {
        double total = 0.0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }
}