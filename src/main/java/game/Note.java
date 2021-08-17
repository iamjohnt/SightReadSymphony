package game;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/** Overview - holds all info needed about a note - the data, the dimensions, the images of it, etc.
 * UseCase - GameSession will compare user submitted notes, to the quiz's note, to determine if equal or not.
 * Spawner will spawn or animate notes, by getting and manipulating its' internal nodes (image views, labels, or rectangles) */
public class Note implements MusicObject{

    private int noteID;
    private NamedNote namedNote;
    private double x;
    private double y;
    private double noteCenterY;
    private double lineHeight;
    private ImageView noteImageView;
    private ImageView accidentalImageView;
    private ArrayList<Rectangle> ledgerRectangles;
    private Label noteInfoLabel;
    private boolean isNoteChromatic;
    private boolean isTreble;
    private NoteContext context;

    public Note(int noteID, boolean isTreble, double x, Config config) {
        context = new NoteContext(config);
        this.x = x;
        if (isTreble) {
            this.y = context.getTrebleNoteY(noteID);
            this.noteCenterY = context.getTrebleLineY(noteID);
        } else {
            this.y = context.getBassNoteY(noteID);
            this.noteCenterY = context.getBassLineY(noteID);
        }
        this.noteID = noteID;
        this.namedNote = new NamedNote(noteID);
        this.lineHeight = config.getTrebleClefLineHeight();
        this.isTreble = isTreble;
        this.isNoteChromatic = context.isNoteChromatic(noteID);
        this.ledgerRectangles = new ArrayList<>();

        // create note image view
        noteImageView = createImageView("src/main/resources/images/whole_note.png", Integer.toString(noteID), x, y, lineHeight);

        // create accidental view
        ImageView accView = null;
        if (!isNoteChromatic) {
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

        createLedgers(noteID, isTreble);
        createLabel(noteID, isTreble);
    }

    /** creates the ledgers, for when a note is above or below the clef's 5 main lines */
    private void createLedgers(int noteID, boolean isTreble) {
        // determine the top and bot location of the y
        double topY;
        double botY;
        if (isTreble) {
            topY = context.getTrebleLineY(NamedNote.F_5);
            botY = context.getTrebleLineY(NamedNote.E_4);
        } else {
            topY = context.getBassLineY(NamedNote.A_3);
            botY = context.getBassLineY(NamedNote.G_2);
        }
        double ledgerLength = lineHeight * 2.5;
        double ledgerX = x - (ledgerLength / 5);
        double curr;
        if (noteCenterY < topY) {
            // we are above, so we draw up towards current note
            curr = topY - lineHeight;
            while (curr >= noteCenterY) {

                Rectangle rectangle = new Rectangle(ledgerX,curr, ledgerLength,1);
                ledgerRectangles.add(rectangle);
                curr = curr - lineHeight;
            }
        } else if (noteCenterY > botY) {
            // we are below, so we draw down towards current note
            curr = botY + lineHeight;
            while (curr <= noteCenterY) {
                Rectangle rectangle = new Rectangle(ledgerX, curr, ledgerLength, 1);
                ledgerRectangles.add(rectangle);
                curr = curr + lineHeight;
            }
        }
    }

    private Label createLabel(int noteID, boolean isTreble) {
        Label noteInfo = new Label();
        noteInfo.setText(new NamedNote(noteID).toString());
        noteInfo.setLayoutX(x + lineHeight * 2.5);
        noteInfo.setLayoutY(y - (lineHeight / 4));
        noteInfo.setFont(Font.font("Arial", FontWeight.BOLD, lineHeight * 1.25));
        noteInfo.setTextFill(Color.GRAY);
        noteInfo.setStyle("-fx-border-color:gray; -fx-background-color: white;");
        noteInfoLabel = noteInfo;
        return noteInfo;
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

    @Override public ImageView[] getNotesViews() {
        ImageView[] rtn;
        if (noteImageView == null) {
            rtn = new ImageView[0];
            return rtn;
        } else {
            rtn = new ImageView[1];
            rtn[0] = noteImageView;
            return rtn;
        }
    }

    @Override public ImageView[] getAccidentalViews() {
        ImageView[] rtn;
        if (accidentalImageView == null) {
            rtn = new ImageView[0];
            return rtn;
        } else {
            rtn = new ImageView[1];
            rtn[0] = accidentalImageView;
            return rtn;
        }
    }

    @Override public Rectangle[] getLedgerRectangles() {
        Rectangle[] ledgersArray = new Rectangle[this.ledgerRectangles.size()];
        for (int i = 0; i < ledgersArray.length; i++) {
            ledgersArray[i] = ledgerRectangles.get(i);
        }
        return ledgersArray;
    }

    @Override public Label[] getDescriptionLabels() {
        Label[] rtn = {noteInfoLabel};
        return rtn;
    }

    @Override public NamedNote[] getNamedNotes() {
        NamedNote[] rtn = {new NamedNote(noteID)};
        return rtn;
    }

    /** note's image view is changed to green note image view (for when correct) */
    public void setNoteGreen() {
        URL url = null;
        try {
            url = new File("src/main/resources/images/green_note.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        this.noteImageView.setImage(image);
    }

    /** note's image view is changed to red note image view (for when incorrect) */
    public void setNoteRed() {
        URL url = null;
        try {
            url = new File("src/main/resources/images/red_note.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        this.noteImageView.setImage(image);
    }

    /** used to compare if a note's value equals another note*/
    @Override public boolean equals(Object object) {
        if (object instanceof Note) {
            Note otherNote = (Note) object;
            if (noteID == otherNote.getNoteID() && isTreble == otherNote.isTreble) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // getters and setters ==========================================================================================


    public boolean isTreble() {
        return isTreble;
    }

    public int getNoteID() {
        return noteID;
    }
}
