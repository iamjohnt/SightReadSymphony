import gameoptions.ChordOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        chordOptions.setChoseThreeNoteChords(false);
        chordOptions.setChoseFourNoteChords(false);
        Exception exception = null;
        try {
            chordOptions.isValid();
        } catch (Exception e) {
            exception = e;
        }
        assertTrue(exception != null);
    }

    @Test public void test_chord_IS_chosen_and_SOME_chord_option_chosen() {
        chordOptions.setChoseChord(true);
        boolean isValid = false;
        // scenario 1
        chordOptions.setChoseRootInversion(true);
        chordOptions.setChoseSecondInversion(false);
        chordOptions.setChoseThirdInversion(false);
        chordOptions.setChoseThreeNoteChords(true);
        chordOptions.setChoseFourNoteChords(false);
        try {
            isValid = chordOptions.isValid();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        assertTrue(isValid);

        // scenario 2
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseSecondInversion(true);
        chordOptions.setChoseThirdInversion(false);
        chordOptions.setChoseThreeNoteChords(true);
        chordOptions.setChoseFourNoteChords(false);
        try {
            isValid = chordOptions.isValid();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        assertTrue(isValid);

        // scenario 3
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseSecondInversion(false);
        chordOptions.setChoseThirdInversion(true);
        chordOptions.setChoseThreeNoteChords(false);
        chordOptions.setChoseFourNoteChords(true);
        try {
            isValid = chordOptions.isValid();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        assertTrue(isValid);
    }

    @Test public void test_chord_NOT_chosen_and_NO_chord_options_chosen() {
        chordOptions.setChoseChord(false);
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseSecondInversion(false);
        chordOptions.setChoseThirdInversion(false);
        chordOptions.setChoseThreeNoteChords(false);
        chordOptions.setChoseFourNoteChords(false);
        boolean isValid = false;
        try {
            isValid = chordOptions.isValid();
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
        assertTrue(isValid);
    }

    @Test
    public void asdf() {
        assertEquals(1,1);
    }

    @Test public void test_chord_NOT_chosen_but_SOME_chord_options_chosen() {
        chordOptions.setChoseChord(false);

        // scenario 1
        chordOptions.setChoseRootInversion(true);
        chordOptions.setChoseSecondInversion(false);
        chordOptions.setChoseThirdInversion(false);
        chordOptions.setChoseThreeNoteChords(false);
        chordOptions.setChoseFourNoteChords(false);
        Exception exception1 = null;
        try {
            chordOptions.isValid();
        } catch (Exception e) {
            exception1 = e;
        }
        assertTrue(exception1 != null);
        // scenario 2
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseSecondInversion(true);
        chordOptions.setChoseThirdInversion(false);
        chordOptions.setChoseThreeNoteChords(false);
        chordOptions.setChoseFourNoteChords(false);
        Exception exception2 = null;
        try {
            chordOptions.isValid();
        } catch (Exception e) {
            exception2 = e;
        }
        assertTrue(exception2 != null);
        // scenario 3
        chordOptions.setChoseRootInversion(false);
        chordOptions.setChoseSecondInversion(false);
        chordOptions.setChoseThirdInversion(false);
        chordOptions.setChoseThreeNoteChords(true);
        chordOptions.setChoseFourNoteChords(false);
        Exception exception3 = null;
        try {
            chordOptions.isValid();
        } catch (Exception e) {
            exception3 = e;
        }
        assertTrue(exception3 != null);
    }
}
