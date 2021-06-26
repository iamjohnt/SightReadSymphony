package midi;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.ShortMessage;

public class SequenceCreator {

    /* creates MidiEvent with random midi note between bounds.   */
    public MidiEvent createRandMidiEvent(int min, int max) throws InvalidMidiDataException {
        int midiNote = calcRandBetweenBounds(min, max);
        ShortMessage sm = new ShortMessage(ShortMessage.NOTE_ON, midiNote, midiNote);
        int dummyVal = 1;
        return new MidiEvent(sm, dummyVal);
    }

    /* returns random int between min and max (inclusive) */
    private int calcRandBetweenBounds(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
