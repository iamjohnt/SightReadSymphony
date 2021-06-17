module controller {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    exports logic;
    exports controller;
    opens controller to javafx.fxml;    // private fields of controller package is exposed to javafx
    exports exceptions;
}