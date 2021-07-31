package test.notecontext;

import notecontext.NamedNote;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NamedNoteTest {

    @Test
    public void test_basic_constructor() {
        NamedNote a0 = new NamedNote(NamedNote.A_0);
        assertEquals(0, a0.getNoteLetter());
        assertEquals(1, a0.getAccidental());
        assertEquals(0, a0.getOctave());
    }

    @Test
    public void test_basic_constructor_boundaries() {
        NamedNote a0 = new NamedNote(NamedNote.A_0);
        assertEquals(0, a0.getNoteLetter());
        assertEquals(1, a0.getAccidental());
        assertEquals(0, a0.getOctave());

        NamedNote c8 = new NamedNote(NamedNote.C_8);
        assertEquals(NamedNote.C, c8.getNoteLetter());
        assertEquals(NamedNote.NO_ACCIDENTAL, c8.getAccidental());
        assertEquals(NamedNote.EIGHT, c8.getOctave());
    }

    @Test
    public void test_no_accidentals() {
        NamedNote c2 = new NamedNote(NamedNote.C_2);
        NamedNote e4 = new NamedNote(NamedNote.E_4);
        NamedNote g6 = new NamedNote(NamedNote.G_6);

        assertEquals(NamedNote.C, c2.getNoteLetter());
        assertEquals(NamedNote.NO_ACCIDENTAL, c2.getAccidental());
        assertEquals(NamedNote.TWO, c2.getOctave());

        assertEquals(NamedNote.E, e4.getNoteLetter());
        assertEquals(NamedNote.NO_ACCIDENTAL, e4.getAccidental());
        assertEquals(NamedNote.FOUR, e4.getOctave());

        assertEquals(NamedNote.G, g6.getNoteLetter());
        assertEquals(NamedNote.NO_ACCIDENTAL, g6.getAccidental());
        assertEquals(NamedNote.SIX, g6.getOctave());
    }

    @Test
    public void test_sharps() {
        NamedNote f_sharp_1 = new NamedNote(NamedNote.F_SHARP_1);
        NamedNote g_sharp_3 = new NamedNote(NamedNote.G_SHARP_3);
        NamedNote a_sharp_5 = new NamedNote(NamedNote.A_SHARP_5);

        assertEquals(NamedNote.SHARP, f_sharp_1.getAccidental());
        assertEquals(NamedNote.SHARP, g_sharp_3.getAccidental());
        assertEquals(NamedNote.SHARP, a_sharp_5.getAccidental());

        assertEquals(NamedNote.F, f_sharp_1.getNoteLetter());
        assertEquals(NamedNote.G, g_sharp_3.getNoteLetter());
        assertEquals(NamedNote.A, a_sharp_5.getNoteLetter());

        assertEquals(NamedNote.ONE, f_sharp_1.getOctave());
        assertEquals(NamedNote.THREE, g_sharp_3.getOctave());
        assertEquals(NamedNote.FIVE, a_sharp_5.getOctave());
    }

    @Test
    public void test_flats() {
        NamedNote d_flat_1 = new NamedNote(NamedNote.D_FLAT_1);
        NamedNote g_flat_3 = new NamedNote(NamedNote.G_FLAT_3);
        NamedNote a_flat_5 = new NamedNote(NamedNote.A_FLAT_5);

        assertEquals(NamedNote.FLAT, d_flat_1.getAccidental());
        assertEquals(NamedNote.FLAT, g_flat_3.getAccidental());
        assertEquals(NamedNote.FLAT, a_flat_5.getAccidental());

        assertEquals(NamedNote.D, d_flat_1.getNoteLetter());
        assertEquals(NamedNote.G, g_flat_3.getNoteLetter());
        assertEquals(NamedNote.A, a_flat_5.getNoteLetter());

        assertEquals(NamedNote.ONE, d_flat_1.getOctave());
        assertEquals(NamedNote.THREE, g_flat_3.getOctave());
        assertEquals(NamedNote.FIVE, a_flat_5.getOctave());
    }

    @Test
    public void test_extract() {
        int extractee = 123;
        int actualAccidental = NamedNote.extractAccidental(123);
        int actualNoteLetter = NamedNote.extractNoteLetter(123);
        int actualOctave = NamedNote.extractOctave(123);
        assertEquals(1, actualOctave);
        assertEquals(2, actualNoteLetter);
        assertEquals(3, actualAccidental);
    }

    @Test
    public void test_build_noteID() {
        int noteLetter = 0;
        int octave = 5;
        int accidental = 2;
        int actual = NamedNote.buildNoteID(noteLetter, accidental, octave);
        assertEquals(502, actual);
    }

    @Test
    public void test_extract_a0_to_b0() {
        int a_0_letter = NamedNote.extractNoteLetter(NamedNote.A_0);
        int a_0_octave = NamedNote.extractOctave(NamedNote.A_0);
        int a_0_acc = NamedNote.extractAccidental(NamedNote.A_0);
        assertEquals(0, a_0_octave);
        assertEquals(0, a_0_letter);
        assertEquals(1, a_0_acc);

        int a_sharp_0_letter = NamedNote.extractNoteLetter(NamedNote.A_SHARP_0);
        int a_sharp_0_octave = NamedNote.extractOctave(NamedNote.A_SHARP_0);
        int a_sharp_0_acc = NamedNote.extractAccidental(NamedNote.A_SHARP_0);
        assertEquals(0, a_sharp_0_letter);
        assertEquals(0, a_sharp_0_octave);
        assertEquals(2, a_sharp_0_acc);

        int asdf = NamedNote.B_FLAT_0;
        int b_flat_0_letter = NamedNote.extractNoteLetter(NamedNote.B_FLAT_0);
        int b_flat_0_octave = NamedNote.extractOctave(NamedNote.B_FLAT_0);
        int b_flat_0_acc = NamedNote.extractAccidental(NamedNote.B_FLAT_0);
        assertEquals(1, b_flat_0_letter);
        assertEquals(0, b_flat_0_octave);
        assertEquals(0, b_flat_0_octave);

        int b_0_letter = NamedNote.extractNoteLetter(NamedNote.B_0);
        int b_0_octave = NamedNote.extractOctave(NamedNote.B_0);
        int b_0_acc = NamedNote.extractAccidental(NamedNote.B_0);
        assertEquals(1, b_0_letter);
        assertEquals(0, b_0_octave);
        assertEquals(1, b_0_acc);
    }

    @Test
    public void testCompare() {
        NamedNote c4 = new NamedNote(NamedNote.C_4);
        NamedNote b4 = new NamedNote(NamedNote.B_4);
        int c4_to_b4 = c4.compare(b4);
        int b4_to_c4 = b4.compare(c4);
        int c4_to_c4 = c4.compare(c4);
        assertEquals(-1, c4_to_b4);
        assertEquals(1, b4_to_c4);
        assertEquals(0, c4_to_c4);
    }
}
