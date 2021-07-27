package draw;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Spawner {

    private Pane pane;
    private double lineHeight;

    public Spawner(Pane pane, double lineHeight) {
        this.pane = pane;
        this.lineHeight = lineHeight;
    }

    public void spawnWholeNote(ImageView view, double x, double y) {
        view.setLayoutX(x);
        view.setLayoutY(y);
        view.toFront();
        pane.getChildren().add(view);
    }

    public void despawnNote(ImageView view) {
        ImageView imageview = (ImageView) view;
        pane.getChildren().remove(view);
    }

    public void spawnTrebleClefSymbol(double x, double y) {
        ImageView trebleSymbol = createTrebleSymbolImageView();
        trebleSymbol.setLayoutX(x);
        trebleSymbol.setLayoutY(y);
        trebleSymbol.toBack();
        pane.getChildren().add(trebleSymbol);
    }

    public void spawnBassClefSymbol(double x, double y) {
        ImageView trebleSymbol = createBassSymbolImageView();
        trebleSymbol.setLayoutX(x);
        trebleSymbol.setLayoutY(y);
        trebleSymbol.toBack();
        pane.getChildren().add(trebleSymbol);
    }

    public ImageView createWholeNoteImageView() {
        URL url = null;
        try {
            url = new File("src/main/resources/images/whole_note.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        ImageView note = new ImageView();
        note.setFitHeight(lineHeight);
        note.setPreserveRatio(true);
        note.setImage(image);
        return note;
    }

    private ImageView createTrebleSymbolImageView() {
        URL url = null;
        try {
            url = new File("src/main/resources/images/treble_clef.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        ImageView note = new ImageView();
        note.setFitHeight(lineHeight * 6);
        note.setPreserveRatio(true);
        note.setImage(image);
        return note;
    }

    private ImageView createBassSymbolImageView() {
        URL url = null;
        try {
            url = new File("src/main/resources/images/bass_clef.png").toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(url.toString());
        ImageView note = new ImageView();
        note.setFitHeight(lineHeight * 3.5);
        note.setPreserveRatio(true);
        note.setImage(image);
        return note;
    }
}
