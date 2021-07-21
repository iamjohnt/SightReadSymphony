package draw;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import notecontext.Clef;
import notecontext.KeySignature;
import notecontext.NamedNote;
import notecontext.NoteContext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Spawner {

    private Pane pane;

    public Spawner(Pane pane) {
        this.pane = pane;
    }

    public void spawnWholeNote(ImageView view, double x, double y) {
        view.setLayoutX(x);
        view.setLayoutY(y);
        view.toFront();
        view.setId("asdf");
        pane.getChildren().add(view);
    }

    public void despawnNote(ImageView view) {
        ImageView imageview = (ImageView) view;
        pane.getChildren().remove(view);
    }

    public void spawnTrebleClefSymbol(double x, double y, double height) {
        ImageView trebleSymbol = createTrebleSymbolImageView(height);
        trebleSymbol.setLayoutX(x);
        trebleSymbol.setLayoutY(y);
        trebleSymbol.toBack();
        pane.getChildren().add(trebleSymbol);
    }

    public void spawnBassClefSymbol(double x, double y, double height) {
        ImageView trebleSymbol = createBassSymbolImageView(height);
        trebleSymbol.setLayoutX(x);
        trebleSymbol.setLayoutY(y);
        trebleSymbol.toBack();
        pane.getChildren().add(trebleSymbol);
    }

    public ImageView createWholeNoteImageView(double height) {
        URL url = null;
        try {
            url = new File("src/main/resources/images/whole_note.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        ImageView note = new ImageView();
        note.setFitHeight(height);
        note.setPreserveRatio(true);
        note.setImage(image);
        return note;
    }

    private ImageView createTrebleSymbolImageView(double height) {
        URL url = null;
        try {
            url = new File("src/main/resources/images/treble_clef.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        ImageView note = new ImageView();
        note.setFitHeight(height);
        note.setPreserveRatio(true);
        note.setImage(image);
        return note;
    }

    private ImageView createBassSymbolImageView(double height) {
        URL url = null;
        try {
            url = new File("src/main/resources/images/bass_clef.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        ImageView note = new ImageView();
        note.setFitHeight(height);
        note.setPreserveRatio(true);
        note.setImage(image);
        return note;
    }
}
