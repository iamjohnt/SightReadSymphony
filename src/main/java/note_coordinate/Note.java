package note_coordinate;

public class Note {

    // static values to make easy to reference
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
    private int midiValue;
    private int noteLetter;
    private int accidental;
    private int octave;

    public Note(int id) {

    }

    public Note(int midiValue, int requestedAccidental) {

    }

    public Note(int noteLetter, int accidental, int octave) {

    }

    public int getId() {
        return id;
    }

    public int getMidiValue() {
        return midiValue;
    }

    public int getNoteLetter() {
        return noteLetter;
    }

    public int getAccidental() {
        return accidental;
    }

    public int getOctave() {
        return octave;
    }
}
