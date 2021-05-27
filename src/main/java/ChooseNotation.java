import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ChooseNotation {

    @FXML VBox vbox_notes;
    @FXML VBox vbox_intervals;
    @FXML VBox vbox_chords;

    @FXML
    public void goToChooseKeySignature() {
        /* sets screen as choose_notation.fxml   */

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
        Stage stage = (Stage) vbox_notes.getScene().getWindow();
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

    @FXML
    public void highlight(Event event) {
        Circle source = (Circle) event.getSource();
        source.setFill(Color.LIGHTGRAY);
        source.setOpacity(0.4);
    }

    @FXML
    public void removeHighlight(Event event) {
        Circle source = (Circle) event.getSource();
        source.setOpacity(0.0);
    }

    @FXML
    public void selectOrDeselect(Event event) {
        Circle source = (Circle) event.getSource();
        boolean isAlreadyChosen = source.getFill() == Color.LIGHTGREEN;
        if (isAlreadyChosen) {
            source.setOnMouseEntered(event1 -> {
                source.setFill(Color.LIGHTGRAY);
                source.setOpacity(0.4);
            });
            source.setOnMouseExited(event1 -> {
                source.setOpacity(0);
            });
        } else {
            // we need to select it
            source.setFill(Color.LIGHTGREEN);
            source.setOnMouseEntered(null);
            source.setOnMouseExited(null);
        }
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
