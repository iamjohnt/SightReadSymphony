package midi;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TrackParser {

    public int[] convertTrackToMidiIntegerArray(Track track) {
        int rtn[] = new int[countShortMessages(track)];
        for (int i = 0; i < track.size(); i++){
            ShortMessage sm = null;
            if (track.get(i).getMessage() instanceof ShortMessage) {
                sm = (ShortMessage) track.get(i).getMessage();
                rtn[i] = (sm.getData1());
            }
        }
        return rtn;
    }

    private int countShortMessages(Track track) {
        int rtn = 0;
        for (int i = 0; i < track.size(); i++) {
            if (track.get(i).getMessage() instanceof ShortMessage) {
                rtn++;
            }
        }
        return rtn;
    }

}
