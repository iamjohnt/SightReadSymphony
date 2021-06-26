module ui {
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;

    exports controller;
    exports exceptions;
    exports gameoptions;
    exports logic;
}