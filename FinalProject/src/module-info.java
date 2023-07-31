module FinalProject {
	requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    // Add other required modules as needed
    exports com.bookstore.controllers;
    
    opens com.bookstore.controllers to javafx.fxml;
	opens application to javafx.graphics, javafx.fxml;
}
