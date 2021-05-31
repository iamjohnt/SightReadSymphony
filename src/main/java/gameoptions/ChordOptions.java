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

    /** checks if chord options combination is valid
     * <p>if isChoseChord == true, (presumably because user wants to practice chords) then at least one other option must be true\n
     * if isChoseChord == false, (presumably because user doesn't want to practice chords) then all other options must be false</p>*/
    public boolean isValid() {
        if (isChoseChord) {
            if (isAtLeastOneChosen()) {
                return true;
            } else {
                return false;
            }
        } else {
            if (isAtLeastOneChosen()) {
                return false;
            } else {
                return true;
            }
        }
    }

    private boolean isAtLeastOneChosen() {
        // if at least one true, will return true
        return isChoseRootInversion || isChoseSecondInversion || isChoseThirdInversion;
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
}
