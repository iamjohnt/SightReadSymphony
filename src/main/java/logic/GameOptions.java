package logic;

/* there are many options needed to setup a game session, and some of them affect each other
* so this class's purpose is to manage the parameters for a flashcard game session  */
public class GameOptions {

    // different notations that a user chose, that they want to practice
    private int totalChosenNotations;
    private boolean notes;
    private boolean intervals;
    private boolean chords;

    // different key signatures that the user chose, that they want to practice
    private int totalChosenKeySignatures = 0;
    private Boolean Cmajor_Aminor = null;
    private Boolean Gmajor_Eminor = null;
    private Boolean Dmajor_Bminor = null;
    private Boolean Amajor_FsharpMinor = null;
    private Boolean Emajor_CsharpMinor = null;
    private Boolean BMajor_GsharpMinnor = null;
    private Boolean GflatMajor_EflatMinor = null;
    private Boolean DflatMajor_BflatMinor = null;
    private Boolean AflatMajor_Fminor = null;
    private Boolean EflatMajor_Cminor = null;
    private Boolean BflatMajor_Gminor = null;
    private Boolean Fmajor_Dminor = null;

    // different representations of the notation that user wants to see on flash card
    // Image is image of the notation - or you can choose simply the name - or both
    private int totalShowChosen = 0;
    private Boolean showNotationImage = null;
    private Boolean showNotationName = null;

    // different clefs that the user wants to practice - can choose bass, treble, or both
    private int totalClefChosen = 0;
    private Boolean bassClef = null;
    private Boolean trebleClef = null;

    // different number of notes in a chord that user wants to practice - can choose 3, 4, or both
    private int totalChordNoteCountChosen = 0;
    private Boolean threeNoteChord = null;
    private Boolean fourNoteChord = null;

    // different number of notes in a chord that user wants to practice - can choose any combination of the three
    private int totalInversionChosen = 0;
    private Boolean rootInversion = null;
    private Boolean secondInversion = null;
    private Boolean thirdInversion = null;

    // the ranges that the user wants to practice within - they all must be set
    private Integer minBassMidiNote = null;
    private Integer maxBassMidiNote = null;
    private Integer minTrebleMidiNote = null;
    private Integer maxTrebleMidiNote = null;

    public void isGameOptionsWillBeValid(boolean potentialChoice) {
        // todo
        /*
         if chord is set, then at least one chord count option is chosen, as well as at least one chord inversion
        if chord not set, the none of those should be set
        at least one of the following needs to be seet
            any key signature
            note, or interval, or chord
            name, or image
            bass, or treble

        min and max treble and bass ALWAYS need to be set
        */
    }

    // getters ===========================================================================

    public boolean isNotes() {
        return notes;
    }

    public boolean isIntervals() {
        return intervals;
    }

    public boolean isChords() {
        return chords;
    }

    public Boolean getCmajor_Aminor() {
        return Cmajor_Aminor;
    }

    public Boolean getGmajor_Eminor() {
        return Gmajor_Eminor;
    }

    public Boolean getDmajor_Bminor() {
        return Dmajor_Bminor;
    }

    public Boolean getAmajor_FsharpMinor() {
        return Amajor_FsharpMinor;
    }

    public Boolean getEmajor_CsharpMinor() {
        return Emajor_CsharpMinor;
    }

    public Boolean getBMajor_GsharpMinnor() {
        return BMajor_GsharpMinnor;
    }

    public Boolean getGflatMajor_EflatMinor() {
        return GflatMajor_EflatMinor;
    }

    public Boolean getDflatMajor_BflatMinor() {
        return DflatMajor_BflatMinor;
    }

    public Boolean getAflatMajor_Fminor() {
        return AflatMajor_Fminor;
    }

    public Boolean getEflatMajor_Cminor() {
        return EflatMajor_Cminor;
    }

    public Boolean getBflatMajor_Gminor() {
        return BflatMajor_Gminor;
    }

    public Boolean getFmajor_Dminor() {
        return Fmajor_Dminor;
    }

    public Boolean getShowNotationImage() {
        return showNotationImage;
    }

    public Boolean getShowNotationName() {
        return showNotationName;
    }

    public Boolean getBassClef() {
        return bassClef;
    }

    public Boolean getTrebleClef() {
        return trebleClef;
    }

    public Boolean getThreeNoteChord() {
        return threeNoteChord;
    }

    public Boolean getFourNoteChord() {
        return fourNoteChord;
    }

    public Boolean getRootInversion() {
        return rootInversion;
    }

    public Boolean getSecondInversion() {
        return secondInversion;
    }

    public Boolean getThirdInversion() {
        return thirdInversion;
    }

    public Integer getMinBassMidiNote() {
        return minBassMidiNote;
    }

    public Integer getMaxBassMidiNote() {
        return maxBassMidiNote;
    }

    public Integer getMinTrebleMidiNote() {
        return minTrebleMidiNote;
    }

    public Integer getMaxTrebleMidiNote() {
        return maxTrebleMidiNote;
    }

    // setters ======================================================


    public void setNotes(boolean notes) {
        this.notes = notes;
    }

    public void setIntervals(boolean intervals) {
        this.intervals = intervals;
    }

    public void setChords(boolean chords) {
        this.chords = chords;
    }

    public void setCmajor_Aminor(Boolean cmajor_Aminor) {
        Cmajor_Aminor = cmajor_Aminor;
    }

    public void setGmajor_Eminor(Boolean gmajor_Eminor) {
        Gmajor_Eminor = gmajor_Eminor;
    }

    public void setDmajor_Bminor(Boolean dmajor_Bminor) {
        Dmajor_Bminor = dmajor_Bminor;
    }

    public void setAmajor_FsharpMinor(Boolean amajor_FsharpMinor) {
        Amajor_FsharpMinor = amajor_FsharpMinor;
    }

    public void setEmajor_CsharpMinor(Boolean emajor_CsharpMinor) {
        Emajor_CsharpMinor = emajor_CsharpMinor;
    }

    public void setBMajor_GsharpMinnor(Boolean BMajor_GsharpMinnor) {
        this.BMajor_GsharpMinnor = BMajor_GsharpMinnor;
    }

    public void setGflatMajor_EflatMinor(Boolean gflatMajor_EflatMinor) {
        GflatMajor_EflatMinor = gflatMajor_EflatMinor;
    }

    public void setDflatMajor_BflatMinor(Boolean dflatMajor_BflatMinor) {
        DflatMajor_BflatMinor = dflatMajor_BflatMinor;
    }

    public void setAflatMajor_Fminor(Boolean aflatMajor_Fminor) {
        AflatMajor_Fminor = aflatMajor_Fminor;
    }

    public void setEflatMajor_Cminor(Boolean eflatMajor_Cminor) {
        EflatMajor_Cminor = eflatMajor_Cminor;
    }

    public void setBflatMajor_Gminor(Boolean bflatMajor_Gminor) {
        BflatMajor_Gminor = bflatMajor_Gminor;
    }

    public void setFmajor_Dminor(Boolean fmajor_Dminor) {
        Fmajor_Dminor = fmajor_Dminor;
    }

    public void setShowNotationImage(Boolean showNotationImage) {
        this.showNotationImage = showNotationImage;
    }

    public void setShowNotationName(Boolean showNotationName) {
        this.showNotationName = showNotationName;
    }

    public void setBassClef(Boolean bassClef) {
        this.bassClef = bassClef;
    }

    public void setTrebleClef(Boolean trebleClef) {
        this.trebleClef = trebleClef;
    }

    public void setThreeNoteChord(Boolean threeNoteChord) {
        this.threeNoteChord = threeNoteChord;
    }

    public void setFourNoteChord(Boolean fourNoteChord) {
        this.fourNoteChord = fourNoteChord;
    }

    public void setTotalInversionChosen(int totalInversionChosen) {
        this.totalInversionChosen = totalInversionChosen;
    }

    public void setRootInversion(Boolean rootInversion) {
        this.rootInversion = rootInversion;
    }

    public void setSecondInversion(Boolean secondInversion) {
        this.secondInversion = secondInversion;
    }

    public void setThirdInversion(Boolean thirdInversion) {
        this.thirdInversion = thirdInversion;
    }

    public void setMinBassMidiNote(Integer minBassMidiNote) {
        this.minBassMidiNote = minBassMidiNote;
    }

    public void setMaxBassMidiNote(Integer maxBassMidiNote) {
        this.maxBassMidiNote = maxBassMidiNote;
    }

    public void setMinTrebleMidiNote(Integer minTrebleMidiNote) {
        this.minTrebleMidiNote = minTrebleMidiNote;
    }

    public void setMaxTrebleMidiNote(Integer maxTrebleMidiNote) {
        this.maxTrebleMidiNote = maxTrebleMidiNote;
    }
}
