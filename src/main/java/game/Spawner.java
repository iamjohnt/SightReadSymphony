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
    private HashMap<Integer, ImageView> activeUserNotes = new HashMap<>();
    private HashMap<Integer, ImageView> activeUserAccidentals = new HashMap<>();
    private HashMap<Integer, ImageView> activeUserLedgers = new HashMap<>();
    private HashMap<Integer, MusicObject> activeUserSubmittedNotes = new HashMap<>();
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

        // despawn note image
        ImageView view = note.getNotesViews()[0];
        pane.getChildren().remove(view);

        // despawn accidental
        ImageView accView = note.getAccidentalViews()[0];
        if (accView != null) {
            System.out.println(accView.getId());
            pane.getChildren().remove(accView);
        }

        // despawn ledgers
        if (note.getLedgerRectangles() != null) {
            Rectangle[] ledgers = note.getLedgerRectangles();
            for (int i = 0; i < ledgers.length; i++) {
                pane.getChildren().remove(ledgers[i]);
            }
        }
    }

    public ImageView spawnUserNote(int noteID, double x) {

        // put note wrapper into user submitted notes
        double y = context.getTrebleNoteY(noteID);
        Note note;
        if (new NamedNote(noteID).compare(new NamedNote(NamedNote.C_4)) > 0) {
            note = new Note(noteID, true, config);
        } else {
            note = new Note(noteID, false, config);
        }
        activeUserSubmittedNotes.put(noteID, note);

        // spawn the note image
        ImageView noteView = note.getNotesViews()[0];
        pane.getChildren().add(noteView);

        // spawn accidental image
        if (note.getAccidentalViews()[0] != null) {
            ImageView accView = note.getAccidentalViews()[0];
            pane.getChildren().add(accView);
        }

        // spawn the ledger
        if (note.getLedgerRectangles() != null) {
            Rectangle[] ledgers = note.getLedgerRectangles();
            for (int i = 0; i < ledgers.length; i++) {
                pane.getChildren().add(ledgers[i]);
            }
        }
        return noteView;
    }

    private void spawnQuizMusicObject() {

    }

    private void despawnQuizMusicObject() {

    }

    private void advanceMusicObjectLeft() {

    }
}
