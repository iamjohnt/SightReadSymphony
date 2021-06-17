import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @FXML public Text play;
    @FXML public Text drills;
    @FXML public Text flashcards;
    @FXML public Text options;

    private Stage stage = null;
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        URL url = new File("src/main/resources/fxml/main.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1000, 600));
        stage = primaryStage;
        primaryStage.show();
    }

    @FXML
    public void navChooseNotation() {
        Stage stage = (Stage) play.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/choose_notation.fxml").toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, WINDOW_WIDTH, WINDOW_HEIGHT));
        stage.show();
    }

    @FXML
    public void navChooseSong() {
        Stage stage = (Stage) play.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/choose_song.fxml").toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, WINDOW_WIDTH, WINDOW_HEIGHT));
        stage.show();
    }

    @FXML
    public void navSettings() {
        Stage stage = (Stage) play.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/settings.fxml").toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, WINDOW_WIDTH, WINDOW_HEIGHT));
        stage.show();
    }

    @FXML
    public void highlight() {

    }

    @FXML
    public void unHighlight() {

    }

    private void setGameMode() {
        // todo
    }

    public static void main(String[] args) {
        launch(args);
    }

}
