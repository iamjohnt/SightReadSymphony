package gameoptions;

/** represents miscellaneous options that a user might choose, for practice
 * <p> any combination of the following options are valid:
 * showNotationImage: during practice, the image notation of the note, interval, or chord is shown\n
 * showNotationName: during practice, the text name of the note, interval, or chord is shown\n
 * bassClef: user wants to practice bass clef\n
 * trebleClef: user wants to practice treble clef</p>*/
public class MiscOptions implements Optionable{

    private boolean showNotationImage = false;
    private boolean showNotationName = false;
    private boolean bassClef = false;
    private boolean trebleClef = false;

    /** any combination of fields are valid, so always returns true */
    @Override
    public boolean isValid() {
        return true;
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
