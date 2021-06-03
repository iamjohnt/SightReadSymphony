package gameoptions;

import exceptions.InvalidOptionsException;

/** OptionManager holds and manages several sub-option sets, that each determine their own validity differently
 * to determine whether the game options chosen as a whole are valid, OptionManager calls isValid() on each Optionable option-set */
public class OptionsManager implements Optionable {

    private Optionable chordOptions;
    private Optionable keySigOptions;
    private Optionable noteRangeOptions;
    private Optionable miscOptions;

    /** calls isValid() on all Optionable options objects, that represent what the the user has chosen
     * returns true if valid, throws exception otherwise
     * conditions for throwing exception are defined within each Optionable object, not OptionManager itself */
    public boolean isValid() throws InvalidOptionsException {
        boolean isValid = chordOptions.isValid() && keySigOptions.isValid() && noteRangeOptions.isValid() && miscOptions.isValid();
        return isValid;
    }

    // getters ======================================================

    public Optionable getChordOptions() {
        return chordOptions;
    }

    public Optionable getKeySigOptions() {
        return keySigOptions;
    }

    public Optionable getNoteRangeOptions() {
        return noteRangeOptions;
    }

    public Optionable getMiscOptions() {
        return miscOptions;
    }


    // setters =========================================

    public void setChordOptions(ChordOptions chordOptions) throws InvalidOptionsException {
        if (chordOptions.isValid()) {
            this.chordOptions = chordOptions;
        }
        // otherwise, exception will be thrown, and this method pass exception up
    }

    public void setKeySigOptions(KeySignatureOptions keySigOptions) throws InvalidOptionsException {
        if (keySigOptions.isValid()) {
            this.keySigOptions = keySigOptions;
        }
        // otherwise, exception will be thrown, and this method pass exception up

    }

    public void setNoteRangeOptions(NoteRangeOptions noteRangeOptions) throws InvalidOptionsException {
        if (noteRangeOptions.isValid()) {
            this.noteRangeOptions = noteRangeOptions;
        }
        // otherwise, exception will be thrown, and this method pass exception up

    }

    public void setMiscOptions(MiscOptions miscOptions) throws InvalidOptionsException {
        if (miscOptions.isValid()) {
            this.miscOptions = miscOptions;
        }
        // otherwise, exception will be thrown, and this method pass exception up
    }
}
