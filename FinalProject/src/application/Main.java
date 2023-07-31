package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(getClass().getResource("/com/bookstore/views/BookBrowser.fxml"));

            // Set up the primary stage (window)
            primaryStage.setTitle("Bookstore App");
            Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);

            // Show the primary stage
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}