package controller;

import draw.Spawner;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import logic.Config;
import midi.MidiReceiver;
import notecontext.*;
import session.GameSession;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import java.util.HashMap;


public class GameArea {

    @FXML public Pane pane;
    @FXML public Canvas canvas;
    @FXML public Button spawnIt;

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

    public void setMidiDevice(MidiDevice midiDevice) {
        this.midiDevice = midiDevice;
    }
}
