package com.bookstore.controllers;

import com.bookstore.*;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookBrowserController {

    // Instance variables
    @FXML
    private TextField searchTextField;     // TextField for the search
    @FXML
    private ListView<Book> bookListView;   // ListView for the books
    @FXML
    private ListView<Book> cartListView;   // ListView for the shopping cart
    @FXML
    private TextField totalTextField;      // TextField for the total price

    private ShoppingCart shoppingCart;     // ShoppingCart object
    private ObservableList<Book> bookList; // ObservableList for the books

    // Method called on initialization
    public void initialize() {
        shoppingCart = new ShoppingCart();               // Initialize the shopping cart
        bookList = FXCollections.observableArrayList(readBooksFromFile());  // Populate the book list from the file
        bookListView.setItems(bookList);                // Set the items in the bookListView to the books from the file
    }

    // Method to handle clearing the cart
    public void handleClearCart() {
        shoppingCart.getBooks().clear();                // Clear the shopping cart
        updateCartListView();                           // Update the cart list view
        updateTotalTextField();                         // Update the total text field
    }

    // Method to read books from the file
    public List<Book> readBooksFromFile() {
        List<Book> books = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                // Trimming the whitespace from publication year before parsing
                Book book = new Book(bookData[0], bookData[1], Double.parseDouble(bookData[2]), Integer.parseInt(bookData[3].trim()));
                books.add(book);
            }
        } catch (IOException e) {
            System.err.println("Error reading books.txt: " + e.getMessage());
        }

        return books;
    }

    // Method to handle the search
    @FXML
    private void handleSearch() {
        String searchText = searchTextField.getText().toLowerCase();
        ObservableList<Book> searchResults = FXCollections.observableArrayList();
        for (Book book : bookList) {
            if (book.getTitle().toLowerCase().contains(searchText)) {
                searchResults.add(book);
            }
        }
        bookListView.setItems(searchResults);
    }

    // Method to handle the book selection
    @FXML
    private void handleBookSelection(MouseEvent event) {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            System.out.println("You selected: " + selectedBook.getTitle());
        }
    }

    // Method to handle adding to the cart
    @FXML
    private void handleAddToCart() {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            shoppingCart.addBook(selectedBook);
            updateCartListView();
            updateTotal();
        }
    }

    // Method to handle removing from the cart
    @FXML
    private void handleRemoveFromCart() {
        Book selectedBook = cartListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            shoppingCart.removeBook(selectedBook);
            updateCartListView();
            updateTotal();
        }
    }

    // Method to update the cart list view
    private void updateCartListView() {
        cartListView.setItems(FXCollections.observableArrayList(shoppingCart.getBooks()));
    }

    // Method to update the total
    private void updateTotal() {
        totalTextField.setText("$" + String.format("%.2f", shoppingCart.getTotal()));
    }

    // Method to update the total text field
    private void updateTotalTextField() {
        totalTextField.setText("$" + String.format("%.2f", shoppingCart.getTotal()));
    }
}