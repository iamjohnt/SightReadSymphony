import gameoptions.ChordOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChordOptionsTest {

    private ChordOptions chordOptions;

    @BeforeEach
    public void init() {
        chordOptions = new ChordOptions();
    }

    @AfterEach public void teardown() {
        chordOptions = null;
    }

    @Test public void test_chord_IS_chosen_and_NO_chord_options_chosen() {
        chordOptions.setChoseChord(true);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        assertEquals(false, chordOptions.isValid());
    }

    @Test public void test_chord_IS_chosen_and_SOME_chord_option_chosen() {
        chordOptions.setChoseChord(true);
        chordOptions.setChoseRootInversion(true);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        assertEquals(true, chordOptions.isValid());

        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(true);
        chordOptions.setChoseRootInversion(false);
        assertEquals(true, chordOptions.isValid());

        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(true);
        assertEquals(true, chordOptions.isValid());
    }

    @Test public void test_chord_NOT_chosen_and_NO_chord_options_chosen() {
        chordOptions.setChoseChord(false);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        assertEquals(true, chordOptions.isValid());
    }

    @Test public void test_chord_NOT_chosen_but_SOME_chord_options_chosen() {
        chordOptions.setChoseChord(false);
        chordOptions.setChoseRootInversion(true);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        assertEquals(false, chordOptions.isValid());

        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(true);
        chordOptions.setChoseRootInversion(false);
        assertEquals(false, chordOptions.isValid());

        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseRootInversion(true);
        assertEquals(false, chordOptions.isValid());
    }
}
