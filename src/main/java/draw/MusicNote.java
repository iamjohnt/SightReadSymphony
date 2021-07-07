package draw;

import java.util.HashMap;

public class MusicNote {

    public final static int A = 0;
    public final static int B = 1;
    public final static int C = 2;
    public final static int D = 3;
    public final static int E = 4;
    public final static int F = 5;
    public final static int G = 6;
    public final static int ZERO = 0;
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int FLAT = -1;
    public final static int NO_ACCIDENTAL = 0;
    public final static int SHARP = 1;

    private int midiVal;
    private int note;
    private int octave;
    private int accidental;

    public MusicNote(int note, int octave, int accidental) {
        this.note = note;
        this.octave = octave;
        this.accidental = accidental;
    }

    public MusicNote(int midiVal, int accidental) {
        this.midiVal = midiVal;
        int iterationCount = 0;
        int temp = midiVal;
        while (temp > 32) {
            temp = temp - 12;
            iterationCount++;
        }

        // determine octave
        if (temp < 23) {
            this.octave = iterationCount;
        } else {
            this.octave = iterationCount + 1;
        }

        // determine notes that never have accidental
        boolean isWhiteKey = temp == 21 || temp == 23 || temp == 24 || temp == 26 || temp == 28 || temp == 29 || temp == 31;

        // determine note
        int[] flatPattern = {A, A, B, C, C, D, D, E, F, F, G, G};
        int tempNote = flatPattern[temp - 21];
        if (accidental == FLAT && !isWhiteKey) {
            tempNote++;
        }
        this.note = tempNote;

        // determine accidental
        if (isWhiteKey) {
            this.accidental = 0;
        } else {
            this.accidental = accidental;
        }

        // number to note string, and accidental to string
        char[] noteStr = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        String accStr = "";
        if (this.accidental == -1) {
            accStr = "FLAT";
        } else if (this.accidental == 1) {
            accStr = "SHARP";
        } else if (this.accidental == 0) {
            accStr = "";
        }
    }

    public int getMidiVal() {
        return midiVal;
    }

    public int getNote() {
        return note;
    }

    public int getOctave() {
        return octave;
    }

    public int getAccidental() {
        return accidental;
    }

    @Override
    public boolean equals(Object otherNote) {
        if (!(otherNote instanceof MusicNote)) {
            return false;
        } else {
            MusicNote note = (MusicNote) otherNote;
            boolean midiValEquals = this.midiVal == note.getMidiVal();
            boolean noteEquals = this.note == note.getNote();
            boolean octaveEquals = this.octave == note.getOctave();
            boolean accEquals = this.accidental == note.getAccidental();
            return midiValEquals && noteEquals && octaveEquals && accEquals;
        }
    }


}
