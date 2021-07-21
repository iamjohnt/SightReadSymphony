package midi;

import javax.sound.midi.MidiMessage;

public interface MidiListener {

    public void handle(MidiMessage message);

}
