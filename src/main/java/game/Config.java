package game;

import notecontext.KeySignature;
import notecontext.NamedNote;

public class Config {

    // window
    private double sceneWidth;
    private double sceneHeight;

    // clef dimensions
    private double trebleClefX;
    private double trebleClefY;
    private double trebleClefWidth;
    private double trebleClefHeight;
    private double trebleClefLineHeight;

    private double bassClefX;
    private double bassClefY;
    private double bassClefWidth;
    private double bassClefHeight;
    private double bassClefLineHeight;

    // game options
    private int keySigID;
    private Integer maxTreble;
    private Integer minTreble;
    private Integer maxBass;
    private Integer minBass;

    // misc
    private double userNoteX;
    private double quizSpawnX;
    private double quizDespawnX;
    private double quizShiftLeftAmount;
    private int quizCountOnScreen;

    // include
    private boolean includesChromatic;
    private boolean includesNonChromatic;


    public Config() {
        // default values
        keySigID = KeySignature.C_MAJOR_ID;
        sceneWidth = 1200;
        sceneHeight = 600;

        userNoteX = 400;
        quizSpawnX = 1200;
        quizShiftLeftAmount = -150;
        quizCountOnScreen = 5;
        quizDespawnX = 400;

        trebleClefX = 100;
        trebleClefY = 150;
        trebleClefWidth = 1200;
        trebleClefHeight = 72;
        trebleClefLineHeight = 18;  // there are 4 spaces in a clef

        bassClefX = 100;
        bassClefY = 350;
        bassClefWidth = 1200;
        bassClefHeight = 72;
        bassClefLineHeight = 18;  // there are 4 spaces in a clef

        keySigID = KeySignature.C_MAJOR_ID;
        maxTreble = NamedNote.C_6;
        minTreble = NamedNote.C_3;
        maxBass = NamedNote.C_4;
        minBass = NamedNote.C_2;

        includesChromatic = true;
        includesNonChromatic = false;
    }



    // getters and setters ==========================================================================================



    public void setSceneWidth(double sceneWidth) {
        this.sceneWidth = sceneWidth;
    }

    public void setSceneHeight(double sceneHeight) {
        this.sceneHeight = sceneHeight;
    }

    public void setTrebleClefX(double trebleClefX) {
        this.trebleClefX = trebleClefX;
    }

    public void setTrebleClefY(double trebleClefY) {
        this.trebleClefY = trebleClefY;
    }

    public void setTrebleClefWidth(double trebleClefWidth) {
        this.trebleClefWidth = trebleClefWidth;
    }

    public void setTrebleClefHeight(double trebleClefHeight) {
        this.trebleClefHeight = trebleClefHeight;
    }

    public void setTrebleClefLineHeight(double trebleClefLineHeight) {
        this.trebleClefLineHeight = trebleClefLineHeight;
    }

    public void setBassClefX(double bassClefX) {
        this.bassClefX = bassClefX;
    }

    public void setBassClefY(double bassClefY) {
        this.bassClefY = bassClefY;
    }

    public void setBassClefWidth(double bassClefWidth) {
        this.bassClefWidth = bassClefWidth;
    }

    public void setBassClefHeight(double bassClefHeight) {
        this.bassClefHeight = bassClefHeight;
    }

    public void setBassClefLineHeight(double bassClefLineHeight) {
        this.bassClefLineHeight = bassClefLineHeight;
    }

    public void setKeySigID(int keySigID) {
        this.keySigID = keySigID;
    }

    public void setMaxTreble(Integer maxTreble) {
        this.maxTreble = maxTreble;
    }

    public void setMinTreble(Integer minTreble) {
        this.minTreble = minTreble;
    }

    public void setMaxBass(Integer maxBass) {
        this.maxBass = maxBass;
    }

    public void setMinBass(Integer minBass) {
        this.minBass = minBass;
    }

    public void setIncludesChromatic(boolean includesChromatic) {
        this.includesChromatic = includesChromatic;
    }

    public void setUserNoteX(double userNoteX) {
        this.userNoteX = userNoteX;
    }

    public void setQuizSpawnX(double quizSpawnX) {
        this.quizSpawnX = quizSpawnX;
    }

    public void setQuizShiftLeftAmount(double quizShiftLeftAmount) {
        this.quizShiftLeftAmount = quizShiftLeftAmount;
    }

    public double getSceneWidth() {
        return sceneWidth;
    }

    public double getSceneHeight() {
        return sceneHeight;
    }

    public double getTrebleClefX() {
        return trebleClefX;
    }

    public double getTrebleClefY() {
        return trebleClefY;
    }

    public double getTrebleClefWidth() {
        return trebleClefWidth;
    }

    public double getTrebleClefHeight() {
        return trebleClefHeight;
    }

    public double getTrebleClefLineHeight() {
        return trebleClefLineHeight;
    }

    public double getBassClefX() {
        return bassClefX;
    }

    public double getBassClefY() {
        return bassClefY;
    }

    public double getBassClefWidth() {
        return bassClefWidth;
    }

    public double getBassClefHeight() {
        return bassClefHeight;
    }

    public double getBassClefLineHeight() {
        return bassClefLineHeight;
    }

    public int getKeySigID() {
        return keySigID;
    }

    public Integer getMaxTreble() {
        return maxTreble;
    }

    public Integer getMinTreble() {
        return minTreble;
    }

    public Integer getMaxBass() {
        return maxBass;
    }

    public Integer getMinBass() {
        return minBass;
    }

    public double getUserNoteX() {
        return userNoteX;
    }

    public boolean isIncludesChromatic() {
        return includesChromatic;
    }

    public boolean isIncludesNonChromatic() {
        return includesNonChromatic;
    }

    public void setIncludesNonChromatic(boolean includesNonChromatic) {
        this.includesNonChromatic = includesNonChromatic;
    }

    public double getQuizSpawnX() {
        return quizSpawnX;
    }

    public double getQuizShiftLeftAmount() {
        return quizShiftLeftAmount;
    }

    public int getQuizCountOnScreen() {
        return quizCountOnScreen;
    }

    public void setQuizCountOnScreen(int quizCountOnScreen) {
        this.quizCountOnScreen = quizCountOnScreen;
    }

    public double getQuizDespawnX() {
        return quizDespawnX;
    }

    public void setQuizDespawnX(double quizDespawnX) {
        this.quizDespawnX = quizDespawnX;
    }
}
