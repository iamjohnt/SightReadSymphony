package spawn;

import draw.CoordManager;
import draw.MusicNote;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import java.io.File;
import java.net.MalformedURLException;

/** manages spawning the note, which involves choosing an image asset, and determining the X and Y to spawn */
public class SpawnManager {

    public static final int WHOLE = 0;
    public static final int HALF = 1;
    public static final int QUARTER = 2;
    public static final int TAIL_NONE = 0;
    public static final int TAIL_UP = 1;
    public static final int TAIL_DOWN = -1;
    public static final String PATH_WHOLE_NOTE = "src/main/resources/images/single_note.png";
    private double noteHeight = 18;
    private double distTailFromNote = 36; // for now

    /** note height and note tail height is needed to construct */
    public SpawnManager(double noteHeight, double distTailFromNote) {
        this.noteHeight = noteHeight;
        this.distTailFromNote = distTailFromNote;
    }

    /** returns a rectangle with dimensions and coordinates, based x, y, duration, and specifed X coordinate.
     * The X and Y can specified on the fly of course, but I recommend the Y be calculated before hand, by getting the Y coordinate of a note using CoordManager */
    public Rectangle createRectangleToHoldNote(double xArg, double yArg, int durationType, int tailOrientation) {
        double x = xArg;
        double y = calcNewY(yArg, tailOrientation);
        double height = calcHeight(tailOrientation);
        double width = calcWidth(noteHeight * 1.2);
        return new Rectangle(x,y,width,height);
    }

    /** fills a rectangle with a specific note type.
     * Filling a rectangle is separated from creating it, due to JavaFX throwing exception if filling is done before internal graphics are initalized*/
    public void fillRectangleWithNote(Rectangle rect, int durationType) {
        String urlString = null;
        switch (durationType) {
            case WHOLE:
                try {
                    urlString = new File(PATH_WHOLE_NOTE).toURI().toURL().toString();
                    rect.setFill(new ImagePattern(new Image(urlString)));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
        }
    }

    private double calcNewY(double originalY, int tailOrientation) {
        switch (tailOrientation) {
            case TAIL_NONE: return originalY;
            case TAIL_DOWN: return originalY;
            case TAIL_UP: return originalY - distTailFromNote;
            default: return originalY;
        }
    }

    private double calcHeight(int tailOrientation) {
        switch (tailOrientation) {
            case TAIL_NONE: return noteHeight;
            case TAIL_DOWN: return noteHeight + distTailFromNote;
            case TAIL_UP: return noteHeight + distTailFromNote;
            default: return noteHeight;
        }
    }

    private double calcWidth(double lineHeight) {
        return lineHeight * 1.4;
    }

}
