package draw;

import javafx.scene.canvas.GraphicsContext;

public class Draw {

    private GraphicsContext graphicsContext;
    private DrawClef bassClef;
    private DrawClef trebleClef;
    private DrawNote note;

    public Draw(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void drawBassClef(double x, double y) {
        bassClef.setRoot(x, y);
        bassClef.drawBassClef(double lineSpacing);
    }

    public void drawTrebleClef(double x, double y) {
        trebleClef.setRoot(x, y);
        trebleClef.drawTrebleClef(double lineSpacing);
    }

    public void drawNote(MusicNote note, DrawClef clef) {

    }

    public void drawInterval(DrawClef clef, MusicNote note1, MusicNote note2) {

    }

    public void drawChord(DrawClef clef, MusicNote note1, MusicNote note2, MusicNote note3) {

    }

    public void drawChord(DrawClef clef, MusicNote ntoe1, MusicNote note2, MusicNote note3, MusicNote note4) {

    }

}
