package controller;

import game.Config;
import global.NoteArray;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import midi.MidiConnection;
import notecontext.NamedNote;

import javax.sound.midi.MidiDevice;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;


public class ChooseMidiDevice {

    @FXML public ListView listView;
    @FXML public Label currTransmitterLabel;
    @FXML public Button populateList;
    @FXML public Button next;
    @FXML public ComboBox keySig;
    @FXML public ComboBox maxTreble;
    @FXML public ComboBox minTreble;
    @FXML public ComboBox maxBass;
    @FXML public ComboBox minBass;
    @FXML public CheckBox includeNonChromatics;
    @FXML public CheckBox includeChromatics;

    private File[] oldListRoot;
    private String currTransmitterName;
    private MidiConnection midiConnection;

    public void initialize() {
        System.out.println("init");
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

        NamedNote[] allNamedNotes = NoteArray.getAllNamedNotesAsArray();
        maxTreble.setItems(FXCollections.observableArrayList(allNamedNotes));
        minTreble.setItems(FXCollections.observableArrayList(allNamedNotes));
        maxBass.setItems(FXCollections.observableArrayList(allNamedNotes));
        minBass.setItems(FXCollections.observableArrayList(allNamedNotes));
    }



    public void populateMidiDeviceList() {
        listView.getItems().clear();
        midiConnection = new MidiConnection();
        String[] midiDeviceNames = midiConnection.getAvailTransmitterNames();
        listView.getItems().addAll(midiDeviceNames);
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                currTransmitterName = listView.getSelectionModel().getSelectedItem().toString();
                if (currTransmitterName == null) {
                    next.setDisable(true);
                } else {
                    next.setDisable(false);
                }
                currTransmitterLabel.setText(currTransmitterName);
            }
        });
    }

    public void onClickNext() {
        Config config = createConfig();
        boolean isDeviceSelected = listView.getSelectionModel().getSelectedItem() != null;
        if (isDeviceSelected) {

            FXMLLoader loader = null;
            Parent root = null;
            try {
                URL url = new File("src/main/resources/fxml/game_area.fxml").toURI().toURL();
                loader = new FXMLLoader(url);
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            GameArea gameArea = loader.getController();
            MidiDevice chosenDevice = midiConnection.getDeviceByName(currTransmitterName);
            gameArea.setMidiDevice(chosenDevice);
            gameArea.initGameSession();
            Stage stage = (Stage) listView.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    private Config createConfig() {
        Config newConfig = new Config();

        // get and set key sig
        Integer chosenKeySig = keySig.getSelectionModel().getSelectedIndex();
        if (chosenKeySig != null) {
            newConfig.setKeySignature(chosenKeySig);
        }

        // get and set range
        NamedNote chosenMaxTreble = (NamedNote) maxTreble.getSelectionModel().getSelectedItem();
        NamedNote chosenMinTreble = (NamedNote) minTreble.getSelectionModel().getSelectedItem();
        NamedNote chosenMaxBass = (NamedNote) maxBass.getSelectionModel().getSelectedItem();
        NamedNote chosenMinBass = (NamedNote) minBass.getSelectionModel().getSelectedItem();
        if (chosenMaxTreble != null) {
            newConfig.setMaxTreble(chosenMaxTreble.getId());
        }
        if (chosenMinTreble != null) {
            newConfig.setMinTreble(chosenMinTreble.getId());
        }
        if (chosenMaxBass != null) {
            newConfig.setMaxBass(chosenMaxBass.getId());
        }
        if (chosenMinBass != null) {
            newConfig.setMinBass(chosenMinBass.getId());
        }

        // get and set chromatics
        newConfig.setIncludesChromatic(includeChromatics.isSelected());
        newConfig.setIncludesNonChromatic(includeNonChromatics.isSelected());
        return newConfig;
    }


}
