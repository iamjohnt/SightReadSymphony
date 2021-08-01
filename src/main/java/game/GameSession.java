package game;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import midi.MidiReceiver;
import notecontext.MidiNote;
import notecontext.NamedNote;
import notecontext.NoteContext;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.ShortMessage;
import java.util.HashMap;

public class GameSession {

    private Config config;
    private NoteContext noteContext;
    private Spawner spawner;
    private Draw draw;
    private GraphicsContext graphicsContext;
    private Pane pane;
    private double lineHeight;
    private HashMap<String, ImageView> activeNotes = new HashMap<>();
    private MidiDevice midiDevice;
    private NoteGenerator noteGenerator;
    private NamedNote quizNote;
    private ImageView quizNoteImageView;
    private NamedNote submittedNote;

    public GameSession(Config config, MidiDevice midiDevice) {
        this.config = config;
        this.noteContext = new NoteContext(config);
        this.noteGenerator = new NoteGenerator(config);
        this.draw = new Draw(graphicsContext, config);
        this.midiDevice = midiDevice;
        addListenerThanHandlesNoteOnNoteOff();
    }

    public void start() {
        spawner.spawnNextQuiz();
    }

    public void drawClefs() {
        draw.drawClefs();
    }

    public void addListenerThanHandlesNoteOnNoteOff() {
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

    private void handleShortMessage(ShortMessage sm) {
        if (sm.getCommand() == ShortMessage.NOTE_ON) {
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    // spawn note onto the screen at 400
                    int key = sm.getData1();
                    System.out.println(key + " on");
                    int acc = noteContext.getKeySigAccidental();
                    MidiNote note = new MidiNote(key, acc);
                    int noteID = note.toNamedNoteV2(acc).getId();
                    spawner.spawnUserNote(noteID, 400);
                }
            });

        } else if (sm.getCommand() == ShortMessage.NOTE_OFF) {

            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    // do GUI stuff here
                    int key = sm.getData1();
                    System.out.println(key + " off");
                    int acc = noteContext.getKeySigAccidental();
                    MidiNote note = new MidiNote(key, acc);
                    NamedNote namedNote = note.toNamedNoteV2(acc);
                    spawner.despawnUserNote(namedNote.getId());

                    // check if the note matches the quiz note
                    if (quizNote != null){
                        if (note.toNamedNoteV2(noteContext.getKeySigAccidental()).getId() == quizNote.getId()) {
                            System.out.println("correct! these DO equal: " + note.toNamedNoteV2(noteContext.getKeySigAccidental()).getId() + " " + quizNote.getId());
                            start();
                        } else {
                            System.out.println("incorrect, these two do not equal: " + note.toNamedNoteV2(noteContext.getKeySigAccidental()).getId() + " " + quizNote.getId());
                        }
                    }
                }
            });
        } else {
            System.out.println("Command:" + sm.getCommand());
        }
    }



    // getters and setters =============================================================================


    public void setNoteContext(NoteContext noteContext) {
        this.noteContext = noteContext;
    }

    public void setSpawner(Spawner spawner) {
        this.spawner = spawner;
    }

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public void setLineHeight(double lineHeight) {
        this.lineHeight = lineHeight;
    }

    public void setMidiDevice(MidiDevice midiDevice) {
        this.midiDevice = midiDevice;
    }
}
