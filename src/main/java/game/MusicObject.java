package game;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import notecontext.NamedNote;

public interface MusicObject {

    public ImageView[] getNotesViews();

    public ImageView[] getAccidentalViews();

    public Rectangle[] getLedgerRectangles();

    public Label[] getDescriptionLabels();

    public NamedNote[] getNamedNotes();

}
