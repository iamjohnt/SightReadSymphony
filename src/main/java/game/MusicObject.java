package game;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import notecontext.NamedNote;

public interface MusicObject {

    public ImageView[] getNotesViews();

    public ImageView[] getAccidentalViews();

    public Label[] getDescriptionLabels();

    public NamedNote[] getNamedNotes();

}
