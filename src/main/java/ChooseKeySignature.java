import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public class ChooseKeySignature {

    boolean[] chosenKeySignatures = new boolean[12];
    private static final double SHOW = 0.2;
    private static final double HIDE = 0.0;
    @FXML ImageView navBack;
    @FXML ImageView navNext;

    @FXML
    public void navBack() {
        Stage stage = (Stage) navBack.getScene().getWindow();
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
        Stage stage = (Stage) navBack.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File("src/main/resources/fxml/choose_options.fxml").toURI().toURL();
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
            // highlight is currently green, which means it is selected - so we need to unselect it
            // we need to turn it back to gray, and restore the onMouseOver and onMouseExit
            recordSelectDeselect(source.get().getId(), false);
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
            // we need to turn it green, and prevent mousing over or away that would affect this highlight further
            recordSelectDeselect(source.get().getId(), true);
            source.get().setOnMouseExited((event1 -> {}));
            source.get().setOnMouseEntered((event1 -> {}));
            source.get().setEffect(null);
        }
    }

    private void recordSelectDeselect(String imageId, boolean isSelected) {
        switch (imageId) {
            case "one_highlight" : chosenKeySignatures[0] = isSelected; break;
            case "two_highlight" : chosenKeySignatures[1] = isSelected; break;
            case "three_highlight" : chosenKeySignatures[2] = isSelected; break;
            case "four_highlight" : chosenKeySignatures[3] = isSelected; break;
            case "five_highlight" : chosenKeySignatures[4] = isSelected; break;
            case "six_highlight" : chosenKeySignatures[5] = isSelected; break;
            case "seven_highlight" : chosenKeySignatures[6] = isSelected; break;
            case "eight_highlight" : chosenKeySignatures[7] = isSelected; break;
            case "nine_highlight" : chosenKeySignatures[8] = isSelected; break;
            case "ten_highlight" : chosenKeySignatures[9] = isSelected; break;
            case "eleven_highlight" : chosenKeySignatures[10] = isSelected; break;
            case "twelve_highlight" : chosenKeySignatures[11] = isSelected; break;
        }
    }
}
