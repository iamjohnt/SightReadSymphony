package draw;

import java.util.HashMap;

public class MusicNote {

    // these public final static fields, make it easier to know what to pass into this obj's constructor
    public final static int A = 0;
    public final static int B = 1;
    public final static int C = 2;
    public final static int D = 3;
    public final static int E = 4;
    public final static int F = 5;
    public final static int G = 6;
    public final static int FLAT = -1;
    public final static int NO_ACCIDENTAL = 0;
    public final static int SHARP = 1;

    // instance variables
    private int midiVal;
    private int note;
    private int octave;
    private int accidental;

    public MusicNote(int note, int octave, int accidental) {
        // todo calculate midi value based on note, octave, and accidental
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
        this.note = calcNoteLetter(midiVal, accidental);
        this.octave = calcOctave(midiVal, accidental);
        this.accidental = calcAccidental(midiVal, accidental);
    }

    private int calcOctave(int midiVal, int accidental) {
        int iterationCount = 0;
        int oct;
        int temp = midiVal;
        while (temp > 32) {
            temp -= 12;
            iterationCount++;
        }
        if (temp < 23) {
            oct = iterationCount;
        } else {
            oct = iterationCount + 1;
        }
        return oct;
    }

    private int calcNoteLetter(int midiVal) {
        int temp = midiVal;
        while (temp > 32) {
            temp -= 12;
        }
        int[] flatPattern = {A, A, B, C, C, D, D, E, F, F, G, G};
        int noteLetter = flatPattern[temp - 21];
        if (accidental == FLAT && !isWhiteKey(midiVal)) { // TODO fix this, it needs to determine the note letter based on not just FLAT, but SHARP and NONE as well
            noteLetter++;
        }
        return noteLetter;
    }

    private int calcAccidental(int midiVal, int accidental) {
        if (isWhiteKey(midiVal)) {
            return MusicNote.NO_ACCIDENTAL;
        } else {
            return accidental;
        }
    }

    private boolean isWhiteKey(int midiVal) {
        int temp = midiVal;
        while (temp > 32) {
            temp -= 12;
        }
        return temp == 21 || temp == 23 || temp == 24 || temp == 26 || temp == 28 || temp == 29 || temp == 31;
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
