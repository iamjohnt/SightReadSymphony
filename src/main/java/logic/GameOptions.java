package logic;

/* there are so many parameters need to setup a game session, and some of them affect each other
* so this class's sole purpose is to manage the parameters for a flashcard game session */
public class GameOptions {

    private boolean includesNotes;
    private boolean includesIntervals;
    private boolean includesChords;
    private boolean includesName;
    private boolean includesImage;
    private boolean includesBassClef;
    private boolean includesTrebleClef;
    private boolean includesChords3Note;
    private boolean includesChords4Notes;
    private boolean includesChordInversionRoot;
    private boolean includesChordInversionOne;
    private boolean includesChordInversionTwo;
    private boolean[] chosenKeySignatures = new boolean[12];
    private int minBassMidiNote;
    private int maxBassMidiNote;
    private int minTrebleMidiNote;
    private int maxTrebleMidiNote;

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

    // wall of setters and getters below ---------

    public GameOptions setNotes(boolean notes) {
        includesNotes = notes;
        return this;
    }

    public GameOptions setIntervals(boolean intervals) {
        includesIntervals = intervals;
        return this;
    }

    public GameOptions setChords(boolean chords) {
        includesChords = chords;
        return this;
    }

    public GameOptions setName(boolean name) {
        includesName = name;
        return this;
    }

    public GameOptions setImage(boolean image) {
        includesImage = image;
        return this;
    }

    public GameOptions setBassClef(boolean bassClef) {
        includesBassClef = bassClef;
        return this;
    }

    public GameOptions setTrebleClef(boolean trebleClef) {
        includesTrebleClef = trebleClef;
        return this;
    }

    public GameOptions setChords3Note(boolean chords3Note) {
        includesChords3Note = chords3Note;
        return this;
    }

    public GameOptions setChords4Notes(boolean chords4Notes) {
        includesChords4Notes = chords4Notes;
        return this;
    }

    public GameOptions setChordInversionRoot(boolean chordInversionRoot) {
        includesChordInversionRoot = chordInversionRoot;
        return this;
    }

    public GameOptions setChordInversionOne(boolean chordInversionOne) {
        includesChordInversionOne = chordInversionOne;
        return this;
    }

    public GameOptions setChordInversionTwo(boolean chordInversionTwo) {
        includesChordInversionTwo = chordInversionTwo;
        return this;
    }

    public GameOptions setChosenKeySignatures(int i, boolean bool) {
        this.chosenKeySignatures[i] = bool;
        return this;
    }

    public GameOptions setMinBassMidiNote(int minBassMidiNote) {
        this.minBassMidiNote = minBassMidiNote;
        return this;
    }

    public GameOptions setMaxBassMidiNote(int maxBassMidiNote) {
        this.maxBassMidiNote = maxBassMidiNote;
        return this;
    }

    public GameOptions setMinTrebleMidiNote(int minTrebleMidiNote) {
        this.minTrebleMidiNote = minTrebleMidiNote;
        return this;
    }

    public GameOptions setMaxTrebleMidiNote(int maxTrebleMidiNote) {
        this.maxTrebleMidiNote = maxTrebleMidiNote;
        return this;
    }

    public boolean isIncludesNotes() {
        return includesNotes;
    }

    public boolean isIncludesIntervals() {
        return includesIntervals;
    }

    public boolean isIncludesChords() {
        return includesChords;
    }

    public boolean isIncludesName() {
        return includesName;
    }

    public boolean isIncludesImage() {
        return includesImage;
    }

    public boolean isIncludesBassClef() {
        return includesBassClef;
    }

    public boolean isIncludesTrebleClef() {
        return includesTrebleClef;
    }

    public boolean isIncludesChords3Note() {
        return includesChords3Note;
    }

    public boolean isIncludesChords4Notes() {
        return includesChords4Notes;
    }

    public boolean isIncludesChordInversionRoot() {
        return includesChordInversionRoot;
    }

    public boolean isIncludesChordInversionOne() {
        return includesChordInversionOne;
    }

    public boolean isIncludesChordInversionTwo() {
        return includesChordInversionTwo;
    }

    public boolean getChosenKeySignatures(int i) {
        return chosenKeySignatures[i];
    }

    public int getMinBassMidiNote() {
        return minBassMidiNote;
    }

    public int getMaxBassMidiNote() {
        return maxBassMidiNote;
    }

    public int getMinTrebleMidiNote() {
        return minTrebleMidiNote;
    }

    public int getMaxTrebleMidiNote() {
        return maxTrebleMidiNote;
    }
}
