package draw;

/** A music note cannot be determined just from a single midi value. For example, a midi value of 22 can either be A Sharp Zero, or B Flat Zero.
* MusicNote solves this issue, by acting as a wrapper around the midi value.
 * A MusicNote can be constructed with just a midi value, and requested accidental (accidental is not set if note is a "white key")
 * It can also be constructed using note, octave, and accidental values */
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

    private MusicNote(int note, int octave, int accidental) {
        // todo calculate midi value based on note, octave, and accidental
        this.note = note;
        this.octave = octave;
        this.accidental = accidental;
    }

    /** Creates a MusicNote from a midi value, and requested accidental
     * if the note is a "white key", like C1 and shouldn't have an accidental, then the accidental will be set as NO_ACCIDENTAL
     * if the note is a "black key", like C#1 and the requested accidental is NO_ACCIDENTAL (which is not possible), the accidental will default to SHARP */
    public MusicNote(int midiVal, int accidental) {
        this.midiVal = midiVal;
        this.note = calcNoteLetter(midiVal, accidental);
        this.octave = calcOctave(midiVal, accidental);
        this.accidental = calcAccidental(midiVal, accidental);
    }

    private int calcOctave(int midiVal, int accidental) {
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

    private int calcNoteLetter(int midiVal, int accidental) {
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
            if (accidental == MusicNote.FLAT) {
                // go up a note or wrap around
                return (noteLetter + 1) % 6;
            } else if (accidental == MusicNote.SHARP) {
                return noteLetter;
            } else if (accidental == MusicNote.NO_ACCIDENTAL){
                return noteLetter;
            }
        }
        return noteLetter;
    }

    private int calcAccidental(int midiVal, int accidental) {
        if (isWhiteKey(midiVal)) {
            // a white key should never have an accidental
            return MusicNote.NO_ACCIDENTAL;
        } else if (!isWhiteKey(midiVal) && accidental == NO_ACCIDENTAL) {
            // a black key should always have an accidental. SHARP is the default.
            return MusicNote.SHARP;
        } else {
            return accidental;
        }
    }

    private boolean isWhiteKey(int midiVal) {
        int A0 = 21;
        int B0 = 23;
        int C1 = 24;
        int D1 = 26;
        int E1 = 28;
        int F1 = 29;
        int G1 = 31;
        int G_SHARP_1 = 32;
        int OCTAVE_DIST = 12;
        int temp = midiVal;

        // subtract octaves from the midi value, until it is the lowest octave it can possibly be
        while (temp > G_SHARP_1) {
            temp -= OCTAVE_DIST;
        }

        return temp == A0 || temp == B0 || temp == C1 || temp == D1 || temp == E1 || temp == F1 || temp == G1;
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
