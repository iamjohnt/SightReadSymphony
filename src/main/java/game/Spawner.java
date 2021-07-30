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


    public Spawner(Pane pane, Config config) {
        this.pane = pane;
        this.lineHeight = config.getTrebleClefLineHeight();
        this.context = new NoteContext(config);
    }


    public ImageView despawnUserNote(int noteID) {
        ImageView view = activeUserNotes.remove(noteID);
        pane.getChildren().remove(view);
        ImageView accView = activeUserAccidentals.remove(noteID);
        pane.getChildren().remove(accView);
        return view;
    }

    public ImageView spawnUserNote(int noteID, double x) {
        double y = context.getTrebleNoteY(noteID);

        // spawn the note
        ImageView noteView = createImageView("src/main/resources/images/whole_note.png", Integer.toString(noteID), x, y, lineHeight);
        pane.getChildren().add(noteView);
        activeUserNotes.put(noteID, noteView);
        System.out.println("spawn " + noteView.getId());

        // spawn the accidental
        if (!context.isNoteChromatic(noteID)) {
            String accidentalImagePath = null;
            int accidental = new NamedNote(noteID).getAccidental();
            ImageView accView = null;
            switch (accidental) {
                case NamedNote.FLAT:
                    accidentalImagePath = "src/main/resources/images/flat.png";
                    accView = createImageView(accidentalImagePath, Integer.toString(noteID), x - lineHeight, y - lineHeight, lineHeight * 2);
                    activeUserAccidentals.put(noteID, accView);
                    pane.getChildren().add(accView);
                    break;
                case NamedNote.NO_ACCIDENTAL:
                    accidentalImagePath = "src/main/resources/images/natural.png";
                    accView = createImageView(accidentalImagePath, Integer.toString(noteID), x - lineHeight, y - (lineHeight / 2), lineHeight * 2);
                    activeUserAccidentals.put(noteID, accView);
                    pane.getChildren().add(accView);
                    break;
                case NamedNote.SHARP:
                    accidentalImagePath = "src/main/resources/images/sharp.png";
                    accView = createImageView(accidentalImagePath, Integer.toString(noteID), x - lineHeight, y - (lineHeight / 2), lineHeight * 2);
                    activeUserAccidentals.put(noteID, accView);
                    pane.getChildren().add(accView);
                    break;
                default:
                    System.out.println("impossible...");
                    break;
            }
        }

        // spawn the ledger
        return noteView;
    }

    private ImageView createImageView(String imagePath, String id, double x, double y, double height) {
        URL url = null;
        try {
            url = new File(imagePath).toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        ImageView view = new ImageView();
        view.setFitHeight(height);
        view.setLayoutX(x);
        view.setLayoutY(y);
        view.setPreserveRatio(true);
        view.setImage(image);
        view.setId(id);
        view.toFront();
        return view;
    }
}
