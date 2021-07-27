package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import midi.MidiConnection;

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

    private File[] oldListRoot;
    private String currTransmitterName;
    private MidiConnection midiConnection;

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


}
