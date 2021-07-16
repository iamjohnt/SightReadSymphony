package midi;

import javax.sound.midi.*;

/** Handles parsing of a javax.sound.midi.Track object into a simple int array
 * The purpose is to allow other classes to easily read the note data from a simply int array, rather than from a Track or Sequence
 * The track to parse should have all ShortMessages, since these contains actual midi note data, as opposed to MetaMessages which do not
 * The notes will be parsed into an int array, to be easily used by other classes */
public class TrackParser {

    /** Counts how many ShortMessages are in the track, and extracts the note data to an int array, and returns it */
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
