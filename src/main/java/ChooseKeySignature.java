import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public class ChooseKeySignature {

    private static final double SHOW = 0.2;
    private static final double HIDE = 0.0;
    @FXML ImageView left_arrow;

    @FXML
    public void navBack() {
        Stage stage = (Stage) left_arrow.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/choose_notation.fxml").toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        stage.show();
    }

    @FXML
    public void navChooseOptions() {
        Stage stage = (Stage) left_arrow.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/choose_notation.fxml").toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        stage.show();
    }


    @FXML
    public void onMouseEnter_highlightGray(Event event) {
        ImageView source = (ImageView) event.getSource();
        source.setEffect(new ColorAdjust(0,0,-5,5));
        source.setOpacity(SHOW);
    }

    @FXML
    public void onMouseExit_removeHighlight(Event event) {
        ImageView source = (ImageView) event.getSource();
        source.setEffect(new ColorAdjust(0,0,-5,5));
        source.setOpacity(HIDE);
    }

    @FXML public void onClick_selectOrDeselect(Event event) {
        AtomicReference<ImageView> source = new AtomicReference<>((ImageView) event.getSource());
        boolean isKeySignatureSelected = source.get().getEffect() == null;
        if (isKeySignatureSelected) {
            // highlight is currently green, which means it is selected
            // we need to turn it back to gray, and restore the onMouseOver and onMouseExit
            source.get().setEffect(new ColorAdjust(0,0,-5,5));
            source.get().setOnMouseEntered((event1 -> {
                source.set((ImageView) event1.getSource());
                source.get().setEffect(new ColorAdjust(0,0,-5,5));
                source.get().setOpacity(SHOW);
            }));
            source.get().setOnMouseExited((event1 -> {
                source.set((ImageView) event1.getSource());
                source.get().setEffect(null);
                source.get().setOpacity(HIDE);
            }));
        } else {
            // otherwise, it is currently gray, which means it is NOT selected
            // we need to turn it gray, and prevent mousing over or away that would affect this highlight further
            source.get().setOnMouseExited((event1 -> {}));
            source.get().setOnMouseEntered((event1 -> {}));
            source.get().setEffect(null);
        }
    }

}
