package controller;

import controller.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChooseOptions {

    @FXML
    Button back;
    @FXML ComboBox minNoteBass;
    @FXML ComboBox maxNoteBass;
    @FXML ComboBox maxNoteTreble;
    @FXML ComboBox minNoteTreble;

    @FXML
    public void navBack() {
        Stage stage = (Stage) back.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/main.fxml").toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        stage.show();
    }

    @FXML public void onHover(Event event) {
        Rectangle btn = (Rectangle) event.getSource();
        btn.setFill(Color.DARKGRAY);
        btn.setOpacity(0.5);
    }

    @FXML public void onUnhover(Event event) {
        Rectangle btn = (Rectangle) event.getSource();
        btn.setOpacity(0);
    }

    @FXML public void onClick(Event event) {
        Rectangle choice = (Rectangle) event.getSource();
        if (choice.getFill() == Color.DARKGRAY) {
            // then the choice is currently unselected
            select(choice);
        } else if (choice.getFill() == Color.LIGHTGREEN) {
            // then the choice is currently selected, so we need to unselect
            deselect(choice);
        }
    }

    private void select(Rectangle highlight) {
        highlight.setOnMouseExited(null);
        highlight.setOnMouseEntered(null);
        highlight.setOpacity(0.5);
        highlight.setFill(Color.LIGHTGREEN);
    }

    private void deselect(Rectangle highlight) {
        highlight.setOnMouseEntered(event1 -> {
            Node node = (Node) event1.getSource();
            node.setOpacity(0.5);
        });
        highlight.setOnMouseExited(event1 -> {
            Node node = (Node) event1.getSource();
            node.setOpacity(0);
        });
        highlight.setFill(Color.DARKGRAY);
    }

    public void initialize() {
        initializeComboBoxes();
    }

    private void initializeComboBoxes() {
        /*  The user can specify the range of notes that will appear in the game, through 4 comboboxes
         * this method initializes the combo-boxes with the possible choices   */

        ObservableList<String> typicalLeftHandRange = FXCollections.observableArrayList(
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9",
                "10",
                "11",
                "12",
                "13",
                "14",
                "15",
                "16",
                "17",
                "18",
                "19",
                "20",
                "21",
                "22",
                "23",
                "24",
                "25",
                "26",
                "27",
                "28",
                "29",
                "30",
                "31",
                "32",
                "33",
                "34",
                "35",
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46",
                "47",
                "48",
                "49",
                "50"
        );

        ObservableList<String> typicalRightHandRange = FXCollections.observableArrayList(
                "30",
                "31",
                "32",
                "33",
                "34",
                "35",
                "36",
                "37",
                "38",
                "39",
                "40",
                "41",
                "42",
                "43",
                "44",
                "45",
                "46",
                "47",
                "48",
                "49",
                "50",
                "51",
                "52",
                "53",
                "54",
                "55",
                "56",
                "57",
                "58",
                "59",
                "60",
                "61",
                "62",
                "63",
                "64",
                "65",
                "66",
                "67",
                "68",
                "69",
                "70",
                "71",
                "72",
                "73",
                "74",
                "75",
                "76",
                "77",
                "78",
                "79",
                "80",
                "81",
                "82",
                "83",
                "84",
                "85",
                "86",
                "87",
                "88"
        );

        minNoteBass.setItems(typicalLeftHandRange);
        maxNoteBass.setItems(typicalLeftHandRange);
        minNoteTreble.setItems(typicalRightHandRange);
        maxNoteTreble.setItems(typicalRightHandRange);
    }
}
