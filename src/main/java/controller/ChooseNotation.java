package controller;

import controller.Main;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/* this class represents the controller, that controls UI in the choose notation screen
* at this point, users will choose if they want to practice learning Notes, Intervals, or Chords
* any combination of them is allowed - except for none of course */
public class ChooseNotation {

    @FXML private VBox vbox_notes;
    @FXML private VBox vbox_intervals;
    @FXML private VBox vbox_chords;

    @FXML
    public void goToChooseKeySignature() {
        /* navigates back to the previous screen, which in this case is choose_key_signature.fxml */

        Stage stage = (Stage) vbox_chords.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/choose_key_signature.fxml").toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        stage.show();
    }

    @FXML
    public void navBack() {
        /* navigates back to the previous screen, which in this case is main.fxml */

        Stage currStage = (Stage) vbox_notes.getScene().getWindow();
        Parent newRootNode = null;
        try {
            URL url = new File("src/main/resources/fxml/main.fxml").toURI().toURL();
            newRootNode = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        currStage.setScene(new Scene(newRootNode, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        currStage.show();
    }

    @FXML
    public void highlight(Event event) {
        /* will make the transparent circle, that is overlaying choice, semi transparent and gray.
        * this acts like a highlight over the user's choice */
        Circle source = (Circle) event.getSource();
        source.setFill(Color.LIGHTGRAY);
        source.setOpacity(0.4);
    }

    @FXML
    public void removeHighlight(Event event) {
        /* will make the semi-transparent circle, that is overlaying choice, fully transparent.
         * this acts like unhighlighting the user's choice */
        Circle source = (Circle) event.getSource();
        source.setOpacity(0.0);
    }

    @FXML
    public void selectOrDeselect(Event event) {
        /* checks if choice is already "selected" or not*/
        Circle source = (Circle) event.getSource();
        boolean isAlreadyChosen = source.getFill() == Color.LIGHTGREEN;
        if (isAlreadyChosen) {
            // we need to renable hover and unhover effects, so interactive again
            enableOnHoverOnUnhover(source);
        } else {
            // we need to disable hover and unhover effects, to make it non-interactive
            // the user has locked in their choice after all.
            disableOnHoverOnUnhover(source);
        }
    }

    private void disableOnHoverOnUnhover(Circle source) {
        source.setFill(Color.LIGHTGREEN);
        source.setOnMouseEntered(null);
        source.setOnMouseExited(null);
    }

    private void enableOnHoverOnUnhover(Circle source) {
        source.setOnMouseEntered(event1 -> {
            source.setFill(Color.LIGHTGRAY);
            source.setOpacity(0.4);
        });
        source.setOnMouseExited(event1 -> {
            source.setOpacity(0);
        });
    }


    @FXML
    public void setNotationChoice() {

    }

    @FXML
    public void highlight() {

    }

    @FXML
    public void unHighlight() {
        // todo
    }

}
