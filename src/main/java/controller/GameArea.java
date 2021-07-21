package controller;

import draw.Spawner;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import notecontext.Clef;
import notecontext.KeySignature;
import notecontext.NamedNote;
import notecontext.NoteContext;
import session.GameSession;


public class GameArea {

    @FXML public Pane pane;
    @FXML public Canvas canvas;
    @FXML public Button spawnIt;

    private Spawner spawner;
    private Clef treble;
    private Clef bass;
    private KeySignature keySig;
    private NoteContext context;
    private GameSession session;

    public void initialize() {
        // init noteContext
        treble = new Clef(Clef.IS_TREBLE, 150, 18);
        bass = new Clef(Clef.IS_BASS, 350, 18);
        keySig = new KeySignature(KeySignature.C_MINOR);
        context = new NoteContext(keySig, treble, bass);

        // init session
        spawner = new Spawner(pane);
        session = new GameSession();
        session.setNoteContext(context);
        session.setGraphicsContext(canvas.getGraphicsContext2D());
        session.setSpawn(spawner);
        session.setLineHeight(18);

        // draw clefs and symbols
        drawClefs();
    }


    private void drawClefs() {
        session.drawTrebleClef(200, 800);
        session.drawBassClef(200, 800);
    }


}
