package game;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import game.Config;
import javafx.scene.shape.Rectangle;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.util.HashMap;

public class Spawner {

    private Pane pane;
    private double lineHeight;
    private NoteContext context;
    private HashMap<Integer, MusicObject> activeUserSubmittedNotes = new HashMap<>();
    private MusicObject currentQuizMusicObject;
    private Config config;


    public Spawner(Pane pane, Config config) {
        this.pane = pane;
        this.lineHeight = config.getTrebleClefLineHeight();
        this.context = new NoteContext(config);
        this.config = config;
    }

    public void despawnUserNote(int noteID) {
        MusicObject note = activeUserSubmittedNotes.remove(noteID);
        removeFromPane(note);
    }

    public MusicObject spawnUserNote(int noteID, double x) {
        boolean isTreble = isTreble(noteID);
        Note note = new Note(noteID, isTreble, config);
        addToPane(note);
        activeUserSubmittedNotes.put(noteID, note);
        return note;
    }

    public void spawnNextQuiz() {
        NoteGenerator gen = new NoteGenerator(config);
        NamedNote randNote = gen.getRandomNamedNote();
        boolean isTreble = isTreble(randNote.getId());
        Note note = new Note(randNote.getId(), isTreble, config);
        if (currentQuizMusicObject != null) {
            removeFromPane(currentQuizMusicObject);
        }
        MusicObject newMusicObject = addToPane(note);
        currentQuizMusicObject = newMusicObject;
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

        for (ImageView noteView : notes) { pane.getChildren().add(noteView); }
        for (ImageView accView : accs) { pane.getChildren().add(accView); }
        for (Rectangle rectView : rects) { pane.getChildren().add(rectView); }
        return musicObject;
    }

    private MusicObject removeFromPane(MusicObject musicObject) {
        ImageView[] notes = musicObject.getNotesViews();
        ImageView[] accs = musicObject.getAccidentalViews();
        Rectangle[] rects = musicObject.getLedgerRectangles();

        for (ImageView noteView : notes) { pane.getChildren().remove(noteView); }
        for (ImageView accView : accs) { pane.getChildren().remove(accView); }
        for (Rectangle rectView : rects) { pane.getChildren().remove(rectView); }
        return musicObject;
    }

}
