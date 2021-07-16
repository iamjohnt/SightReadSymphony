package midi;

import javax.sound.midi.*;

/**
 * Handles creation of midi Tracks, which can be later assigned to a Sequence.
 * The strategy to populate Tracks can vary. For example, right now the only strategy is to create a Track of random notes, within specified bounds */

public class TrackCreator {

    /** creates a java.sound.midi.Track object, with a specified number of random notes, within specified bounds */
    public Track createRandomNotesTrack(int noteCount, int lowBound, int highBound) throws InvalidMidiDataException {
        Track rtn = createBlankTrack();
        for (int i = 0; i < noteCount; i++) {
            rtn.add(createRandMidiEvent(lowBound, highBound));
        }
        return rtn;
    }

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
