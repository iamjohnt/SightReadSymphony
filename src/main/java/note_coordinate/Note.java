package note_coordinate;

import java.util.HashMap;

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
        this.midiValue = midiValue;
        this.accidental = requestedAccidental;

        this.noteLetter = calcNoteLetterFromMidi(midiValue, requestedAccidental);
        this.octave = calcOctaveFromMidi(midiValue);
    }

    public Note(int noteLetter, int accidental, int octave) {
        this.noteLetter = noteLetter;
        this.accidental = accidental;
        this.octave = octave;
    }

    private int calcNoteLetterFromMidi(int midiVal, int requestedAccidental) {
        // subtract octaves from the midi value, until it is the lowest octave it can possibly be
        int note = midiVal;
        while (note > 32) {
            note -= 12;
        }

        // this array derived from first 12 notes of the piano: A0, A#0, B, C, C#1, D, D#1, E, F, F#1, G, G#1
        // the first midi note is 21, so we need to remove this amount, from the note - to use as index to first 12 noteLetters
        int index = note - 21;
        int[] firstTwelveNoteLetters = {A, A, B, C, C, D, D, E, F, F, G, G};
        int noteLetter = firstTwelveNoteLetters[index];

        // if white key, no need to choose note represention (example D# vs Eb). If black key, then it is needed
        if (isWhiteKey(midiVal)) {
            return noteLetter;
        } else {
            if (accidental == FLAT) {
                // go up a note or wrap around
                return (noteLetter + 1) % 6;
            } else if (accidental == SHARP) {
                return noteLetter;
            } else if (accidental == NO_ACCIDENTAL){
                return noteLetter;
            }
        }
        return noteLetter;
    }

    private int calcOctaveFromMidi(int midiVal) {
        // subtracts octave from midiVal, until it is lowest possible note. Counts iterations, which is used to determine octave of midiVal
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
            // lowest octave for A and B is ZERO, everything else is ONE
            // so we need to add one here
            oct = iterationCount + 1;
        }
        return oct;
    }

    private int calcAccidental(int midiVal) {
        if (isWhiteKey(midiVal)) {
            // a white key should never have an accidental
            return NO_ACCIDENTAL;
        } else if (!isWhiteKey(midiVal) && accidental == NO_ACCIDENTAL) {
            // a black key should always have an accidental. SHARP is the default.
            return SHARP;
        } else {
            return accidental;
        }
    }

    private boolean isWhiteKey(int midiVal) {
        // first declare known white keys
        int A0 = 21;
        int B0 = 23;
        int C1 = 24;
        int D1 = 26;
        int E1 = 28;
        int F1 = 29;
        int G1 = 31;

        // then reduce midi note to lowest it can be
        int lowestMidi = 21;
        int notesInOctave = 12;
        int temp = lowestMidi + (notesInOctave % midiValue);

        return temp == A0 || temp == B0 || temp == C1 || temp == D1 || temp == E1 || temp == F1 || temp == G1;
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

    public int extractDigitFromPosition(int number, int digitPosition) {
        return -12345;
    }

    @Override
    public boolean equals(Object otherNote) {
        Note other;
        if (otherNote instanceof Note) {
            other = (Note) otherNote;
            return
                this.noteLetter == other.getNoteLetter() &&
                this.accidental == other.getAccidental() &&
                this.octave == other.getOctave();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {

        return -12345;
    }

    @Override
    public String toString() {
        return noteLetter + " " + accidental + " " + octave;
    }

}
