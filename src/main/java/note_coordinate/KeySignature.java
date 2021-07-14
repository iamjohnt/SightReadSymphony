package note_coordinate;

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
    //                                  { A     B     C     D     E     F     G  };
    private final int[] C_MAJOR =       {NATL, NATL, NATL, NATL, NATL, NATL, NATL};     // start of natural key signatures
    private final int[] A_MINOR =       {NATL, NATL, NATL, NATL, NATL, NATL, NATL};
    private final int[] G_MAJOR =       {NATL, NATL, NATL, NATL, NATL, SHRP, NATL};     // start of SHARP and MAJOR key signatures
    private final int[] D_MAJOR =       {NATL, NATL, SHRP, NATL, NATL, SHRP, NATL};
    private final int[] A_MAJOR =       {NATL, NATL, SHRP, NATL, NATL, SHRP, SHRP};
    private final int[] E_MAJOR =       {NATL, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    private final int[] B_MAJOR =       {SHRP, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    private final int[] F_SHARP_MAJOR = {SHRP, NATL, SHRP, SHRP, SHRP, SHRP, SHRP};
    private final int[] C_SHARP_MAJOR = {SHRP, SHRP, SHRP, SHRP, SHRP, SHRP, SHRP};
    private final int[] E_MINOR =       {NATL, NATL, NATL, NATL, NATL, SHRP, NATL};     // start of SHARP and MINOR key signatures
    private final int[] B_MINOR =       {NATL, NATL, SHRP, NATL, NATL, SHRP, NATL};
    private final int[] F_SHARP_MINOR = {NATL, NATL, SHRP, NATL, NATL, SHRP, SHRP};
    private final int[] C_SHARP_MINOR = {NATL, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    private final int[] G_SHARP_MINOR = {SHRP, NATL, SHRP, SHRP, NATL, SHRP, SHRP};
    private final int[] D_SHARP_MINOR = {SHRP, NATL, SHRP, SHRP, SHRP, SHRP, SHRP};
    private final int[] F_MAJOR =       {NATL, FLAT, NATL, NATL, NATL, NATL, NATL};     // start of FLAT and MAJOR key signatures
    private final int[] B_FLAT_MAJOR =  {NATL, FLAT, NATL, NATL, FLAT, NATL, NATL};
    private final int[] E_FLAT_MAJOR =  {FLAT, FLAT, NATL, NATL, FLAT, NATL, NATL};
    private final int[] A_FLAT_MAJOR =  {FLAT, FLAT, NATL, FLAT, FLAT, NATL, NATL};
    private final int[] D_FLAT_MAJOR =  {FLAT, FLAT, NATL, FLAT, FLAT, NATL, FLAT};
    private final int[] G_FLAT_MAJOR =  {FLAT, FLAT, FLAT, FLAT, FLAT, NATL, FLAT};
    private final int[] C_FLAT_MAJOR =  {FLAT, FLAT, FLAT, FLAT, FLAT, FLAT, FLAT};
    private final int[] D_MINOR =       {NATL, FLAT, NATL, NATL, NATL, NATL, NATL};     // start of FLAT and MINOR key signatures
    private final int[] G_MINOR =       {NATL, FLAT, NATL, NATL, FLAT, NATL, NATL};
    private final int[] C_MINOR =       {FLAT, FLAT, NATL, NATL, FLAT, NATL, NATL};
    private final int[] F_MINOR =       {FLAT, FLAT, NATL, FLAT, FLAT, NATL, NATL};
    private final int[] B_FLAT_MINOR =  {FLAT, FLAT, NATL, FLAT, FLAT, NATL, FLAT};
    private final int[] E_FLAT_MINOR =  {FLAT, FLAT, FLAT, FLAT, FLAT, NATL, FLAT};

    private int[] keySig = null;

    /* todo - fill these symbol locations with noteID's, so that this class knows exactly where to display a symbol for a note.
    *   for example, if we want to display the A symbol in an A Flat minor key, then flatSymbolLocations[A] to get the noteID (clef will calc noteID's Y coord) */
    private int[] sharpSymbolLocations = {};
    private int[] flatSymbolLocations = {};

    public KeySignature(int[] keySignature) {
        this.keySig = keySignature;
    }

    public boolean isChromatic(int noteLetter, int noteAccidental) {
        return this.keySig[noteLetter] == noteAccidental;
    }

    public int getChromaticAccidentalOfNote(int noteLetter) {
        return this.keySig[noteLetter];
    }


}
