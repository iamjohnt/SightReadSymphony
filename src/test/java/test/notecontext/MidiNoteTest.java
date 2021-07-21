package test.notecontext;

import notecontext.MidiNote;
import notecontext.NamedNote;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MidiNoteTest {

    @Test
    public void test() {
        MidiNote a_sharp_0 = new MidiNote(MidiNote.A_SHARP_0);
        assertEquals(MidiNote.SHARP, a_sharp_0.getRequestedAccidental());
    }

    @Test
    public void test_boundaries() {
        MidiNote a0 = new MidiNote(MidiNote.A_0);
        MidiNote c8 = new MidiNote(MidiNote.C_8);
        assertEquals(MidiNote.NO_ACCIDENTAL, a0.getRequestedAccidental());
        assertEquals(MidiNote.NO_ACCIDENTAL, a0.getRequestedAccidental());
    }

    @Test
    public void test_flats() {
        MidiNote d_flat_3 = new MidiNote(MidiNote.D_FLAT_3);
        MidiNote g_flat_6 = new MidiNote(MidiNote.G_FLAT_6);
        assertEquals(MidiNote.FLAT, d_flat_3.getRequestedAccidental());
        assertEquals(MidiNote.FLAT, g_flat_6.getRequestedAccidental());
    }

    @Test
    public void to_named_note_c_sharp_4() {
        NamedNote expected_c_sharp_4 = new NamedNote(NamedNote.C_SHARP_4);
        NamedNote actual_c_sharp_4 = new MidiNote(MidiNote.C_SHARP_4).toNamedNoteV2(MidiNote.SHARP);
        assertEquals(expected_c_sharp_4.getNoteLetter(), actual_c_sharp_4.getNoteLetter());
        assertEquals(expected_c_sharp_4.getOctave(), actual_c_sharp_4.getOctave());
        assertEquals(expected_c_sharp_4.getAccidental(), actual_c_sharp_4.getAccidental());
    }

    @Test
    public void to_named_note_d_flat_4() {
        NamedNote expected_c_sharp_4 = new NamedNote(NamedNote.D_FLAT_4);
        NamedNote actual_c_sharp_4 = new MidiNote(MidiNote.D_FLAT_4).toNamedNoteV2(MidiNote.FLAT);
        assertEquals(expected_c_sharp_4.getNoteLetter(), actual_c_sharp_4.getNoteLetter());
        assertEquals(expected_c_sharp_4.getOctave(), actual_c_sharp_4.getOctave());
        assertEquals(expected_c_sharp_4.getAccidental(), actual_c_sharp_4.getAccidental());
    }

}
