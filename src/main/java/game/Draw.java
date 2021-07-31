package game;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import game.Config;
import notecontext.KeySignature;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.io.File;
import java.net.MalformedURLException;

public class Draw {

    private GraphicsContext graphicsContext;
    private NoteContext noteContext;
    private Config config;
    private double lineHeight;
    private static final String G_MAJOR_E_MINOR_IMAGE_PATH = "src/main/resources/images/g_major_e_minor.png";
    private static final String D_MAJOR_B_MINOR_IMAGE_PATH = "src/main/resources/images/d_major_b_minor.png";
    private static final String A_MAJOR_F_SHARP_MINOR = "src/main/resources/images/a_major_f_sharp_minor.png";
    private static final String E_MAJOR_C_SHARP_MINOR = "src/main/resources/images/e_major_c_sharp_minor.png";
    private static final String B_MAJOR_G_SHARP_MINOR = "src/main/resources/images/b_major_g_sharp_minor.png";
    private static final String F_SHARP_MAJOR_D_SHARP_MINOR = "src/main/resources/images/f_sharp_major_d_sharp_minor.png";
    private static final String F_MAJOR_D_MINOR = "src/main/resources/images/f_major_d_minor.png";
    private static final String B_FLAT_MAJOR_G_MINOR = "src/main/resources/images/b_flat_major_g_minor.png";
    private static final String E_FLAT_MAJOR_C_MINOR = "src/main/resources/images/e_flat_major_c_minor.png";
    private static final String A_FLAT_MAJOR_F_MINOR = "src/main/resources/images/a_flat_major_f_minor.png";
    private static final String D_FLAT_MAJOR_B_FLAT_MINOR = "src/main/resources/images/d_flat_major_b_flat_minor.png";
    private static final String G_FLAT_MAJOR_E_FLAT_MINOR = "src/main/resources/images/g_flat_major_e_flat_minor.png";
    private static final String C_SHARP_MAJOR = "src/main/resources/images/c_sharp_major.png";
    private static final String C_FLAT_MINOR = "src/main/resources/images/c_flat_minor.png";
    private static final String C_FLAT_MAJOR = "src/main/resources/images/c_flat_major.png";

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

        String keySigImagePath = determineKeySigPath();
        if (noteContext.getKeySigAccidental() == KeySignature.SHRP) {
            drawSharpKeySigs(keySigImagePath);
        } else if (noteContext.getKeySigAccidental() == KeySignature.FLAT){
            drawFlatKeySigs(keySigImagePath);
        }
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

    private void drawSharpKeySigs(String imagePath) {
        Image keySigSymbols = createImage(imagePath, lineHeight * 6.25);
        double trebleX = config.getTrebleClefX() + (lineHeight * 4);
        double trebleY = config.getTrebleClefY() - (lineHeight * 1.75);
        double bassX = config.getBassClefX() + (lineHeight * 4);
        double bassY = config.getBassClefY() - (lineHeight);
        graphicsContext.drawImage(keySigSymbols, trebleX , trebleY);
        graphicsContext.drawImage(keySigSymbols, bassX , bassY);
    }


    private void drawFlatKeySigs(String imagePath) {
        Image keySigSymbols = createImage(imagePath, lineHeight * 6.5);
        double trebleX = config.getTrebleClefX() + (lineHeight * 4);
        double trebleY = config.getTrebleClefY() - (lineHeight * 1.20);
        graphicsContext.drawImage(keySigSymbols, trebleX , trebleY);

        double bassX = config.getBassClefX() + (lineHeight * 4);
        double bassY = config.getBassClefY() - (lineHeight * 0.2);
        graphicsContext.drawImage(keySigSymbols, bassX , bassY);
    }

    private String determineKeySigPath() {
        String rtn = null;
        int keySigID = noteContext.getKeySigID();
        switch (keySigID) {
            case KeySignature.C_MAJOR_ID: rtn = null; break;
            case KeySignature.A_MINOR_ID: rtn = null; break;
            case KeySignature.G_MAJOR_ID: rtn = G_MAJOR_E_MINOR_IMAGE_PATH; break;
            case KeySignature.D_MAJOR_ID: rtn = D_MAJOR_B_MINOR_IMAGE_PATH; break;
            case KeySignature.A_MAJOR_ID: rtn = A_MAJOR_F_SHARP_MINOR; break;
            case KeySignature.E_MAJOR_ID: rtn = E_MAJOR_C_SHARP_MINOR; break;
            case KeySignature.B_MAJOR_ID: rtn = B_MAJOR_G_SHARP_MINOR; break;
            case KeySignature.F_SHARP_MAJOR_ID: rtn = F_SHARP_MAJOR_D_SHARP_MINOR; break;
            case KeySignature.C_SHARP_MAJOR_ID: rtn = C_SHARP_MAJOR; break;
            case KeySignature.E_MINOR_ID: rtn = G_MAJOR_E_MINOR_IMAGE_PATH; break;
            case KeySignature.B_MINOR_ID: rtn = D_MAJOR_B_MINOR_IMAGE_PATH; break;
            case KeySignature.F_SHARP_MINOR_ID: rtn = A_MAJOR_F_SHARP_MINOR; break;
            case KeySignature.C_SHARP_MINOR_ID: rtn = E_MAJOR_C_SHARP_MINOR; break;
            case KeySignature.G_SHARP_MINOR_ID: rtn = B_MAJOR_G_SHARP_MINOR; break;
            case KeySignature.D_SHARP_MINOR_ID: rtn = F_SHARP_MAJOR_D_SHARP_MINOR; break;
            case KeySignature.F_MAJOR_ID: rtn = F_MAJOR_D_MINOR; break;
            case KeySignature.B_FLAT_MAJOR_ID: rtn = B_FLAT_MAJOR_G_MINOR; break;
            case KeySignature.E_FLAT_MAJOR_ID: rtn = E_FLAT_MAJOR_C_MINOR; break;
            case KeySignature.A_FLAT_MAJOR_ID: rtn = A_FLAT_MAJOR_F_MINOR; break;
            case KeySignature.D_FLAT_MAJOR_ID: rtn = D_FLAT_MAJOR_B_FLAT_MINOR; break;
            case KeySignature.G_FLAT_MAJOR_ID: rtn = G_FLAT_MAJOR_E_FLAT_MINOR; break;
            case KeySignature.C_FLAT_MAJOR_ID: rtn = C_FLAT_MAJOR; break;
            case KeySignature.D_MINOR_ID: rtn = F_MAJOR_D_MINOR; break;
            case KeySignature.G_MINOR_ID: rtn = B_FLAT_MAJOR_G_MINOR; break;
            case KeySignature.C_MINOR_ID: rtn = E_FLAT_MAJOR_C_MINOR; break;
            case KeySignature.F_MINOR_ID: rtn = A_FLAT_MAJOR_F_MINOR; break;
            case KeySignature.B_FLAT_MINOR_ID: rtn = D_FLAT_MAJOR_B_FLAT_MINOR; break;
            case KeySignature.E_FLAT_MINOR_ID: rtn = G_FLAT_MAJOR_E_FLAT_MINOR; break;
            default: rtn = "switch case default";
        }
        return rtn;
    }

}




