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

/** OverView - The highest level manager of the game state, logic, and flow.
 * UseCase - GameArea controller will instantiate this, and simply call GameSession.start. In this way, the controller doesn't need to do any heavy lifting. */
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
    private MusicObject currSubmitted;
    private MusicObject currQuiz;

    /** initializes the game session */
    public GameSession(Config config, MidiDevice midiDevice) {
        // creates other helper objects based on config
        this.config = config;
        this.noteContext = new NoteContext(config);
        this.noteGenerator = new NoteGenerator(config);
        this.draw = new Draw(graphicsContext, config);
        this.midiDevice = midiDevice;

        // determines what to do, when a ShortMessage arrives from the MidiDevice
        MidiReceiver myReceiver = new MidiReceiver();
        myReceiver.addListener(message -> {
            if (message instanceof ShortMessage) {
                ShortMessage sm = (ShortMessage) message;
                handleShortMessage(sm);
            }
        });

        // opens the midi device connection
        try {
            this.midiDevice.getTransmitter().setReceiver(myReceiver);
            this.midiDevice.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }

    /** starts the game */
    public void start() {
        spawner.initDisplayQueue(config.getQuizCountOnScreen());
        currQuiz = spawner.getCurrentQuizMusicObject();
    }

    public void advance() {
        spawner.advanceQueue();
    }

    public void drawClefs() {
        draw.drawClefs();
    }

    /** handles user key presses and key releases. */
    private void handleShortMessage(ShortMessage sm) {
        if (sm.getCommand() == ShortMessage.NOTE_ON) {
            // then key is pressed
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    // determine the note ID from the submitted midi note
                    int midiID = sm.getData1();
                    int requestedAccidental = noteContext.getKeySigAccidental();
                    System.out.println(midiID + " on");
                    MidiNote note = new MidiNote(midiID, requestedAccidental);
                    int noteID = note.toNamedNote(requestedAccidental).getId();

                    // spawn submitted note
                    Note currSubmit = (Note) spawner.spawnUserNote(noteID, config.getUserNoteX());

                    // check if submission right or wrong
                    if (currQuiz != null) {
                        if (currSubmit.equals(currQuiz)) {
                            System.out.println("correct!");
                            currSubmit.setNoteGreen();
                        } else {
                            System.out.println("false!");
                            currSubmit.setNoteRed();
                        }
                    }
                }
            });
        } else if (sm.getCommand() == ShortMessage.NOTE_OFF) {
            // then key is released
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    // determine the note ID from the submitted midi note
                    int key = sm.getData1();
                    System.out.println(key + " off");
                    int acc = noteContext.getKeySigAccidental();
                    MidiNote note = new MidiNote(key, acc);
                    NamedNote namedNote = note.toNamedNote(acc);
                    boolean isTreble = spawner.isTreble(namedNote.getId());
                    Note currSubmit = (Note) new Note(namedNote.getId(), isTreble, config.getUserNoteX(), config);

                    // check if submission right or wrong
                    if (currQuiz != null) {
                        if (currSubmit.equals(currQuiz)) {
                            spawner.advanceQueue();
                            currQuiz = spawner.getCurrentQuizMusicObject();
                        }
                    }

                    // despawn submitted note
                    spawner.despawnUserNote(namedNote.getId());
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
