package draw;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import note_coordinate.NamedNote;

import java.io.File;
import java.net.MalformedURLException;

public class Draw {

    private GraphicsContext gc;
    private double x;
    private double y;
    private int topLineNote = NamedNote.F;
    private int topLineOctave = 5;
    private double lineSpacing;
    private double[] clefLineYCoord = new double[26];
    private double[] notePositionYCoords = new double[52];
    private int spacesBetweenOctaves = 7;

    public Draw(double x, double y, double lineSpacing) {
        this.x = x;
        this.y = y;
        this.lineSpacing = lineSpacing;
        calcLineCoords();
        calcNotePositionCoords();
    }

    public void drawClefs() {

    }

    public void spawnNote(NamedNote note, double x) {

    }

    public void spawnInterval(NamedNote note1, NamedNote note2, double x) {

    }

    public void spawnChord(NamedNote note1, NamedNote note2, NamedNote note3, double x) {

    }

    public void spawnChord(NamedNote note1, NamedNote note2, NamedNote note3, NamedNote note4, double x) {

    }

    public void calcLineCoords() {
        clefLineYCoord = new double[26];
        for (int i = 0; i < clefLineYCoord.length; i++) {
            clefLineYCoord[i] = x + (i * lineSpacing);
        }
    }

    public void calcNotePositionCoords() {
        notePositionYCoords = new double[52];
        for (int i = 0; i < notePositionYCoords.length; i++) {
            notePositionYCoords[i] = x + (i * lineSpacing);
        }
    }

    public void drawTrebleClefStartingAtF5(GraphicsContext gc, double length) {
        gc.strokeLine(x, y + lineSpacing * 0, x + length, y + lineSpacing * 0);
        gc.strokeLine(x, y + lineSpacing * 1, x + length, y + lineSpacing * 1);
        gc.strokeLine(x, y + lineSpacing * 2, x + length, y + lineSpacing * 2);
        gc.strokeLine(x, y + lineSpacing * 3, x + length, y + lineSpacing * 3);
        gc.strokeLine(x, y + lineSpacing * 4, x + length, y + lineSpacing * 4);
        drawImage("src/main/resources/images/bass_clef.png", x, y);
    }

    private void drawImage(String resPath, double x, double y) {
        String urlString = null;
        try {
            urlString = new File(resPath).toURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(urlString, lineSpacing * 3,lineSpacing * 3,true,true);
        gc.drawImage(image, x, y);
    }
}
