module library {
    requires javafx.controls;
    requires javafx.fxml;

    opens library to javafx.fxml;
    opens library.controller to javafx.fxml;
    opens library.model to javafx.base;
    opens library.application to javafx.graphics;


    exports library;
}