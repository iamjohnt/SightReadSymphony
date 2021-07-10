package note_coordinate;

import javafx.scene.canvas.GraphicsContext;

public class MusicSheet {

    private double x;
    private double y;
    private Clef trebleClef;
    private Clef bassClef;
    private double strokeWidth;

    public MusicSheet(double x, double y, Clef trebleClef, Clef bassClef) {
        this.x = x;
        this.y = y;
        this.trebleClef = trebleClef;
        this.bassClef = bassClef;
        strokeWidth = 6; // hardcoded for now. future will be calculated off of line height
    }

}
