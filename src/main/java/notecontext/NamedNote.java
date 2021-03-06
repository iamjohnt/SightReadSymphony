package notecontext;

/** Overview - represents a note
 * Purpose - You can extract the note letter, accidental, or the octave from the note
 * You can also compare different notes, to see if they equal, or if one is greater or lesser
 * You can determine if a note is a white or black key */
public class NamedNote {

    // static id's that make it easy to construct a named note.
    // made of 3 digits. the leftmost is the octave. the middle is the note. the rightmoost is the accidental.
    public static final int A_0 = 1;
    public static final int A_SHARP_0 = 2;
    public static final int B_FLAT_0 = 10;
    public static final int B_0 = 11;

    public static final int C_1 = 121;
    public static final int C_SHARP_1 = 122;
    public static final int D_FLAT_1 = 130;
    public static final int D_1 = 131;
    public static final int D_SHARP_1 = 132;
    public static final int E_FLAT_1 = 140;
    public static final int E_1 = 141;
    public static final int F_1 = 151;
    public static final int F_SHARP_1 = 152;
    public static final int G_FLAT_1 = 160;
    public static final int G_1 = 161;
    public static final int G_SHARP_1 = 162;
    public static final int A_FLAT_1 = 100;
    public static final int A_1 = 101;
    public static final int A_SHARP_1 = 102;
    public static final int B_FLAT_1 = 110;
    public static final int B_1 = 111;

    public static final int C_2 = 221;
    public static final int C_SHARP_2 = 222;
    public static final int D_FLAT_2 = 230;
    public static final int D_2 = 231;
    public static final int D_SHARP_2 = 232;
    public static final int E_FLAT_2 = 240;
    public static final int E_2 = 241;
    public static final int F_2 = 251;
    public static final int F_SHARP_2 = 252;
    public static final int G_FLAT_2 = 260;
    public static final int G_2 = 261;
    public static final int G_SHARP_2 = 262;
    public static final int A_FLAT_2 = 200;
    public static final int A_2 = 201;
    public static final int A_SHARP_2 = 202;
    public static final int B_FLAT_2 = 210;
    public static final int B_2 = 211;

    public static final int C_3 = 321;
    public static final int C_SHARP_3 = 322;
    public static final int D_FLAT_3 = 330;
    public static final int D_3 = 331;
    public static final int D_SHARP_3 = 332;
    public static final int E_FLAT_3 = 340;
    public static final int E_3 = 341;
    public static final int F_3 = 351;
    public static final int F_SHARP_3 = 352;
    public static final int G_FLAT_3 = 360;
    public static final int G_3 = 361;
    public static final int G_SHARP_3 = 362;
    public static final int A_FLAT_3 = 300;
    public static final int A_3 = 301;
    public static final int A_SHARP_3 = 302;
    public static final int B_FLAT_3 = 310;
    public static final int B_3 = 311;

    public static final int C_4 = 421;
    public static final int C_SHARP_4 = 422;
    public static final int D_FLAT_4 = 430;
    public static final int D_4 = 431;
    public static final int D_SHARP_4 = 432;
    public static final int E_FLAT_4 = 440;
    public static final int E_4 = 441;
    public static final int F_4 = 451;
    public static final int F_SHARP_4 = 452;
    public static final int G_FLAT_4 = 460;
    public static final int G_4 = 461;
    public static final int G_SHARP_4 = 462;
    public static final int A_FLAT_4 = 400;
    public static final int A_4 = 401;
    public static final int A_SHARP_4 = 402;
    public static final int B_FLAT_4 = 410;
    public static final int B_4 = 411;

    public static final int C_5 = 521;
    public static final int C_SHARP_5 = 522;
    public static final int D_FLAT_5 = 530;
    public static final int D_5 = 531;
    public static final int D_SHARP_5 = 532;
    public static final int E_FLAT_5 = 540;
    public static final int E_5 = 541;
    public static final int F_5 = 551;
    public static final int F_SHARP_5 = 552;
    public static final int G_FLAT_5 = 560;
    public static final int G_5 = 561;
    public static final int G_SHARP_5 = 562;
    public static final int A_FLAT_5 = 500;
    public static final int A_5 = 501;
    public static final int A_SHARP_5 = 502;
    public static final int B_FLAT_5 = 510;
    public static final int B_5 = 511;

    public static final int C_6 = 621;
    public static final int C_SHARP_6 = 622;
    public static final int D_FLAT_6 = 630;
    public static final int D_6 = 631;
    public static final int D_SHARP_6 = 632;
    public static final int E_FLAT_6 = 640;
    public static final int E_6 = 641;
    public static final int F_6 = 651;
    public static final int F_SHARP_6 = 652;
    public static final int G_FLAT_6 = 660;
    public static final int G_6 = 661;
    public static final int G_SHARP_6 = 662;
    public static final int A_FLAT_6 = 600;
    public static final int A_6 = 601;
    public static final int A_SHARP_6 = 602;
    public static final int B_FLAT_6 = 610;
    public static final int B_6 = 611;

    public static final int C_7 = 721;
    public static final int C_SHARP_7 = 722;
    public static final int D_FLAT_7 = 730;
    public static final int D_7 = 731;
    public static final int D_SHARP_7 = 732;
    public static final int E_FLAT_7 = 740;
    public static final int E_7 = 741;
    public static final int F_7 = 751;
    public static final int F_SHARP_7 = 752;
    public static final int G_FLAT_7 = 760;
    public static final int G_7 = 761;
    public static final int G_SHARP_7 = 762;
    public static final int A_FLAT_7 = 700;
    public static final int A_7 = 701;
    public static final int A_SHARP_7 = 702;
    public static final int B_FLAT_7 = 710;
    public static final int B_7 = 711;

    public static final int C_8 = 821;

    // other static variables
    public final static int A = 0;
    public final static int B = 1;
    public final static int C = 2;
    public final static int D = 3;
    public final static int E = 4;
    public final static int F = 5;
    public final static int G = 6;
    public final static int FLAT = 0;
    public final static int NO_ACCIDENTAL = 1;
    public final static int SHARP = 2;
    public final static int ZERO = 0;
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;

    private int id;
    private int noteLetter;
    private int accidental;
    private int octave;
    private boolean isWhiteKey;
    private boolean isBlackKey;

    /** constructs NamedNote using id */
    public NamedNote(int id) {
        this.id = id;
        this.accidental = id % 10;          // isolate right digit
        this.noteLetter = (id / 10) % 10;   // isolate middle digit
        this.octave = (id / 100) % 100;     // isolate first digt
    }

    /** constructs NamedNote using the note letter, accidental, and octave */
    public NamedNote(int noteLetter, int accidental, int octave) {
        this.noteLetter = noteLetter;
        this.accidental = accidental;
        this.octave = octave;
        this.id = (octave * 100) + (noteLetter * 10) + accidental;
    }

    /** gets the note letter id from a noteID*/
    public static int extractNoteLetter(int noteID) {
        return (noteID / 10) % 10;
    }

    /** gets the octave id from a noteID */
    public static int extractOctave(int noteID) {
        return (noteID / 10) / 10;
    }

    /** gets the accidental id from a noteID*/
    public static int extractAccidental(int noteID) {
        return noteID % 10;
    }

    /** builds a note id */
    public static int buildNoteID(int noteLetter, int accidental, int octave) {
        return (octave * 100) + (noteLetter * 10) + accidental;
    }

    @Override
    public String toString() {
        String[] letterStrings = {"A", "B", "C", "D", "E", "F", "G"};
        String[] accidentalStrings = {"b", " ", "#"};
        String rtn = letterStrings[this.noteLetter] + accidentalStrings[this.accidental] + Integer.toString(this.octave);
        return rtn;
    }

    /** gets the hashcode, which is the id */
    @Override public int hashCode() {
        return id;
    }

    /** gets the id */
    public int getId() {
        return id;
    }

    /** get's the noteLetter id*/
    public int getNoteLetter() {
        return noteLetter;
    }

    /** gets the accidental id*/
    public int getAccidental() {
        return accidental;
    }

    /** gets the octave id */
    public int getOctave() {
        return octave;
    }

    /** returns if this named note is a white key */
    public boolean isWhiteKey() {
        return accidental == 1;
    }

    /** returns if this named note is a black key */
    public boolean isBlackKey() {
        return accidental == 0 || accidental == 2;
    }

    /** compares if a 2 named notes - returns 0 if equal, -1 if calling NamedNote is less, and 1 if calling NamedNote is greater */
    public int compare(NamedNote other) {
        // originally, i designed noteID ints to be compared to eachother - they are ints, and can simply be compared like that
        // however, i made the mistake of setting it like so: A = 0, B = 1, C = 2, etc etc
        // in reality though, since octaves reset on C, C should be at 0 and not A.
        // because of that, you cannot compare noteID's, because it will give you the wrong result.
        // for example, 421 C4, is numerically creater than 411 B4, right? but C4 is actually lower than B4
        // so the method below basically corrects the noteLetter of the noteID - starting A at 0
        // i don't want to change the noteID now, because that would break so much code, i don't even know
        int thisNote = (this.octave * 100) + (((this.noteLetter + 5) % 7) * 10) + this.accidental;
        int otherNote = (other.octave * 100) + (((other.noteLetter + 5) % 7) * 10) + other.accidental;
        if (thisNote > otherNote) {
            return 1;
        } else if (thisNote < otherNote) {
            return -1;
        } else {
            return 0;
        }
    }
}
