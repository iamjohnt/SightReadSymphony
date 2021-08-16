package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/** This is the start screen's controller. */
public class Main extends Application {

    @FXML public ImageView randgen;
    @FXML public ImageView frommidi;

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 600;

    /** starts app with main controller and fxml layout */
    @Override public void start(Stage primaryStage) throws Exception{
        URL fxmlURL = new File("src/main/resources/fxml/main.fxml").toURI().toURL();
        URL iconURL = new File("src/main/resources/images/titleicon.png").toURI().toURL();
        Parent root = FXMLLoader.load(fxmlURL);
        primaryStage.setTitle("Sight Read Symphony!");
        primaryStage.getIcons().add(new Image(iconURL.toString()));
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
    }

    /** goes to next layout, where user chooses game options */
    @FXML public void onClickPracticeFlashcards() {
        navToFxml("src/main/resources/fxml/choose_midi_device.fxml");
    }

    /** goes to debug layout, where dev can do whatever they want, without worrying about screwing up the choose options layout */
    @FXML public void onClickDebug() {
        navToFxml("src/main/resources/fxml/game_area.fxml");
    }

    /** general method for navigating to a layout, given the relative path*/
    private void navToFxml(String relativePath) {
        Stage stage = (Stage) randgen.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File(relativePath).toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, WINDOW_WIDTH, WINDOW_HEIGHT));
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
