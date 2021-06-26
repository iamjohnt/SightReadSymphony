package midi;

import javax.sound.midi.*;

/***
 * Manages the sequence, that will hold the notes that the user will practice.
 * Holds 2 tracks, the treble and bass.
 * You can populate the 2 tracks with random notes, currently*/

public class SequenceCreator {

    private Sequence seq = null;
    private Track treble = null;
    private Track bass = null;
    private int trebleSize = 0;
    private int bassSize = 0;

    public SequenceCreator() throws InvalidMidiDataException {
        seq = new Sequence(Sequence.PPQ, 1);
        seq.createTrack();
        seq.createTrack();
        treble = seq.getTracks()[0];
        bass = seq.getTracks()[1];
    }

    public void resetSequence() {
        seq = null;
    }

    public void populateTrebleRandMidiEvents(int amount, int lowBound, int highBound) throws InvalidMidiDataException {
        for (int i = 0; i < amount; i++) {
            ShortMessage sm = (ShortMessage) createRandMidiEvent(lowBound, highBound).getMessage();
            addToTreble(sm.getData1());
        }
    }

    public void populateBassRandMidiEvents(int amount, int lowBound, int highBound) throws InvalidMidiDataException {
        for (int i = 0; i < amount; i++) {
            ShortMessage sm = (ShortMessage) createRandMidiEvent(lowBound, highBound).getMessage();
            addToBass(sm.getData1());        }
    }

    public void populateTrebleWithDifferentStrategies() {
        /* todo sometimes i want to populate only major notes, or only c_major notes, etc
        *   i need a way to retain an array of legal notes I can use. To choose this randomly, i use the index*/
    }

    public void addToTreble(int note) throws InvalidMidiDataException {
        treble.add(createMidiEvent(note));
        trebleSize++;
    }

    public void addToBass(int note) throws InvalidMidiDataException {
        bass.add(createMidiEvent(note));
        bassSize++;
    }

    public int getNoteFromTreble(int index) {
        ShortMessage sm = (ShortMessage) treble.get(index).getMessage();
        return sm.getData1();
    }

    public int getNoteFromBass(int index) {
        ShortMessage sm = (ShortMessage) bass.get(index).getMessage();
        return sm.getData1();
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


    // getters + setters ===============================================================================================



    public int getTrebleSize() {
        return trebleSize;
    }

    public void setTrebleSize(int trebleSize) {
        this.trebleSize = trebleSize;
    }

    public int getBassSize() {
        return bassSize;
    }

    public void setBassSize(int bassSize) {
        this.bassSize = bassSize;
    }
}
