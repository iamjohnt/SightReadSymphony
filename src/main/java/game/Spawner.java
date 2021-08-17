package game;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/** Overview - can spawn and despawn music objects to the pane.
 * UseCase - will be instantiated in game session, which will determine how and when to spawn or despawn
 * FYI - in order to despawn something, we need a remember a reference to what was spawned.
 * That is why whenever we spawn a music object to the pane, we remember its reference in the hashmap (for user submitted music objects)
 * or displayedMusicObjects queue (for the quiz's music objects). That way, we can despawn it when needed. */
public class Spawner {

    private Pane pane;
    private double lineHeight;
    private NoteContext context;
    private HashMap<Integer, MusicObject> activeUserSubmittedNotes = new HashMap<>();
    private MusicObject currentQuizMusicObject;
    private Queue<MusicObject> displayedMusicObjects;
    private Config config;

    /** constructs spawner, by passing a Pane that the spawner will spawn nodes to, and a config object which determines what and how something will be spawned */
    public Spawner(Pane pane, Config config) {
        this.pane = pane;
        this.lineHeight = config.getTrebleClefLineHeight();
        this.context = new NoteContext(config);
        this.config = config;
        this.displayedMusicObjects = new LinkedList<>();
    }

    /** despawns the user submitted music object */
    public MusicObject despawnUserNote(int noteID) {
        MusicObject note = activeUserSubmittedNotes.remove(noteID);
        removeFromPane(note);
        return note;
    }

    /** spawns the user submitted music object */
    public MusicObject spawnUserNote(int noteID, double x) {
        boolean isTreble = isTreble(noteID);
        Note note = new Note(noteID, isTreble, x, config);
        addToPane(note);
        activeUserSubmittedNotes.put(noteID, note);
        return note;
    }

    /** spawns a new quiz music object at the end of the line */
    public MusicObject spawnNextQuiz() {
        NoteGenerator gen = new NoteGenerator(config);
        NamedNote randNote = gen.getRandomNamedNote();
        boolean isTreble = isTreble(randNote.getId());
        Note note = new Note(randNote.getId(), isTreble,config.getQuizSpawnX(), config);
        if (currentQuizMusicObject != null) {
            removeFromPane(currentQuizMusicObject);
        }
        MusicObject newMusicObject = addToPane(note);
        currentQuizMusicObject = newMusicObject;
        return note;
    }

    /** generates and spawns a specified number of quiz music objects, that will form a line.
     * The front of the line, is the current music object, that the user must try to match when pressing a key */
    public void initDisplayQueue(int count) {
        NoteGenerator gen = new NoteGenerator(config);
        MusicObjectAnimator anim = new MusicObjectAnimator();
        double start = config.getQuizSpawnX() + (config.getQuizShiftLeftAmount() * (count - 1));
        double shift = config.getQuizShiftLeftAmount();
        for (int i = 0; i < count; i++) {
            NamedNote randNote = gen.getRandomNamedNote();
            boolean isTreble = isTreble(randNote.getId());
            Note note = new Note(randNote.getId(), isTreble, start + shift, config);
            displayedMusicObjects.add(note);
            addToPane(note);
            start = start - shift;
        }
    }

    /** Despawns the quiz music object at the front of the line, and animates the whole line to move forward */
    public MusicObject advanceQueue() {
        MusicObjectAnimator anim = new MusicObjectAnimator();
        MusicObject rtn = null;
        if (!anim.isAnimating()) {
            // despawn the front of queue
            rtn = displayedMusicObjects.remove();
            System.out.println(rtn.getNamedNotes()[0].getId());
            removeFromPane(rtn);

            // add to back of queue
            NoteGenerator gen = new NoteGenerator(config);
            NamedNote randNote = gen.getRandomNamedNote();
            boolean isTreble = isTreble(randNote.getId());
            Note note = new Note(randNote.getId(), isTreble, config.getQuizSpawnX(), config);
            displayedMusicObjects.add(note);
            addToPane(note);

            // then animate everything
            double shiftAmount = (config.getQuizDespawnX() - config.getQuizSpawnX()) / config.getQuizCountOnScreen();
            anim.moveAllMusicObjectsLeft(displayedMusicObjects, shiftAmount);
        }
        return null;
    }

    /** gets the music object from the front of the queue   */
    public MusicObject getCurrentQuizMusicObject() {
        return displayedMusicObjects.peek();
    }

    public boolean isTreble(int noteID) {
        if (new NamedNote(noteID).compare(new NamedNote(NamedNote.B_3)) > 0) {
            return true;
        } else {
            return false;
        }
    }

    // adds a music object's internal nodes to the pane
    private MusicObject addToPane(MusicObject musicObject) {
        ImageView[] notes = musicObject.getNotesViews();
        ImageView[] accs = musicObject.getAccidentalViews();
        Rectangle[] rects = musicObject.getLedgerRectangles();
        Label[] labels = musicObject.getDescriptionLabels();

        for (ImageView noteView : notes) {
            pane.getChildren().add(noteView);
        }
        for (ImageView accView : accs) {
            pane.getChildren().add(accView);
        }
        for (Rectangle rectView : rects) {
            pane.getChildren().add(rectView);
        }
        for (Label label : labels) {
            pane.getChildren().add(label);
        }
        return musicObject;
    }

    // removes a music object's internal nodes from the pane
    private MusicObject removeFromPane(MusicObject musicObject) {
        Note note = (Note) musicObject;
        System.out.println("removed from pane : " + note.getNoteID());
        ImageView[] notes = musicObject.getNotesViews();
        ImageView[] accs = musicObject.getAccidentalViews();
        Rectangle[] rects = musicObject.getLedgerRectangles();
        Label[] labels = musicObject.getDescriptionLabels();

        for (ImageView noteView : notes) {
            pane.getChildren().remove(noteView);
        }
        for (ImageView accView : accs) {
            pane.getChildren().remove(accView);
        }
        for (Rectangle rectView : rects) {
            pane.getChildren().remove(rectView);
        }
        for (Label label : labels) {
            pane.getChildren().remove(label);
        }
        return musicObject;
    }

}
