package test.note_coord;

import note_coordinate.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClefTest {

    public Clef treble;
    public Clef bass;

    @BeforeEach
    public void init() {
        treble = new Clef(Clef.IS_TREBLE, 0, 18);
        bass = new Clef(Clef.IS_BASS, 0, 18);
    }

    @AfterEach
    public void teardown() {
        treble = null;
        bass = null;
    }

    @Test
    public void run() {
        Clef map = new Clef(Clef.IS_TREBLE, 0, 18);
    }

    @Test
    public void test_C8_treble() {
        double actualNote = treble.getNoteY(NamedNote.C_8);
        double actualLine = treble.getLineY(NamedNote.C_8);
        double expectedNote = -162.0 - 9.0;
        double expectedLine = -162.0;
        assertEquals(expectedLine, actualLine);
        assertEquals(expectedNote, actualNote);
    }

    @Test
    public void test_F5_treble() {
        double actualNote = treble.getNoteY(NamedNote.F_5);
        double actualLine = treble.getLineY(NamedNote.F_5);
        double expectedLine = 0.0;
        double expectedNote = 0.0 - 9;
        assertEquals(expectedNote, actualNote);
        assertEquals(expectedLine, actualLine);
    }

    @Test
    public void test_A0_treble() {
        double expectedA0_Line = 297.0;
        double expectedA0_Note = 297.0 - 9.0;
        double actualA0_Note = treble.getNoteY(NamedNote.A_0);
        double actualA0_Line = treble.getLineY(NamedNote.A_0);
        assertEquals(expectedA0_Line, actualA0_Line);
        assertEquals(expectedA0_Note, actualA0_Note);
    }

    @Test
    public void A3_bass() {
        double expected_A3_line = 0.0;
        double expected_A3_note = 0.0 - 9.0;
        double actual_A3_note = bass.getNoteY(NamedNote.A_3);
        double actual_A3_Line = bass.getLineY(NamedNote.A_3);
        assertEquals(expected_A3_line, actual_A3_Line);
        assertEquals(expected_A3_note, actual_A3_note);
    }

    @Test
    public void c8_bass() {
        int halfStepsTweenA3andC8 = -30;
        double halfStepHeight = 9.0;
        double expected_c8_line = halfStepsTweenA3andC8 * halfStepHeight;
        double expected_c8_note = expected_c8_line - halfStepHeight;
        double actual_c8_note = bass.getNoteY(NamedNote.C_8);
        double actual_c8_Line = bass.getLineY(NamedNote.C_8);
        assertEquals(expected_c8_line, actual_c8_Line);
        assertEquals(expected_c8_note, actual_c8_note);
    }

    @Test
    public void a0_bass() {
        int halfStepsTweenA3andA0 = 21;
        double halfStepHeight = 9.0;
        double expected_a0_line = halfStepsTweenA3andA0 * halfStepHeight;
        double expected_a0_note = expected_a0_line - halfStepHeight;
        double actual_a0_note = bass.getNoteY(NamedNote.A_0);
        double actual_a0_Line = bass.getLineY(NamedNote.A_0);
        assertEquals(expected_a0_line, actual_a0_Line);
        assertEquals(expected_a0_note, actual_a0_note);
    }
}
