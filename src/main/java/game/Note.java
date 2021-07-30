package game;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import notecontext.NamedNote;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Note implements MusicObject{

    private int noteID;
    private ImageView noteImageView;
    private ImageView accidentalImageView;
    private ImageView[] ledgerImageViews;
    private Label descriptionLabel;
    private boolean isNoteChromatic;

    public Note(int noteID, double x, double y, double lineHeight, boolean isChromatic) {

        // create note image view
        noteImageView = createImageView("src/main/resources/images/whole_note.png", Integer.toString(noteID), x, y, lineHeight);

        // create accidental view
        ImageView accView = null;
        if (isChromatic) {
            String accidentalImagePath = null;
            int accidental = new NamedNote(noteID).getAccidental();
            accView = null;
            switch (accidental) {
                case NamedNote.FLAT:
                    accidentalImagePath = "src/main/resources/images/flat.png";
                    accView = createImageView(accidentalImagePath, Integer.toString(noteID), x - lineHeight, y - lineHeight, lineHeight * 2);
                    break;
                case NamedNote.NO_ACCIDENTAL:
                    accidentalImagePath = "src/main/resources/images/natural.png";
                    accView = createImageView(accidentalImagePath, Integer.toString(noteID), x - lineHeight, y - (lineHeight / 2), lineHeight * 2);
                    break;
                case NamedNote.SHARP:
                    accidentalImagePath = "src/main/resources/images/sharp.png";
                    accView = createImageView(accidentalImagePath, Integer.toString(noteID), x - lineHeight, y - (lineHeight / 2), lineHeight * 2);
                    break;
                default:
                    System.out.println("impossible...");
                    break;
            }
        }
        accidentalImageView = accView;
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


    @Override
    public ImageView[] getNotesViews() {
        ImageView[] rtn = {noteImageView};
        return rtn;
    }

    @Override
    public ImageView[] getAccidentalViews() {
        ImageView[] rtn = {accidentalImageView};
        return rtn;
    }

    @Override
    public Label[] getDescriptionLabels() {
        Label[] rtn = {descriptionLabel};
        return rtn;
    }

    @Override
    public NamedNote[] getNamedNotes() {
        NamedNote[] rtn = {new NamedNote(noteID)};
        return rtn;
    }
}
