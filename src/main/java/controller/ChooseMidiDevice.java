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

import java.io.File;
import java.io.IOException;
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
        if (listView.getSelectionModel().getSelectedItem() == null) {
            System.out.println("null");
        } else {
            System.out.println("yeah");;
            navToFxml("src/main/resources/fxml/game_area.fxml");
        }
    }

    private void navToFxml(String relativePath) {
        Stage stage = (Stage) listView.getScene().getWindow();
        Parent game_param_screen = null;
        System.out.println(System.getProperty("user.dir"));
        try {
            URL url = new File(relativePath).toURI().toURL();
            game_param_screen = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setScene(new Scene(game_param_screen, 1000, 600));
        stage.show();
    }


}
