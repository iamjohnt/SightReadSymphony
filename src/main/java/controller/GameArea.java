package controller;

import game.Draw;
import game.Spawner;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import game.Config;
import game.GameSession;

import javax.sound.midi.MidiDevice;

/** This controller represents the layout of the game area, the screen where the game will be played.
 * Because this controller's concern should be only about layout and should be as thin as possible,
 * all drawing, spawning, animation, and manipulation of game elements, such as notes, are handled by a separate class: GameSession. */
public class GameArea {

    @FXML public Pane pane;
    @FXML public Canvas canvas;
    @FXML public Button start;
    @FXML public Button advance;

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
        game.start();
    }

    @FXML
    public void advance() {
        System.out.println("game area advance button click registered");
        game.advance();
    }

    public void setMidiDevice(MidiDevice midiDevice) {
        this.midiDevice = midiDevice;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
}
