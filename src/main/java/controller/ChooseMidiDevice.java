package controller;

import game.Config;
import util.MusicUtil;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import midi.MidiDeviceGetter;
import notecontext.NamedNote;

import javax.sound.midi.MidiDevice;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/** Controller controls the choose midi device, and other options screen.
 * Manages the options, and when the user navigates to the game area, the config object and midi device object will be passed to it*/
public class ChooseMidiDevice {

    @FXML public ListView listView;
    @FXML public Button populateList;
    @FXML public Button next;
    @FXML public ComboBox keySig;
    @FXML public ComboBox overallMin;
    @FXML public ComboBox overallMax;
    @FXML public RadioButton includeNonChromatics;
    @FXML public RadioButton includeChromatics;
    @FXML public RadioButton includeBoth;
    @FXML public Label keySigLabel;
    @FXML public Label trebleRange;
    @FXML public Label label_chooseChromatic;
    @FXML public Button setDefault;
    @FXML public VBox options;
    @FXML public Label error;

    private String currTransmitterName;
    private MidiDeviceGetter midiDeviceGetter;

    /* initializes the UI elements */
    public void initialize() {
        // init key signature dropdown menu
        String keySigStrings[] = {
                "C MAJOR",
                "A MINOR",
                "G MAJOR",
                "D MAJOR",
                "A MAJOR",
                "E MAJOR",
                "B MAJOR",
                "F SHARP MAJOR",
                "C SHARP MAJOR",
                "E MINOR",
                "B MINOR",
                "F SHARP MINOR",
                "C SHARP MINOR",
                "G SHARP MINOR",
                "D SHARP MINOR",
                "F MAJOR",
                "B FLAT MAJOR",
                "E FLAT MAJOR",
                "A FLAT MAJOR",
                "D FLAT MAJOR",
                "G FLAT MAJOR",
                "C FLAT MAJOR",
                "D MINOR",
                "G MINOR",
                "C MINOR",
                "F MINOR",
                "B FLAT MINOR",
                "E FLAT MINOR"
        };
        keySig.setItems(FXCollections.observableArrayList(keySigStrings));

        // init note range drop down menus
        NamedNote[] allNamedNotes = MusicUtil.getAllNamedNotesAsArray();
        overallMin.setItems(FXCollections.observableArrayList(allNamedNotes));
        overallMax.setItems(FXCollections.observableArrayList(allNamedNotes));
    }

    /*  when triggered, this method refreshes the listView of detected midi devices */
    public void populateMidiDeviceList() {
        listView.getItems().clear();
        midiDeviceGetter = new MidiDeviceGetter();
        String[] midiDeviceNames = midiDeviceGetter.getAvailTransmitterNames();
        listView.getItems().addAll(midiDeviceNames);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                currTransmitterName = listView.getSelectionModel().getSelectedItem().toString();
                if (currTransmitterName == null) {
                    next.setDisable(true);
                } else {
                    revealOptions();
                    next.setDisable(false);
                }
            }
        });
    }

    /* When triggered, reveal the rest of the options. Why? These options are hidden initially, as to not overwhelm the user. */
    public void revealOptions() {
        options.setVisible(true);
    }

    /* When triggered, set everything to a predetermined default value. Why? Maybe user doesn't want to bother with custom game settings */
    public void setDefaults() {
        keySig.getSelectionModel().select(0);
        overallMin.getSelectionModel().select(new NamedNote(NamedNote.C_2));
        overallMax.getSelectionModel().select(new NamedNote(NamedNote.C_6));
        includeChromatics.setSelected(true);
        includeChromatics.setDisable(true);
        includeNonChromatics.setSelected(false);
        includeNonChromatics.setDisable(false);
        includeBoth.setSelected(false);
        includeBoth.setDisable(false);
    }

    /* when triggered by the radio buttons regarding chromatics, updates radio buttons' disabled state, and sets config based on what was selected */
    public void radio(ActionEvent event) {
        RadioButton radioButton = (RadioButton) event.getSource();
        if (radioButton.getId().equalsIgnoreCase("includeChromatics")) {
            includeNonChromatics.setSelected(false);
            includeNonChromatics.setDisable(false);
            includeBoth.setSelected(false);
            includeBoth.setDisable(false);
            radioButton.setDisable(true);
        } else if (radioButton.getId().equalsIgnoreCase("includeNonChromatics")) {
            includeChromatics.setSelected(false);
            includeChromatics.setDisable(false);
            includeBoth.setSelected(false);
            includeBoth.setDisable(false);
            radioButton.setDisable(true);
        } else if (radioButton.getId().equalsIgnoreCase("includeBoth")) {
            includeNonChromatics.setSelected(false);
            includeNonChromatics.setDisable(false);
            includeChromatics.setSelected(false);
            includeChromatics.setDisable(false);
            radioButton.setDisable(true);
        }
    }

    /* when triggered, confirms options, passes it to game area, then navigates to game area */
    public void onClickNext() {
        if (isEverythingSelected() == false) {
            error.setText("Please make sure all fields have been selected  ");
            error.setVisible(true);
        } else if (isRangeValid() == false) {
            error.setText("Range is invalid, max is below min  ");
            error.setVisible(true);
        } else {
            Config config = createConfig();
            System.out.println(config.toString());
            System.out.println("is everything selected: " + isEverythingSelected());
            System.out.println("is range valid " + isRangeValid());
            boolean isDeviceSelected = listView.getSelectionModel().getSelectedItem() != null;
            if (isDeviceSelected) {

                // laods the new FXML
                FXMLLoader loader = null;
                Parent root = null;
                try {
                    URL url = new File("src/main/resources/fxml/game_area.fxml").toURI().toURL();
                    loader = new FXMLLoader(url);
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // setup game area and nav to it
                GameArea gameArea = loader.getController();
                MidiDevice chosenDevice = midiDeviceGetter.getDeviceByName(currTransmitterName);
                gameArea.setMidiDevice(chosenDevice);
                gameArea.setConfig(config);
                gameArea.initGameSession();
                Stage stage = (Stage) listView.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }
        }

    }

    /* pulls all information from the UI, and adds it to a Config object */
    private Config createConfig() {
        Config newConfig = new Config();

        // adds selected key signature
        Integer chosenKeySig = keySig.getSelectionModel().getSelectedIndex();
        if (chosenKeySig != null) {
            newConfig.setKeySigID(chosenKeySig);
        }

        // adds selected range of notes
        NamedNote chosenMin = (NamedNote) overallMin.getSelectionModel().getSelectedItem();
        NamedNote chosenMax = (NamedNote) overallMax.getSelectionModel().getSelectedItem();
        if (chosenMin != null) {
            newConfig.setOverallMin(chosenMin.getId());
        }
        if (chosenMax != null) {
            newConfig.setOverallMax(chosenMax.getId());
        }

        // adds selection chromatic option
        if (includeChromatics.isSelected()) {
            newConfig.setIncludesChromatic(true);
            newConfig.setIncludesNonChromatic(false);
        } else if (includeNonChromatics.isSelected()) {
            newConfig.setIncludesChromatic(false);
            newConfig.setIncludesNonChromatic(true);
        } else if (includeBoth.isSelected()) {
            newConfig.setIncludesChromatic(true);
            newConfig.setIncludesNonChromatic(true);
        }

        // return
        return newConfig;
    }

    private boolean isEverythingSelected() {
        boolean deviceSelected = listView.getSelectionModel().getSelectedItem() != null;
        boolean keySigSelected = keySig.getSelectionModel().getSelectedItem() != null;
        boolean minSelected = overallMin.getSelectionModel().getSelectedItem() != null;
        boolean maxSelected = overallMax.getSelectionModel().getSelectedItem() != null;
        boolean chromaticSelected = includeChromatics.isSelected() || includeNonChromatics.isSelected() || includeBoth.isSelected();
        return deviceSelected && keySigSelected && minSelected && maxSelected && chromaticSelected;
    }

    private boolean isRangeValid() {
        NamedNote min = (NamedNote) overallMin.getSelectionModel().getSelectedItem();
        NamedNote max = (NamedNote) overallMax.getSelectionModel().getSelectedItem();
        if (min == null || max == null) {
            return false;
        } else {
            return min.compare(max) < 0;
        }
    }

}
