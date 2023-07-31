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
    @FXML
    private TextField searchTextField;
    @FXML
    private ListView<Book> bookListView;
    @FXML
    private ListView<Book> cartListView;
    @FXML
    private TextField totalTextField;

    private ShoppingCart shoppingCart;
    private ObservableList<Book> bookList;

    public void initialize() {
        shoppingCart = new ShoppingCart();
        bookList = FXCollections.observableArrayList(readBooksFromFile());
        bookListView.setItems(bookList);
    }

    public void handleClearCart() {
        shoppingCart.getBooks().clear();
        updateCartListView();
        updateTotalTextField();
    }

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

    @FXML
    private void handleBookSelection(MouseEvent event) {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            System.out.println("You selected: " + selectedBook.getTitle());
        }
    }

    @FXML
    private void handleAddToCart() {
        Book selectedBook = bookListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            shoppingCart.addBook(selectedBook);
            updateCartListView();
            updateTotal();
        }
    }

    @FXML
    private void handleRemoveFromCart() {
        Book selectedBook = cartListView.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            shoppingCart.removeBook(selectedBook);
            updateCartListView();
            updateTotal();
        }
    }

    private void updateCartListView() {
        cartListView.setItems(FXCollections.observableArrayList(shoppingCart.getBooks()));
    }

    private void updateTotal() {
        totalTextField.setText("$" + String.format("%.2f", shoppingCart.getTotal()));
    }

    private void updateTotalTextField() {
        totalTextField.setText("$" + String.format("%.2f", shoppingCart.getTotal()));
    }
}