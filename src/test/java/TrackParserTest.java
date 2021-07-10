import gameoptions.ChordOptions;
import midi.TrackCreator;
import midi.TrackParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;
import java.util.Arrays;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TrackParserTest {

    TrackParser tp = null;
    private Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @BeforeEach
    public void init() {
        tp = new TrackParser();
    }

    @AfterEach
    public void teardown() {
        tp = null;
    }

    @Test
    public void create_and_convert_track_to_midi_confirm_same_notes_afterwards() throws InvalidMidiDataException {
        TrackCreator creator = new TrackCreator();
        TrackParser parser = new TrackParser();
        Track track = creator.createRandomNotesTrack(20, 21, 108);
        int[] notes = parser.convertTrackToMidiIntegerArray(track);
        System.out.println("test result for: create_and_convert_track_to_midi_confirm_same_notes_afterwards() " + Arrays.toString(notes));

    }
}
