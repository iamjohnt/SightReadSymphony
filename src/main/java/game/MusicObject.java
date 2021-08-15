package game;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import notecontext.NamedNote;

/* declares methods that are needed by any music object, whether note, interval, or chord */
public interface MusicObject {

    public ImageView[] getNotesViews();

    public ImageView[] getAccidentalViews();

    public Rectangle[] getLedgerRectangles();

    public Label[] getDescriptionLabels();

    public NamedNote[] getNamedNotes();

}
