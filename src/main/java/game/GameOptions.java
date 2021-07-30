package game;

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
    private boolean Cmajor_Aminor = false;
    private boolean Gmajor_Eminor = false;
    private boolean Dmajor_Bminor = false;
    private boolean Amajor_FsharpMinor = false;
    private boolean Emajor_CsharpMinor = false;
    private boolean BMajor_GsharpMinnor = false;
    private boolean GflatMajor_EflatMinor = false;
    private boolean DflatMajor_BflatMinor = false;
    private boolean AflatMajor_Fminor = false;
    private boolean EflatMajor_Cminor = false;
    private boolean BflatMajor_Gminor = false;
    private boolean Fmajor_Dminor = false;

    // different representations of the notation that user wants to see on flash card
    // Image is image of the notation - or you can choose simply the name - or both
    private int totalShowChosen = 0;
    private boolean showNotationImage = false;
    private boolean showNotationName = false;

    // different clefs that the user wants to practice - can choose bass, treble, or both
    private int totalClefChosen = 0;
    private boolean bassClef = false;
    private boolean trebleClef = false;

    // different number of notes in a chord that user wants to practice - can choose 3, 4, or both
    private int totalChordNoteCountChosen = 0;
    private boolean threeNoteChord = false;
    private boolean fourNoteChord = false;

    // different number of notes in a chord that user wants to practice - can choose any combination of the three
    private int totalInversionChosen = 0;
    private boolean rootInversion = false;
    private boolean secondInversion = false;
    private boolean thirdInversion = false;

    // the ranges that the user wants to practice within - they all must be set
    private Integer minBassMidiNote = null;
    private Integer maxBassMidiNote = null;
    private Integer minTrebleMidiNote = null;
    private Integer maxTrebleMidiNote = null;


    public boolean isValid() {
        // if anything is false, will return false
        return (isChordOptionsValid() &&
                isNonChordOptionsAtLeastOne() &&
                isClefOptionsValid() &&
                isRangesValid());
    }

    private boolean isChordOptionsValid() {
        if (chords == true) {
            /* if chords is selected, at least one chord count, and one inversion must be chosen */
            return totalChordNoteCountChosen > 0 && totalInversionChosen > 0;
        } else {
            /* if chords is not selected, at there must be no chord count or inversion selected*/
            return totalChordNoteCountChosen == 0 && totalInversionChosen == 0;
        }
    }

    private boolean isRangesValid() {
        return minBassMidiNote >= 21 && maxBassMidiNote <= 108 && minTrebleMidiNote >= 21 && maxTrebleMidiNote <= 108;
    }

    private boolean isNonChordOptionsAtLeastOne() {
        return totalShowChosen > 0 && totalClefChosen > 0;
    }

    private boolean isClefOptionsValid() {
        return totalClefChosen > 0;
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

    public boolean getCmajor_Aminor() {
        return Cmajor_Aminor;
    }

    public boolean getGmajor_Eminor() {
        return Gmajor_Eminor;
    }

    public boolean getDmajor_Bminor() {
        return Dmajor_Bminor;
    }

    public boolean getAmajor_FsharpMinor() {
        return Amajor_FsharpMinor;
    }

    public boolean getEmajor_CsharpMinor() {
        return Emajor_CsharpMinor;
    }

    public boolean getBMajor_GsharpMinnor() {
        return BMajor_GsharpMinnor;
    }

    public boolean getGflatMajor_EflatMinor() {
        return GflatMajor_EflatMinor;
    }

    public boolean getDflatMajor_BflatMinor() {
        return DflatMajor_BflatMinor;
    }

    public boolean getAflatMajor_Fminor() {
        return AflatMajor_Fminor;
    }

    public boolean getEflatMajor_Cminor() {
        return EflatMajor_Cminor;
    }

    public boolean getBflatMajor_Gminor() {
        return BflatMajor_Gminor;
    }

    public boolean getFmajor_Dminor() {
        return Fmajor_Dminor;
    }

    public boolean getShowNotationImage() {
        return showNotationImage;
    }

    public boolean getShowNotationName() {
        return showNotationName;
    }

    public boolean getBassClef() {
        return bassClef;
    }

    public boolean getTrebleClef() {
        return trebleClef;
    }

    public boolean getThreeNoteChord() {
        return threeNoteChord;
    }

    public boolean getFourNoteChord() {
        return fourNoteChord;
    }

    public boolean getRootInversion() {
        return rootInversion;
    }

    public boolean getSecondInversion() {
        return secondInversion;
    }

    public boolean getThirdInversion() {
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
        if (notes == true) totalChosenNotations++; else totalChosenNotations--;
        this.notes = notes;
    }

    public void setIntervals(boolean intervals) {
        if (intervals == true) totalChosenNotations++; else totalChosenNotations--;
        this.intervals = intervals;
    }

    public void setChords(boolean chords) {
        if (chords == true) totalChosenNotations++; else totalChosenNotations--;
        this.chords = chords;
    }

    public void setCmajor_Aminor(boolean cmajor_Aminor) {
        if (cmajor_Aminor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        Cmajor_Aminor = cmajor_Aminor;
    }

    public void setGmajor_Eminor(boolean gmajor_Eminor) {
        if (gmajor_Eminor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        Gmajor_Eminor = gmajor_Eminor;
    }

    public void setDmajor_Bminor(boolean dmajor_Bminor) {
        if (dmajor_Bminor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        Dmajor_Bminor = dmajor_Bminor;
    }

    public void setAmajor_FsharpMinor(boolean amajor_FsharpMinor) {
        if (amajor_FsharpMinor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        Amajor_FsharpMinor = amajor_FsharpMinor;
    }

    public void setEmajor_CsharpMinor(boolean emajor_CsharpMinor) {
        if (emajor_CsharpMinor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        Emajor_CsharpMinor = emajor_CsharpMinor;
    }

    public void setBMajor_GsharpMinnor(boolean BMajor_GsharpMinnor) {
        if (BMajor_GsharpMinnor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        this.BMajor_GsharpMinnor = BMajor_GsharpMinnor;
    }

    public void setGflatMajor_EflatMinor(boolean gflatMajor_EflatMinor) {
        if (gflatMajor_EflatMinor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        GflatMajor_EflatMinor = gflatMajor_EflatMinor;
    }

    public void setDflatMajor_BflatMinor(boolean dflatMajor_BflatMinor) {
        if (dflatMajor_BflatMinor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        DflatMajor_BflatMinor = dflatMajor_BflatMinor;
    }

    public void setAflatMajor_Fminor(boolean aflatMajor_Fminor) {
        if (aflatMajor_Fminor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        AflatMajor_Fminor = aflatMajor_Fminor;
    }

    public void setEflatMajor_Cminor(boolean eflatMajor_Cminor) {
        if (eflatMajor_Cminor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        EflatMajor_Cminor = eflatMajor_Cminor;
    }

    public void setBflatMajor_Gminor(boolean bflatMajor_Gminor) {
        if (bflatMajor_Gminor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        BflatMajor_Gminor = bflatMajor_Gminor;
    }

    public void setFmajor_Dminor(boolean fmajor_Dminor) {
        if (fmajor_Dminor == true) totalChosenKeySignatures++; else totalChosenKeySignatures--;
        Fmajor_Dminor = fmajor_Dminor;
    }

    public void setShowNotationImage(boolean showNotationImage) {
        if (showNotationImage == true) totalShowChosen++; else totalShowChosen--;
        this.showNotationImage = showNotationImage;
    }

    public void setShowNotationName(boolean showNotationName) {
        if (showNotationName == true) totalShowChosen++; else totalShowChosen--;
        this.showNotationName = showNotationName;
    }

    public void setBassClef(boolean bassClef) {
        if (bassClef == true) totalClefChosen++; else totalClefChosen--;
        this.bassClef = bassClef;
    }

    public void setTrebleClef(boolean trebleClef) {
        if (trebleClef == true) totalClefChosen++; else totalClefChosen--;
        this.trebleClef = trebleClef;
    }

    public void setThreeNoteChord(boolean threeNoteChord) {
        if (threeNoteChord == true) totalChordNoteCountChosen++; else totalChordNoteCountChosen--;
        this.threeNoteChord = threeNoteChord;
    }

    public void setFourNoteChord(boolean fourNoteChord) {
        if (fourNoteChord == true) totalChordNoteCountChosen++; else totalChordNoteCountChosen--;
        this.fourNoteChord = fourNoteChord;
    }

    public void setRootInversion(boolean rootInversion) {
        if (rootInversion == true) totalInversionChosen++; else totalInversionChosen--;
        this.rootInversion = rootInversion;
    }

    public void setSecondInversion(boolean secondInversion) {
        if (secondInversion == true) totalInversionChosen++; else totalInversionChosen--;
        this.secondInversion = secondInversion;
    }

    public void setThirdInversion(boolean thirdInversion) {
        if (thirdInversion == true) totalInversionChosen++; else totalInversionChosen--;
        this.thirdInversion = thirdInversion;
    }

    public void setMinBassMidiNote(Integer minBassMidiNote) throws Exception {
        if (minBassMidiNote < 21 || minBassMidiNote > 108) {
            throw new Exception("Midi range must be between 21 and 108. Current midi range: " + minBassMidiNote);
        }
        this.minBassMidiNote = minBassMidiNote;
    }

    public void setMaxBassMidiNote(Integer maxBassMidiNote) throws Exception {
        if (minBassMidiNote < 21 || minBassMidiNote > 108) {
            throw new Exception("Midi range must be between 21 and 108. Current midi range: " + minBassMidiNote);
        }
        this.maxBassMidiNote = maxBassMidiNote;
    }

    public void setMinTrebleMidiNote(Integer minTrebleMidiNote) throws Exception {
        if (minBassMidiNote < 21 || minBassMidiNote > 108) {
            throw new Exception("Midi range must be between 21 and 108. Current midi range: " + minBassMidiNote);
        }
        this.minTrebleMidiNote = minTrebleMidiNote;
    }

    public void setMaxTrebleMidiNote(Integer maxTrebleMidiNote) throws Exception {
        if (minBassMidiNote < 21 || minBassMidiNote > 108) {
            throw new Exception("Midi range must be between 21 and 108. Current midi range: " + minBassMidiNote);
        }
        this.maxTrebleMidiNote = maxTrebleMidiNote;
    }
}
