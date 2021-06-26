import midi.SequenceCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class SequenceCreatorTest {

    private SequenceCreator sc = null;

    @BeforeEach
    public void init() {
        sc = new SequenceCreator();
    }

    @AfterEach
    public void teardown() {
        sc = null;
    }

    @Test
    public void rand_note_within_bounds() {
        SequenceCreator sc = new SequenceCreator();
        MidiEvent event = null;
        try {
            event = sc.createRandMidiEvent(21, 108);
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
        ShortMessage sm = (ShortMessage) event.getMessage();
        int resultNote = sm.getData1();
        assertTrue(resultNote >= 21 && resultNote <= 108);
    }
}
