package draw;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.Config;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.io.File;
import java.net.MalformedURLException;

public class Draw {

    private GraphicsContext graphicsContext;
    private NoteContext noteContext;
    private Config config;
    private double lineHeight;

    public Draw(GraphicsContext gc, Config config) {
        this.graphicsContext = gc;
        this.noteContext = new NoteContext(config);
        this.config = config;
        this.lineHeight = config.getTrebleClefLineHeight();
    }

    public void drawClefs() {
        double trebleX1 = config.getTrebleClefX();
        double trebleX2 = config.getTrebleClefX() + config.getTrebleClefWidth();
        drawTrebleClef(trebleX1, trebleX2);

        double bassX1 = config.getBassClefX();
        double bassX2 = config.getBassClefX() + config.getTrebleClefWidth();
        drawBassClef(bassX1, bassX2);
    }

    private void drawTrebleClef(double x1, double x2) {
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
        Image trebleSymbol = createImage("src/main/resources/images/treble_clef.png", lineHeight * 6);
        graphicsContext.drawImage(trebleSymbol, config.getTrebleClefX(), f5_y - 10);
    }

    private void drawBassClef(double x1, double x2) {
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
        Image bassSymbol = createImage("src/main/resources/images/bass_clef.png", lineHeight * 3.5);
        graphicsContext.drawImage(bassSymbol, config.getBassClefX(), a3_y);
    }

    private Image createImage(String resPath, double h) {
        String urlString = null;
        try {
            urlString = new File(resPath).toURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new Image(urlString, h, h,true,true);
    }
}




