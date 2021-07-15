package test.notecontext;

import notecontext.MidiNote;
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

}
