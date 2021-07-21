package controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @FXML public Text flashcards;
    @FXML public Text debug;

    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{
        URL url = new File("src/main/resources/fxml/main.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
    }

    @FXML
    public void onClickPracticeFlashcards() {
        navToFxml("src/main/resources/fxml/choose_midi_device.fxml");
    }

    @FXML
    public void onClickDebug() {
        navToFxml("src/main/resources/fxml/game_area.fxml");
    }


    private void navToFxml(String relativePath) {
        Stage stage = (Stage) flashcards.getScene().getWindow();
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
