package logic;

import draw.Draw;
import draw.Spawner;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import midi.MidiListener;
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
        this.midiDevice = midiDevice;
        addListenerThanHandlesNoteOnNoteOff();
    }

    public void start() {
        if (quizNoteImageView != null) {
            pane.getChildren().remove(quizNoteImageView);
            quizNote = null;
        }
        quizNote = noteGenerator.getRandomTrebleNamedNote();
        quizNoteImageView = spawner.spawnUserNote(quizNote.getId(), 500);
    }

    public void drawClefs() {
        double trebleX1 = config.getTrebleClefX();
        double trebleX2 = config.getTrebleClefX() + config.getTrebleClefWidth();
        drawTrebleClef(trebleX1, trebleX2);

        double bassX1 = config.getBassClefX();
        double bassX2 = config.getBassClefX() + config.getTrebleClefWidth();
        drawBassClef(bassX1, bassX2);
    }

    private void drawTrebleClef(double x1, double x2) {
        double f5_y = noteContext.getTrebleLineY(NamedNote.F_5);
        double d5_y = noteContext.getTrebleLineY(NamedNote.D_5);
        double b4_y = noteContext.getTrebleLineY(NamedNote.B_4);
        double g4_y = noteContext.getTrebleLineY(NamedNote.G_4);
        double e4_y = noteContext.getTrebleLineY(NamedNote.E_4);
        graphicsContext.strokeLine(x1, f5_y, x2, f5_y);
        graphicsContext.strokeLine(x1, d5_y, x2, d5_y);
        graphicsContext.strokeLine(x1, b4_y, x2, b4_y);
        graphicsContext.strokeLine(x1, g4_y, x2, g4_y);
        graphicsContext.strokeLine(x1, e4_y, x2, e4_y);
        spawner.spawnTrebleClefSymbol(x1, noteContext.getTrebleLineY(NamedNote.G_5));
    }

    private void drawBassClef(double x1, double x2) {
        double a3_y = noteContext.getBassLineY(NamedNote.A_3);
        double f3_y = noteContext.getBassLineY(NamedNote.F_3);
        double d3_y = noteContext.getBassLineY(NamedNote.D_3);
        double b2_y = noteContext.getBassLineY(NamedNote.B_2);
        double g2_y = noteContext.getBassLineY(NamedNote.G_2);
        graphicsContext.strokeLine(x1, a3_y, x2, a3_y);
        graphicsContext.strokeLine(x1, f3_y, x2, f3_y);
        graphicsContext.strokeLine(x1, d3_y, x2, d3_y);
        graphicsContext.strokeLine(x1, b2_y, x2, b2_y);
        graphicsContext.strokeLine(x1, g2_y, x2, g2_y);
        spawner.spawnBassClefSymbol(x1, noteContext.getBassLineY(NamedNote.A_3));
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
