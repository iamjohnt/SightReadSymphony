package midi;

import javax.sound.midi.*;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TrackParser {

    public int[] convertTrackToMidiIntegerArray(Track track) {
        int[] rtn = new int[track.size()];
        int i = 0;
        while (track.get(i) != null) {
            MidiEvent event = track.get(i);
            if (event.getMessage() instanceof ShortMessage) {
                ShortMessage msg = (ShortMessage) event.getMessage();
                rtn[i] = msg.getData1();
            }
        }
        return rtn;
    }

}
