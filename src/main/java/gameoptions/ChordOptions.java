package gameoptions;

public class ChordOptions {

    private boolean isChoseChord = false;
    private boolean isChoseRootInversion = false;
    private boolean isChoseSecondInversion = false;
    private boolean isChoseThirdInversion = false;

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
