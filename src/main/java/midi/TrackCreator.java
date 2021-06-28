package midi;

import javax.sound.midi.*;

/***
 * Manages the sequence, that will hold the notes that the user will practice.
 * Holds 2 tracks, the treble and bass.
 * You can populate the 2 tracks with random notes, currently*/

public class TrackCreator {

    private Track createBlankTrack() {
        Sequence seq = null;
        try {
            seq = new Sequence(Sequence.PPQ, 1);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        Track track = seq.createTrack();
        seq = null;
        return track;
    }

    public Track createRandomNotesTrack(int noteCount, int lowBound, int highBound) throws InvalidMidiDataException {
        Track rtn = createBlankTrack();
        for (int i = 0; i < noteCount; i++) {
            rtn.add(createRandMidiEvent(lowBound, highBound));
        }
        return rtn;
    }

    /* creates MidiEvent with random midi note between bounds.   */
    private MidiEvent createRandMidiEvent(int min, int max) throws InvalidMidiDataException {
        int midiNote = calcRandBetweenBounds(min, max);
        ShortMessage sm = new ShortMessage(ShortMessage.NOTE_ON, midiNote, midiNote);
        int dummyVal = 1;
        return new MidiEvent(sm, dummyVal);
    }

    private MidiEvent createMidiEvent(int midiNote) throws InvalidMidiDataException {
        ShortMessage sm = new ShortMessage(ShortMessage.NOTE_ON, midiNote, midiNote);
        int dummyVal = 1;
        return new MidiEvent(sm, dummyVal);
    }

    /* returns random int between min and max (inclusive) */
    private int calcRandBetweenBounds(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
