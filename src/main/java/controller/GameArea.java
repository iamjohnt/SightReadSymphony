package controller;

import game.Draw;
import game.Spawner;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import game.Config;
import game.GameSession;
import javafx.stage.Stage;

import javax.sound.midi.MidiDevice;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/** This controller represents the layout of the game area, the screen where the game will be played.
 * Because this controller's concern should be only about layout and should be as thin as possible,
 * all drawing, spawning, animation, and manipulation of game elements, such as notes, are handled by a separate class: GameSession. */
public class GameArea {

    @FXML public Pane pane;
    @FXML public Canvas canvas;
    @FXML public Button start;
    @FXML public Button skip;
    @FXML public Button home;

    private MidiDevice midiDevice;
    private GameSession game;
    private Config config;

    /** Initializes the game session, by passing it the config object, and a reference to the midi device that the user chose.
     * In addition, we also pass in thi controller's graphics context (so the game session can draw to the canvas)
     * and also pass in this controller's root pane (so the games session can spawn and manipulate nodes to the layout)
     * We the begin the game session, by calling GameSession.start */
    public void initGameSession() {
        game = new GameSession(this.config, midiDevice);
        game.setGraphicsContext(canvas.getGraphicsContext2D());
        game.setPane(pane);
        game.setSpawner(new Spawner(pane, config));
        game.setDraw(new Draw(canvas.getGraphicsContext2D(), config));

        // draw clefs and symbols
        game.drawClefs();
    }

    @FXML
    public void start() {
        start.setDisable(true);
        game.start();
    }

    @FXML
    public void skip() {
        System.out.println("game area advance button click registered");
        game.advance();
    }

    @FXML
    public void navHome() {
        navToFxml("src/main/resources/fxml/main.fxml");
    }

    private void navToFxml(String relativePath) {
        Stage stage = (Stage) start.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File(relativePath).toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, 1200, 600));
        stage.show();
    }

    public void setMidiDevice(MidiDevice midiDevice) {
        this.midiDevice = midiDevice;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
