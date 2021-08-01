package controller;

import game.Config;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class ChooseConfig {

    @FXML private ComboBox keySig;
    @FXML private ComboBox maxTreble;
    @FXML private ComboBox minTreble;
    @FXML private ComboBox maxBass;
    @FXML private ComboBox minBass;
    @FXML private CheckBox includeFlats;
    @FXML private CheckBox includeNaturals;
    @FXML private CheckBox includeSharps;
    @FXML private CheckBox includeChromatics;

    private Config config;

    public void initialize() {
        String keySigStrings[] = {
            "C_MAJOR_ID",
            "A_MINOR_ID",
            "G_MAJOR_ID",
            "D_MAJOR_ID",
            "A_MAJOR_ID",
            "E_MAJOR_ID",
            "B_MAJOR_ID",
            "F_SHARP_MAJOR_ID",
            "C_SHARP_MAJOR_ID",
            "E_MINOR_ID",
            "B_MINOR_ID",
            "F_SHARP_MINOR_ID",
            "C_SHARP_MINOR_ID",
            "G_SHARP_MINOR_ID",
            "D_SHARP_MINOR_ID",
            "F_MAJOR_ID",
            "B_FLAT_MAJOR_ID",
            "E_FLAT_MAJOR_ID",
            "A_FLAT_MAJOR_ID",
            "D_FLAT_MAJOR_ID",
            "G_FLAT_MAJOR_ID",
            "C_FLAT_MAJOR_ID",
            "D_MINOR_ID",
            "G_MINOR_ID",
            "C_MINOR_ID",
            "F_MINOR_ID",
            "B_FLAT_MINOR_ID",
            "E_FLAT_MINOR_ID"
        };
        keySig = new ComboBox(FXCollections.observableArrayList(keySigStrings));

        String[] noteList = {
            "A0 (lowest key)",
            "C1",
            "C2",
            "C3",
            "C4 (middle C)",
            "C5",
            "C6",
            "C7",
            "C8 (highest key)",
        };

        maxTreble = new ComboBox(FXCollections.observableArrayList(noteList));
        minTreble = new ComboBox(FXCollections.observableArrayList(noteList));
        maxBass = new ComboBox(FXCollections.observableArrayList(noteList));
        minBass = new ComboBox(FXCollections.observableArrayList(noteList));
    }

}
