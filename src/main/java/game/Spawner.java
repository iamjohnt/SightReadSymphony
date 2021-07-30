package game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import game.Config;
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


    public Spawner(Pane pane, Config config) {
        this.pane = pane;
        this.lineHeight = config.getTrebleClefLineHeight();
        this.context = new NoteContext(config);
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
    }

    public ImageView spawnUserNote(int noteID, double x) {

        // put note wrapper into user submitted notes
        double y = context.getTrebleNoteY(noteID);
        Note note = new Note(noteID, x, y, lineHeight, context.isNoteChromatic(noteID));
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
        return noteView;
    }

    private void spawnQuizMusicObject() {

    }

    private void despawnQuizMusicObject() {

    }

    private void advanceMusicObjectLeft() {

    }
}
