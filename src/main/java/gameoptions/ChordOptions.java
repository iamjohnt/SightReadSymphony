package gameoptions;

/** represents different game options, regarding chords.
 * <p>any combination of following options can be chosen:\n</p>
 * options include: isChoseChord (whether user wants to practice chords or not)\n
 * isChoseRootInversion\n
 * isChoseSecondInversion\n
 * isChoseThirdInversion\n</p>*/
public class ChordOptions {

    private boolean isChoseChord = false;
    private boolean isChoseRootInversion = false;
    private boolean isChoseSecondInversion = false;
    private boolean isChoseThirdInversion = false;
    private boolean isChoseThreeNoteChords = false;
    private boolean isChoseFourNoteChords = false;

    /** checks if chord options combination is valid
     * <p>if isChoseChord == true, (presumably because user wants to practice chords) then at least one other option must be true\n
     * if isChoseChord == false, (presumably because user doesn't want to practice chords) then all other options must be false</p>*/
    public boolean isValid() {
        boolean rtn = false;
        if (isChoseChord && isAtLeastOneChosen() == true) {
            rtn = true;
        } else if (isChoseChord && isAtLeastOneChosen() == false) {
            rtn = false;
        } else if (isChoseChord == false && isAtLeastOneChosen() == true) {
            rtn = false;
        } else if (isChoseChord == false && isAtLeastOneChosen() == false) {
            rtn = true;
        }
        return rtn;
    }

    private boolean isAtLeastOneChosen() {
        // if at least one true, will return true
        boolean atLeastOneInversionChosen = isChoseRootInversion || isChoseSecondInversion || isChoseThirdInversion;
        boolean atLeastOneChordNumber = isChoseThreeNoteChords || isChoseFourNoteChords;
        return atLeastOneInversionChosen || atLeastOneChordNumber;
    }

    // getters =============================================================

    public boolean isChoseChord() {
        return isChoseChord;
    }

    public boolean isChoseRootInversion() {
        return isChoseRootInversion;
    }

    public boolean isChoseSecondInversion() {
        return isChoseSecondInversion;
    }

    public boolean isChoseThirdInversion() {
        return isChoseThirdInversion;
    }

    public boolean isChoseThreeNoteChords() {
        return isChoseThreeNoteChords;
    }

    public boolean isChoseFourNoteChords() {
        return isChoseFourNoteChords;
    }

    // setters ==================================================================

    public void setChoseChord(boolean choseChord) {
        isChoseChord = choseChord;
    }

    public void setChoseRootInversion(boolean choseRootInversion) {
        isChoseRootInversion = choseRootInversion;
    }

    public void setChoseSecondInversion(boolean choseSecondInversion) {
        isChoseSecondInversion = choseSecondInversion;
    }

    public void setChoseThirdInversion(boolean choseThirdInversion) {
        isChoseThirdInversion = choseThirdInversion;
    }

    public void setChoseThreeNoteChords(boolean choseThreeNoteChords) {
        isChoseThreeNoteChords = choseThreeNoteChords;
    }

    public void setChoseFourNoteChords(boolean choseFourNoteChords) {
        isChoseFourNoteChords = choseFourNoteChords;
    }
}
