package test.notecontext;

import notecontext.*;
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

    @Test
    public void test_can_get_everything() {
        int[] notes = {
                NamedNote.A_0,
                NamedNote.A_SHARP_0,
                NamedNote.B_FLAT_0,
                NamedNote.B_0,

                NamedNote.C_1,
                NamedNote.C_SHARP_1,
                NamedNote.D_FLAT_1,
                NamedNote.D_1,
                NamedNote.D_SHARP_1,
                NamedNote.E_FLAT_1,
                NamedNote.E_1,
                NamedNote.F_1,
                NamedNote.F_SHARP_1,
                NamedNote.G_FLAT_1,
                NamedNote.G_1,
                NamedNote.G_SHARP_1,
                NamedNote.A_FLAT_1,
                NamedNote.A_1,
                NamedNote.A_SHARP_1,
                NamedNote.B_FLAT_1,
                NamedNote.B_1,

                NamedNote.C_2,
                NamedNote.C_SHARP_2,
                NamedNote.D_FLAT_2,
                NamedNote.D_2,
                NamedNote.D_SHARP_2,
                NamedNote.E_FLAT_2,
                NamedNote.E_2,
                NamedNote.F_2,
                NamedNote.F_SHARP_2,
                NamedNote.G_FLAT_2,
                NamedNote.G_2,
                NamedNote.G_SHARP_2,
                NamedNote.A_FLAT_2,
                NamedNote.A_2,
                NamedNote.A_SHARP_2,
                NamedNote.B_FLAT_2,
                NamedNote.B_2,

                NamedNote.C_3,
                NamedNote.C_SHARP_3,
                NamedNote.D_FLAT_3,
                NamedNote.D_3,
                NamedNote.D_SHARP_3,
                NamedNote.E_FLAT_3,
                NamedNote.E_3,
                NamedNote.F_3,
                NamedNote.F_SHARP_3,
                NamedNote.G_FLAT_3,
                NamedNote.G_3,
                NamedNote.G_SHARP_3,
                NamedNote.A_FLAT_3,
                NamedNote.A_3,
                NamedNote.A_SHARP_3,
                NamedNote.B_FLAT_3,
                NamedNote.B_3,

                NamedNote.C_4,
                NamedNote.C_SHARP_4,
                NamedNote.D_FLAT_4,
                NamedNote.D_4,
                NamedNote.D_SHARP_4,
                NamedNote.E_FLAT_4,
                NamedNote.E_4,
                NamedNote.F_4,
                NamedNote.F_SHARP_4,
                NamedNote.G_FLAT_4,
                NamedNote.G_4,
                NamedNote.G_SHARP_4,
                NamedNote.A_FLAT_4,
                NamedNote.A_4,
                NamedNote.A_SHARP_4,
                NamedNote.B_FLAT_4,
                NamedNote.B_4,

                NamedNote.C_5,
                NamedNote.C_SHARP_5,
                NamedNote.D_FLAT_5,
                NamedNote.D_5,
                NamedNote.D_SHARP_5,
                NamedNote.E_FLAT_5,
                NamedNote.E_5,
                NamedNote.F_5,
                NamedNote.F_SHARP_5,
                NamedNote.G_FLAT_5,
                NamedNote.G_5,
                NamedNote.G_SHARP_5,
                NamedNote.A_FLAT_5,
                NamedNote.A_5,
                NamedNote.A_SHARP_5,
                NamedNote.B_FLAT_5,
                NamedNote.B_5,

                NamedNote.C_6,
                NamedNote.C_SHARP_6,
                NamedNote.D_FLAT_6,
                NamedNote.D_6,
                NamedNote.D_SHARP_6,
                NamedNote.E_FLAT_6,
                NamedNote.E_6,
                NamedNote.F_6,
                NamedNote.F_SHARP_6,
                NamedNote.G_FLAT_6,
                NamedNote.G_6,
                NamedNote.G_SHARP_6,
                NamedNote.A_FLAT_6,
                NamedNote.A_6,
                NamedNote.A_SHARP_6,
                NamedNote.B_FLAT_6,
                NamedNote.B_6,

                NamedNote.C_7,
                NamedNote.C_SHARP_7,
                NamedNote.D_FLAT_7,
                NamedNote.D_7,
                NamedNote.D_SHARP_7,
                NamedNote.E_FLAT_7,
                NamedNote.E_7,
                NamedNote.F_7,
                NamedNote.F_SHARP_7,
                NamedNote.G_FLAT_7,
                NamedNote.G_7,
                NamedNote.G_SHARP_7,
                NamedNote.A_FLAT_7,
                NamedNote.A_7,
                NamedNote.A_SHARP_7,
                NamedNote.B_FLAT_7,
                NamedNote.B_7,

                NamedNote.C_8
        };
        for (int i = 0; i < notes.length; i++) {
            treble.getNoteY(notes[i]);
            treble.getLineY(notes[i]);
        }
    }

    public void test_A0_to_B0() {
        Clef clef = new Clef(Clef.IS_TREBLE, 0, 10);

    }
}
