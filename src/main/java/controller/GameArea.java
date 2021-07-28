package controller;

import draw.Spawner;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import logic.Config;
import logic.GameSession;

import javax.sound.midi.MidiDevice;


public class GameArea {

    @FXML public Pane pane;
    @FXML public Canvas canvas;
    @FXML public Button start;

    private MidiDevice midiDevice;
    private GameSession game;

    public void initGameSession() {
        Config config = new Config();
        game = new GameSession(config, midiDevice);
        game.setGraphicsContext(canvas.getGraphicsContext2D());
        game.setSpawner(new Spawner(pane, config.getTrebleClefLineHeight()));

        // draw clefs and symbols
        game.drawClefs();
    }

    @FXML
    public void start() {
        game.start();
    }

    public void setMidiDevice(MidiDevice midiDevice) {
        this.midiDevice = midiDevice;
    }
}
