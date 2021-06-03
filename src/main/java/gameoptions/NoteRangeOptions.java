package gameoptions;

import exceptions.InvalidOptionsException;

public class NoteRangeOptions implements Optionable{

    // 21 is midi value of 1st note in piano. 108 is highest.
    public static final int MAX_MIDI_PIANO_NOTE = 108;
    private final int MIN_MIDI_PIANO_NOTE = 21;

    private Integer minBass = null;
    private Integer maxBass = null;
    private Integer minTreble = null;
    private Integer maxTreble = null;

    @Override
    public boolean isValid() throws InvalidOptionsException{

        if (isSomethingNull()) {
            throw new InvalidOptionsException("Not all min's and max's have been set");

        } else if (isMinOverMax(this.minBass, this.maxBass)){
            throw new InvalidOptionsException(InvalidOptionsException.MSG_MIN_OVER_MAX);

        } else if (isMinOverMax(this.minTreble, this.maxTreble)) {
            throw new InvalidOptionsException(InvalidOptionsException.MSG_MIN_OVER_MAX);

        } else if (isNoteOutOfBounds(minBass) || isNoteOutOfBounds(maxBass) || isNoteOutOfBounds(minTreble) || isNoteOutOfBounds(maxTreble)) {
            throw new InvalidOptionsException(InvalidOptionsException.MSG_OUT_OF_BOUNDS);
        }
        return true;
    }

    private boolean isMinOverMax(Integer min, Integer max) {
        if (min == null || max == null) {
            return false;
        } else {
            return min > max;
        }
    }

    private boolean isSomethingNull() {
        return minBass == null || maxBass == null || minTreble == null || maxTreble == null;
    }

    private boolean isNoteOutOfBounds(int midiNote) {
        return midiNote < this.MIN_MIDI_PIANO_NOTE || midiNote > this.MAX_MIDI_PIANO_NOTE;
    }


    // getters ===================================================

    public Integer getMinBass() {
        return minBass;
    }

    public Integer getMaxBass() {
        return maxBass;
    }

    public Integer getMinTreble() {
        return minTreble;
    }

    public Integer getMaxTreble() {
        return maxTreble;
    }

    // setters ===================================================

    public void setMinBass(Integer minBass) throws InvalidOptionsException {
        if (isMinOverMax(minBass, this.maxBass)) {
            throw new InvalidOptionsException(InvalidOptionsException.MSG_MIN_OVER_MAX);
        } else if (isNoteOutOfBounds(minBass)) {
            throw new InvalidOptionsException(InvalidOptionsException.MSG_OUT_OF_BOUNDS);
        } else {
            this.minBass = minBass;
        }
    }

    public void setMaxBass(Integer maxBass) {
        this.maxBass = maxBass;
    }

    public void setMinTreble(Integer minTreble) {
        this.minTreble = minTreble;
    }

    public void setMaxTreble(Integer maxTreble) {
        this.maxTreble = maxTreble;
    }
}
