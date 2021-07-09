package spawn;

import draw.CoordManager;
import draw.MusicNote;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class SpawnManager {

    /* pseudo
    * so basically, i can translate an array of midi values, and create MusicNotes that wrap around it
    * I can also get the coordinate of said note.
    * so now how do I spawn them?
    *   I need a method that takes an image of specific types of note, and put it into a rectangle scaled to lineHeight
    *   this can be called later, to return the rectangle and it's
    *   or i can call another method to add it to an obseravble list
    * so what kind of notes attributes i need to consider?
    *   whole, half, single_quarter, arpeggiated_quarter
    *   tail_length (calculated from line height)
    *   no_tail, tail_up, tail_down */

    public static final int WHOLE = 0;
    public static final int HALF = 1;
    public static final int QUARTER = 2;
    public static final int TAIL_NONE = 0;
    public static final int TAIL_UP = 1;
    public static final int TAIL_DOWN = -1;
    public static final String PATH_WHOLE_NOTE = "";
//    public static final String PATH_HALF_NOTE_TAIL_UP = "";
//    public static final String PATH_HALF_NOTE_TAIL_DOWN = "";
//    public static final String PATH_QUARTER_NOTE_TAIL_UP = "";
//    public static final String PATH_QUARTER_NOTE_TAIL_DOWN = "";
    private double lineHeight = 18;
    private double distTailFromNote = 36; // for now

    public Rectangle createTrebleNote(MusicNote note, int durationType, int tailOrientation, int x) {
        CoordManager coord = new CoordManager();
        double width = calcWidth(lineHeight);
        double height = calcHeight(tailOrientation);
        double y = calcNewY(note, tailOrientation);
        Rectangle rect = new Rectangle(x,y,width,height);
        String urlString = null;
        try {
            urlString = new URL(PATH_WHOLE_NOTE).toURI().toURL().toString();
        } catch (MalformedURLException | URISyntaxException e) {
            e.printStackTrace();
        }
        rect.setFill(new ImagePattern(new Image(urlString)));
        return rect;
    }

    private double calcNewY(MusicNote note, int tailOrientation) {
        CoordManager coord = new CoordManager();
        switch (tailOrientation) {
            case TAIL_NONE: return coord.getTrebleYCoord(note);
            case TAIL_DOWN: return coord.getTrebleYCoord(note);
            case TAIL_UP: return coord.getTrebleYCoord(note) - distTailFromNote;
            default: return coord.getTrebleYCoord(note);
        }
    }

    private double calcHeight(int tailOrientation) {
        switch (tailOrientation) {
            case TAIL_NONE: return lineHeight;
            case TAIL_DOWN: return lineHeight + distTailFromNote;
            case TAIL_UP: return lineHeight + distTailFromNote;
            default: return lineHeight;
        }
    }

    private double calcWidth(double lineHeight) {
        return lineHeight * 1.4;
    }

}
