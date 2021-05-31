package gameoptions;

public class ChordOptions {

    private boolean isChordChosen;
    private boolean isRootInversionChosen;
    private boolean isSecondInversionChosen;
    private boolean isThirdInversionChosen;

    public boolean isValid() {
        // todo stub
        return false;
    }

    // getters =============================================================

    public boolean isChordChosen() {
        return isChordChosen;
    }

    public boolean isRootInversionChosen() {
        return isRootInversionChosen;
    }

    public boolean isSecondInversionChosen() {
        return isSecondInversionChosen;
    }

    public boolean isThirdInversionChosen() {
        return isThirdInversionChosen;
    }

    // setters ==================================================================

    public void setChordChosen(boolean chordChosen) {
        isChordChosen = chordChosen;
    }

    public void setRootInversionChosen(boolean rootInversionChosen) {
        isRootInversionChosen = rootInversionChosen;
    }

    public void setSecondInversionChosen(boolean secondInversionChosen) {
        isSecondInversionChosen = secondInversionChosen;
    }

    public void setThirdInversionChosen(boolean thirdInversionChosen) {
        isThirdInversionChosen = thirdInversionChosen;
    }
}
