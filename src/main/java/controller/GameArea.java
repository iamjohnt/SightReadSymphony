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
    private Spawner spawner;
    private Clef treble;
    private Clef bass;
    private KeySignature keySig;
    private NoteContext context;
    private GameSession game;

    private HashMap<String, ImageView> activeNotes;


    public void initialize() {
        // init noteContext
        Config config = new Config();
        context = new NoteContext(config);

        // init session
        spawner = new Spawner(pane);
        game = new GameSession();
        game.setNoteContext(context);
        game.setGraphicsContext(canvas.getGraphicsContext2D());
        game.setSpawner(spawner);
        game.setLineHeight(18);

        // draw clefs and symbols
        drawClefs();

        // holds references to active notes
        activeNotes = new HashMap<>();

    }


    private void drawClefs() {
        game.drawTrebleClef(200, 800);
        game.drawBassClef(200, 800);
    }

    public void setMidiDevice(MidiDevice midiDevice) {
        this.midiDevice = midiDevice;
        System.out.println("set " + midiDevice.getDeviceInfo().getName());

        MidiReceiver myReceiver = new MidiReceiver();
        myReceiver.addListener(message -> {
            if (message instanceof ShortMessage) {
                ShortMessage sm = (ShortMessage) message;
                handleShortMessage(sm);
            }
        });
        try {
            this.midiDevice.getTransmitter().setReceiver(myReceiver);
            this.midiDevice.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }


    public void handleShortMessage(ShortMessage sm) {
        if (sm.getCommand() == ShortMessage.NOTE_ON) {
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    // do GUI stuff here
                    int key = sm.getData1();
                    System.out.println(key + " on");
                    MidiNote note = new MidiNote(key, MidiNote.NO_ACCIDENTAL);
                    int noteID = note.toNamedNoteV2(MidiNote.FLAT).getId();
                    ImageView view = game.spawnTrebleNote(noteID,  400);
                    activeNotes.put(view.getId(), view);
                }
            });

        } else if (sm.getCommand() == ShortMessage.NOTE_OFF) {

            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    // do GUI stuff here
                    int key = sm.getData1();
                    System.out.println(key + " off");
                    MidiNote note = new MidiNote(key, MidiNote.NO_ACCIDENTAL);
                    ImageView view = activeNotes.get(Integer.toString(note.toNamedNoteV2(MidiNote.FLAT).getId()));
                    game.despawnNote(view);
                }
            });
        } else {
            System.out.println("Command:" + sm.getCommand());
        }
    }

    public void spawnC4Treble() {
        game.spawnTrebleNote(NamedNote.C_4, 400);
    }

}
