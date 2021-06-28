import midi.TrackCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackCreatorTest {

    private TrackCreator sc = null;
    private Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @BeforeEach
    public void init() {
        try {
            sc = new TrackCreator();
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void teardown() {
        sc = null;
    }

    @Test
    public void populate_track_with_random_and_confirm_non_null() throws InvalidMidiDataException {
        Track track = null;
        track = sc.createRandomNotesTrack(20, 21, 108);
        for (int i = 0; i < 20; i++) {
            ShortMessage sm = (ShortMessage) track.get(i).getMessage();
            log.log(Level.INFO, Integer.toString(sm.getData1()));
            assertTrue(track.get(i) != null);
        }
    }

    @Test
    public void set_and_repeat_note_from_sequence() {
        try {
            sc.addToTreble(5);
            assertEquals(sc.getNoteFromTreble(0), 5);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void populate_and_confirm_sequence() {
        for (int i = 0; i < 10; i++) {
            try {
                sc.addToTreble(i);
            } catch (InvalidMidiDataException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(sc.getNoteFromTreble(i), i);
        }
    }

    @Test
    public void populate_rand_and_confirm_everything_populated_fine() {
        try {
            sc.populateTrebleRandMidiEvents(20,21, 108);
            sc.populateBassRandMidiEvents(20,21,108);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 20; i++) {
            assertEquals(sc.getTrebleSize(), 20);
            assertEquals(sc.getBassSize(), 20);
        }
    }

    @Test
    public void populate_rand_and_print_it_to_see_if_actually_random() {
        try {
            sc.populateTrebleRandMidiEvents(20,21, 108);
            sc.populateBassRandMidiEvents(20,21,108);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }

        int treblePrev = 0;
        int bassPrev = 0;
        for (int i = 0; i < 20; i++) {
            System.out.println(sc.getNoteFromTreble(i) + " " + sc.getNoteFromBass(i));;
        }
    }
}
