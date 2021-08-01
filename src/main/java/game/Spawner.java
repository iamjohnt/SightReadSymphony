package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import game.Config;
import javafx.scene.shape.Rectangle;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
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
        // get note wrapper
        MusicObject note = activeUserSubmittedNotes.remove(noteID);
        removeFromPane(note);
    }

    public ImageView spawnUserNote(int noteID, double x) {
        // determine if note will be treble or not
        Note note;
        if (new NamedNote(noteID).compare(new NamedNote(NamedNote.C_4)) > 0) {
            note = new Note(noteID, true, config);
        } else {
            note = new Note(noteID, false, config);
        }

        // add all notes, accidentals, and ledgers to pane
        addToPane(note);

        // add t
        activeUserSubmittedNotes.put(noteID, note);
        return null;
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
