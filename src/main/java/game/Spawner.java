package game;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import game.Config;
import javafx.scene.shape.Rectangle;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Spawner {

    private Pane pane;
    private double lineHeight;
    private NoteContext context;
    private HashMap<Integer, MusicObject> activeUserSubmittedNotes = new HashMap<>();
    private MusicObject currentQuizMusicObject;
    private Queue<MusicObject> musicObjects;
    private Queue<MusicObject> displayedMusicObjects;
    private Config config;


    public Spawner(Pane pane, Config config) {
        this.pane = pane;
        this.lineHeight = config.getTrebleClefLineHeight();
        this.context = new NoteContext(config);
        this.config = config;
        this.musicObjects = new LinkedList<>();
        initQueue();
        displayedMusicObjects = new LinkedList<>();
    }

    public MusicObject despawnUserNote(int noteID) {
        MusicObject note = activeUserSubmittedNotes.remove(noteID);
        removeFromPane(note);
        return note;
    }

    public MusicObject spawnUserNote(int noteID, double x) {
        boolean isTreble = isTreble(noteID);
        Note note = new Note(noteID, isTreble, x, config);
        addToPane(note);
        activeUserSubmittedNotes.put(noteID, note);
        return note;
    }

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

    private void initQueue() {
        NoteGenerator gen = new NoteGenerator(config);
        for (int i = 0; i < 12; i++) {
            NamedNote randNote = gen.getRandomNamedNote();
            boolean isTreble = isTreble(randNote.getId());
            Note note = new Note(randNote.getId(), isTreble, config.getQuizSpawnX(), config);
            musicObjects.add(note);
        }
        System.out.println("init queue");
    }

    public void advanceQueue() {

        MusicObjectAnimator anim = new MusicObjectAnimator();
        System.out.println("starting to advance queue");
        if (!anim.isAnimating()) {
            MusicObject next = musicObjects.remove();
            addToPane(next);
            displayedMusicObjects.add(next);
            anim.moveAllMusicObjectsLeft(displayedMusicObjects, -100);
        }
    }

    private boolean isTreble(int noteID) {
        if (new NamedNote(noteID).compare(new NamedNote(NamedNote.C_4)) > 0) {
            return true;
        } else {
            return false;
        }
    }

    private MusicObject addToPane(MusicObject musicObject) {
        ImageView[] notes = musicObject.getNotesViews();
        ImageView[] accs = musicObject.getAccidentalViews();
        Rectangle[] rects = musicObject.getLedgerRectangles();
        Label[] labels = musicObject.getDescriptionLabels();

        for (ImageView noteView : notes) { pane.getChildren().add(noteView); }
        for (ImageView accView : accs) { pane.getChildren().add(accView); }
        for (Rectangle rectView : rects) { pane.getChildren().add(rectView); }
        for (Label label : labels) { pane.getChildren().add(label); }
        return musicObject;
    }

    private MusicObject removeFromPane(MusicObject musicObject) {
        ImageView[] notes = musicObject.getNotesViews();
        ImageView[] accs = musicObject.getAccidentalViews();
        Rectangle[] rects = musicObject.getLedgerRectangles();
        Label[] labels = musicObject.getDescriptionLabels();

        for (ImageView noteView : notes) { pane.getChildren().remove(noteView); }
        for (ImageView accView : accs) { pane.getChildren().remove(accView); }
        for (Rectangle rectView : rects) { pane.getChildren().remove(rectView); }
        for (Label label : labels) { pane.getChildren().remove(label); }
        return musicObject;
    }

}
