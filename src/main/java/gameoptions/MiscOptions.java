package gameoptions;

import exceptions.InvalidOptionsException;

/** represents miscellaneous options that a user might choose, for practice
 * <p> at least one notation must be chosen, and at least one clef must be chosen
 * otherwise, throws InvalidOptionsException 
 * showNotationImage: during practice, the image notation of the note, interval, or chord is shown\n
 * showNotationName: during practice, the text name of the note, interval, or chord is shown\n
 * bassClef: user wants to practice bass clef\n
 * trebleClef: user wants to practice treble clef</p>*/
public class MiscOptions implements Optionable{

    private boolean showNotationImage = false;
    private boolean showNotationName = false;
    private boolean bassClef = false;
    private boolean trebleClef = false;

    /** at least one notation must be chosen, and at least one clef must be chosen
     * otherwise, throws InvalidOptionsException */
    @Override
    public boolean isValid() throws InvalidOptionsException {
        if (isNoNotationsChosen()) {
            throw new InvalidOptionsException("No notation types are chosen, at least one must be");
        }
        if (isNoClefsChosen()) {
            throw new InvalidOptionsException("No clefs are chosen, at least one must be");
        }
        return true;
    }

    private boolean isNoNotationsChosen() {
        return showNotationImage || showNotationName;
    }

    private boolean isNoClefsChosen() {
        return bassClef || trebleClef;
    }

    // getters ================================================================

    public boolean isShowNotationImage() {
        return showNotationImage;
    }

    public boolean isShowNotationName() {
        return showNotationName;
    }

    public boolean isBassClef() {
        return bassClef;
    }

    public boolean isTrebleClef() {
        return trebleClef;
    }

    // setters =================================================================


    public void setShowNotationImage(boolean showNotationImage) {
        this.showNotationImage = showNotationImage;
    }

    public void setShowNotationName(boolean showNotationName) {
        this.showNotationName = showNotationName;
    }

    public void setBassClef(boolean bassClef) {
        this.bassClef = bassClef;
    }

    public void setTrebleClef(boolean trebleClef) {
        this.trebleClef = trebleClef;
    }
}
