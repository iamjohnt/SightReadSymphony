import gameoptions.NoteRangeOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteRangeOptionsTest {

    private NoteRangeOptions range;

    @BeforeEach public void init_all_valid_data() {
        range = new NoteRangeOptions();
        range.setMinBass(30);
        range.setMaxBass(60);
        range.setMinTreble(70);
        range.setMaxTreble(100);
    }

    @AfterEach public void teardown() {
        range = null;
    }

    @Test
    public void min_notes_too_low() {
        range.setMinBass(0);
        assertFalse(range.isValid());

        range.setMinTreble(0);
        assertFalse(range.isValid());
    }

    @Test
    public void max_notes_too_high() {
        range.setMaxBass(120);
        assertFalse(range.isValid());

        range.setMaxTreble(120);
        assertFalse(range.isValid());
    }

    @Test
    public void min_note_near_and_at_low_threshold() {
        range.setMinBass(20);           // 1 below thresh
        assertFalse(range.isValid());
        range.setMinBass(21);           // just at thresh to be valid
        assertTrue(range.isValid());
        range.setMinBass(22);           // 1 above thresh
        assertTrue(range.isValid());

        range.setMinTreble(20);           // 1 below thresh
        assertFalse(range.isValid());
        range.setMinTreble(21);           // just at thresh to be valid
        assertTrue(range.isValid());
        range.setMinTreble(22);           // 1 above thresh
        assertTrue(range.isValid());
    }

    @Test
    public void max_near_and_at_high_threshold() {
        range.setMinBass(107);
        assertTrue(range.isValid());
        range.setMinBass(108);
        assertTrue(range.isValid());
        range.setMinBass(109);
        assertFalse(range.isValid());

        range.setMinTreble(107);
        assertTrue(range.isValid());
        range.setMinTreble(108);
        assertTrue(range.isValid());
        range.setMinTreble(109);
        assertFalse(range.isValid());
    }


    @Test
    public void min_bass_higher_than_max_bass() {
        range.setMinBass(70);
        range.setMaxBass(69);
        assertFalse(range.isValid());
    }

    @Test
    public void min_treble_higher_than_max_treble() {
        range.setMinTreble(70);
        range.setMaxTreble(69);
        assertFalse(range.isValid());
    }
}
