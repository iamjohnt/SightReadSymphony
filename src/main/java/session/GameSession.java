package session;

import draw.Draw;
import draw.Spawner;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.util.HashMap;

public class GameSession {

    private NoteContext noteContext;
    private Spawner spawner;
    private Draw draw;
    private GraphicsContext graphicsContext;
    private Pane pane;
    private double lineHeight;
    private HashMap<String, ImageView> activeNotes = new HashMap<>();


    public void play() {

    }

    public void drawTrebleClef(double x1, double x2) {
        double f5_y = noteContext.getTrebleLineY(NamedNote.F_5);
        double d5_y = noteContext.getTrebleLineY(NamedNote.D_5);
        double b4_y = noteContext.getTrebleLineY(NamedNote.B_4);
        double g4_y = noteContext.getTrebleLineY(NamedNote.G_4);
        double e4_y = noteContext.getTrebleLineY(NamedNote.E_4);
        graphicsContext.strokeLine(x1, f5_y, x2, f5_y);
        graphicsContext.strokeLine(x1, d5_y, x2, d5_y);
        graphicsContext.strokeLine(x1, b4_y, x2, b4_y);
        graphicsContext.strokeLine(x1, g4_y, x2, g4_y);
        graphicsContext.strokeLine(x1, e4_y, x2, e4_y);
        spawner.spawnTrebleClefSymbol(x1, noteContext.getTrebleLineY(NamedNote.G_5), 18 * 6);
    }

    public void drawBassClef(double x1, double x2) {
        double a3_y = noteContext.getBassLineY(NamedNote.A_3);
        double f3_y = noteContext.getBassLineY(NamedNote.F_3);
        double d3_y = noteContext.getBassLineY(NamedNote.D_3);
        double b2_y = noteContext.getBassLineY(NamedNote.B_2);
        double g2_y = noteContext.getBassLineY(NamedNote.G_2);
        graphicsContext.strokeLine(x1, a3_y, x2, a3_y);
        graphicsContext.strokeLine(x1, f3_y, x2, f3_y);
        graphicsContext.strokeLine(x1, d3_y, x2, d3_y);
        graphicsContext.strokeLine(x1, b2_y, x2, b2_y);
        graphicsContext.strokeLine(x1, g2_y, x2, g2_y);
        spawner.spawnBassClefSymbol(x1, noteContext.getBassLineY(NamedNote.A_3), 18 * 3.5);
    }

    public ImageView spawnTrebleNote(int noteID, double x) {
        double y = noteContext.getTrebleNoteY(noteID);
        ImageView note = spawner.createWholeNoteImageView(lineHeight);
        spawner.spawnWholeNote(note, x, y);
        note.setId(Integer.toString(noteID));
        return note;
    }

    public ImageView spawnBassNote(int noteID, double x) {
        ImageView note = spawner.createWholeNoteImageView(lineHeight);
        double y = noteContext.getBassNoteY(noteID);
        spawner.spawnWholeNote(note, x, y);
        note.setId(Integer.toString(noteID));
        return note;
    }

    public void despawnNote(ImageView view) {
        spawner.despawnNote(view);
    }

    // getters and setters

    public void setNoteContext(NoteContext noteContext) {
        this.noteContext = noteContext;
    }

    public void setSpawn(Spawner spawner) {
        this.spawner = spawner;
    }

    public void setDraw(Draw draw) {
        this.draw = draw;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public void setLineHeight(double lineHeight) {
        this.lineHeight = lineHeight;
    }
}
