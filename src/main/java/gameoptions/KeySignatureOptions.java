package gameoptions;

/** represents different key signatures, that player can choose to practice
 * <p>At least one must be chosen, even if not playing chords\n
 * during game session, notes and intervals will be generated according to key signature</p>*/
public class KeySignatureOptions {

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

    /** checks if at least one key signature is chosen
     * <p>true if so, false if not</p>*/
    public boolean isValid() {
        return  Cmajor_Aminor ||
                Gmajor_Eminor || 
                Dmajor_Bminor || 
                Amajor_FsharpMinor || 
                BMajor_GsharpMinnor || 
                GflatMajor_EflatMinor || 
                DflatMajor_BflatMinor || 
                AflatMajor_Fminor || 
                EflatMajor_Cminor ||
                BflatMajor_Gminor ||
                Fmajor_Dminor;
    }

    // getters

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


    // setters

    public void setCmajor_Aminor(boolean cmajor_Aminor) {
        Cmajor_Aminor = cmajor_Aminor;
    }

    public void setGmajor_Eminor(boolean gmajor_Eminor) {
        Gmajor_Eminor = gmajor_Eminor;
    }

    public void setDmajor_Bminor(boolean dmajor_Bminor) {
        Dmajor_Bminor = dmajor_Bminor;
    }

    public void setAmajor_FsharpMinor(boolean amajor_FsharpMinor) {
        Amajor_FsharpMinor = amajor_FsharpMinor;
    }

    public void setEmajor_CsharpMinor(boolean emajor_CsharpMinor) {
        Emajor_CsharpMinor = emajor_CsharpMinor;
    }

    public void setBMajor_GsharpMinnor(boolean BMajor_GsharpMinnor) {
        this.BMajor_GsharpMinnor = BMajor_GsharpMinnor;
    }

    public void setGflatMajor_EflatMinor(boolean gflatMajor_EflatMinor) {
        GflatMajor_EflatMinor = gflatMajor_EflatMinor;
    }

    public void setDflatMajor_BflatMinor(boolean dflatMajor_BflatMinor) {
        DflatMajor_BflatMinor = dflatMajor_BflatMinor;
    }

    public void setAflatMajor_Fminor(boolean aflatMajor_Fminor) {
        AflatMajor_Fminor = aflatMajor_Fminor;
    }

    public void setEflatMajor_Cminor(boolean eflatMajor_Cminor) {
        EflatMajor_Cminor = eflatMajor_Cminor;
    }

    public void setBflatMajor_Gminor(boolean bflatMajor_Gminor) {
        BflatMajor_Gminor = bflatMajor_Gminor;
    }

    public void setFmajor_Dminor(boolean fmajor_Dminor) {
        Fmajor_Dminor = fmajor_Dminor;
    }
}
