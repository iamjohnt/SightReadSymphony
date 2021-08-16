package midi;

import javax.sound.midi.MidiMessage;

/** interface that declares method, that would handle the midi message, when recieved */
public interface MidiListener {

    public void handle(MidiMessage message);

}
