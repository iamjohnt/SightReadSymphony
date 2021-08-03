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


public class GameArea {

    @FXML public Pane pane;
    @FXML public Canvas canvas;
    @FXML public Button start;
    @FXML public Button advance;

    private MidiDevice midiDevice;
    private GameSession game;
    private Config config;

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
