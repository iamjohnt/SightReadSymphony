import midi.TrackCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackCreatorTest {

    private TrackCreator tc = null;
    private Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @BeforeEach
    public void init() {
        tc = new TrackCreator();
    }

    @AfterEach
    public void teardown() {
        tc = null;
    }

    @Test
    public void populate_track_with_random_and_confirm_non_null() throws InvalidMidiDataException {
        Track track = null;
        track = tc.createRandomNotesTrack(20, 21, 108);
        for (int i = 0; i < track.size(); i++) {
            if (track.get(i).getMessage() instanceof ShortMessage) {
                ShortMessage sm = (ShortMessage) track.get(i).getMessage();
                log.log(Level.INFO, Integer.toString(sm.getData1()));
                assertTrue(track.get(i) != null);
            }
        }
    }

}
