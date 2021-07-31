package notecontext;

public class KeySignature {

    // static "enum" variabls for easy reference
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;
    public static final int D = 3;
    public static final int E = 4;
    public static final int F = 5;
    public static final int G = 6;
    public static final int FLAT = 0;
    public static final int NATL = 1;
    public static final int SHRP = 2;

    public static final int C_MAJOR_ID = 0;
    public static final int A_MINOR_ID = 1;
    public static final int G_MAJOR_ID = 2;
    public static final int D_MAJOR_ID = 3;
    public static final int A_MAJOR_ID = 4;
    public static final int E_MAJOR_ID = 5;
    public static final int B_MAJOR_ID = 6;
    public static final int F_SHARP_MAJOR_ID = 7;
    public static final int C_SHARP_MAJOR_ID = 8;
    public static final int E_MINOR_ID = 9;
    public static final int B_MINOR_ID = 10;
    public static final int F_SHARP_MINOR_ID = 11;
    public static final int C_SHARP_MINOR_ID = 12;
    public static final int G_SHARP_MINOR_ID = 13;
    public static final int D_SHARP_MINOR_ID = 14;
    public static final int F_MAJOR_ID = 15;
    public static final int B_FLAT_MAJOR_ID = 16;
    public static final int E_FLAT_MAJOR_ID = 17;
    public static final int A_FLAT_MAJOR_ID = 18;
    public static final int D_FLAT_MAJOR_ID = 19;
    public static final int G_FLAT_MAJOR_ID = 20;
    public static final int C_FLAT_MAJOR_ID = 21;
    public static final int D_MINOR_ID = 22;
    public static final int G_MINOR_ID = 23;
    public static final int C_MINOR_ID = 24;
    public static final int F_MINOR_ID = 25;
    public static final int B_FLAT_MINOR_ID = 26;
    public static final int E_FLAT_MINOR_ID = 27;


    //                                        { A     B     C     D     E     F     G  };
    public static final int[] C_MAJOR =       {NATL, NATL, NATL, NATL, NATL, NATL, NATL};     // start of natural key signatures
    public static final int[] A_MINOR =       {NATL, NATL, NATL, NATL, NATL, NATL, NATL};
    public static final int[] G_MAJOR =       {NATL, NATL, NATL, NATL, NATL, SHRP, NATL};     // start of SHARP and MAJOR key signatures
    public static final int[] D_MAJOR =       {NATL, NATL, SHRP, NATL, NATL, SHRP, NATL};
    public static final int[] A_MAJOR =       {NATL, NATL, SHRP, NATL, NATL, SHRP, SHRP};
    public static final int[] E_MAJOR =       {NATL, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    public static final int[] B_MAJOR =       {SHRP, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    public static final int[] F_SHARP_MAJOR = {SHRP, NATL, SHRP, SHRP, SHRP, SHRP, SHRP};
    public static final int[] C_SHARP_MAJOR = {SHRP, SHRP, SHRP, SHRP, SHRP, SHRP, SHRP};
    public static final int[] E_MINOR =       {NATL, NATL, NATL, NATL, NATL, SHRP, NATL};     // start of SHARP and MINOR key signatures
    public static final int[] B_MINOR =       {NATL, NATL, SHRP, NATL, NATL, SHRP, NATL};
    public static final int[] F_SHARP_MINOR = {NATL, NATL, SHRP, NATL, NATL, SHRP, SHRP};
    public static final int[] C_SHARP_MINOR = {NATL, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    public static final int[] G_SHARP_MINOR = {SHRP, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    public static final int[] D_SHARP_MINOR = {SHRP, NATL, SHRP, SHRP, SHRP, SHRP, SHRP};
    public static final int[] F_MAJOR =       {NATL, FLAT, NATL, NATL, NATL, NATL, NATL};     // start of FLAT and MAJOR key signatures
    public static final int[] B_FLAT_MAJOR =  {NATL, FLAT, NATL, NATL, FLAT, NATL, NATL};
    public static final int[] E_FLAT_MAJOR =  {FLAT, FLAT, NATL, NATL, FLAT, NATL, NATL};
    public static final int[] A_FLAT_MAJOR =  {FLAT, FLAT, NATL, FLAT, FLAT, NATL, NATL};
    public static final int[] D_FLAT_MAJOR =  {FLAT, FLAT, NATL, FLAT, FLAT, NATL, FLAT};
    public static final int[] G_FLAT_MAJOR =  {FLAT, FLAT, FLAT, FLAT, FLAT, NATL, FLAT};
    public static final int[] C_FLAT_MAJOR =  {FLAT, FLAT, FLAT, FLAT, FLAT, FLAT, FLAT};
    public static final int[] D_MINOR =       {NATL, FLAT, NATL, NATL, NATL, NATL, NATL};     // start of FLAT and MINOR key signatures
    public static final int[] G_MINOR =       {NATL, FLAT, NATL, NATL, FLAT, NATL, NATL};
    public static final int[] C_MINOR =       {FLAT, FLAT, NATL, NATL, FLAT, NATL, NATL};
    public static final int[] F_MINOR =       {FLAT, FLAT, NATL, FLAT, FLAT, NATL, NATL};
    public static final int[] B_FLAT_MINOR =  {FLAT, FLAT, NATL, FLAT, FLAT, NATL, FLAT};
    public static final int[] E_FLAT_MINOR =  {FLAT, FLAT, FLAT, FLAT, FLAT, NATL, FLAT};

    private int keySigID;
    private int[] keySig = null;

    public int[] sharpSymbolLocations = {NamedNote.A_4, NamedNote.B_4, NamedNote.C_5, NamedNote.D_5, NamedNote.E_5, NamedNote.F_5, NamedNote.G_5};
    public int[] flatSymbolLocations = {NamedNote.A_4, NamedNote.B_4, NamedNote.C_5, NamedNote.D_5, NamedNote.E_5, NamedNote.F_4, NamedNote.G_4};

    public KeySignature(int[] keySignature) {
        this.keySig = keySignature;
    }

    public KeySignature(int keySigID) {
        this.keySigID = keySigID;
        switch (this.keySigID) {
            case C_MAJOR_ID: this.keySig = C_MAJOR; break;
            case A_MINOR_ID: this.keySig = A_MINOR; break;
            case G_MAJOR_ID: this.keySig = G_MAJOR; break;
            case D_MAJOR_ID: this.keySig = D_MAJOR; break;
            case A_MAJOR_ID: this.keySig = A_MAJOR; break;
            case E_MAJOR_ID: this.keySig = E_MAJOR; break;
            case B_MAJOR_ID: this.keySig = B_MAJOR; break;
            case F_SHARP_MAJOR_ID: this.keySig = F_SHARP_MAJOR; break;
            case C_SHARP_MAJOR_ID: this.keySig = C_SHARP_MAJOR; break;
            case E_MINOR_ID: this.keySig = E_MINOR; break;
            case B_MINOR_ID: this.keySig = B_MINOR; break;
            case F_SHARP_MINOR_ID: this.keySig = F_SHARP_MINOR; break;
            case C_SHARP_MINOR_ID: this.keySig = C_SHARP_MINOR; break;
            case G_SHARP_MINOR_ID: this.keySig = G_SHARP_MINOR; break;
            case D_SHARP_MINOR_ID: this.keySig = D_SHARP_MINOR; break;
            case F_MAJOR_ID: this.keySig = F_MAJOR; break;
            case B_FLAT_MAJOR_ID: this.keySig = B_FLAT_MAJOR; break;
            case E_FLAT_MAJOR_ID: this.keySig = E_FLAT_MAJOR; break;
            case A_FLAT_MAJOR_ID: this.keySig = A_FLAT_MAJOR; break;
            case D_FLAT_MAJOR_ID: this.keySig = D_FLAT_MAJOR; break;
            case G_FLAT_MAJOR_ID: this.keySig = G_FLAT_MAJOR; break;
            case C_FLAT_MAJOR_ID: this.keySig = C_FLAT_MAJOR; break;
            case D_MINOR_ID: this.keySig = D_MINOR; break;
            case G_MINOR_ID: this.keySig = G_MINOR; break;
            case C_MINOR_ID: this.keySig = C_MINOR; break;
            case F_MINOR_ID: this.keySig = F_MINOR; break;
            case B_FLAT_MINOR_ID: this.keySig = B_FLAT_MINOR; break;
            case E_FLAT_MINOR_ID: this.keySig = E_FLAT_MINOR; break;
        }
    }

    public boolean isChromatic(int noteID) {
        NamedNote note = new NamedNote(noteID);
        int noteLetter = note.getNoteLetter();
        int noteAccidental = note.getAccidental();
        return this.keySig[noteLetter] == noteAccidental;
    }

    public int getChromaticAccidentalOfNote(int noteLetter) {
        return this.keySig[noteLetter];
    }

    public int getSharpSymbolLocation(int noteLetter) {
        return sharpSymbolLocations[noteLetter];
    }

    public int getFlatSymbolLocation(int noteLetter) {
        return flatSymbolLocations[noteLetter];
    }

    public int getKeySignatureAccidental() {
        int accidental = NATL;
        for (int i = 0; i < keySig.length; i++) {
            if (keySig[i] == FLAT) {
                accidental = FLAT;
            } else if (keySig[i] == SHRP) {
                accidental = SHRP;
            }
        }
        return accidental;
    }

    public int getKeySigID() {
        return keySigID;
    }
}
