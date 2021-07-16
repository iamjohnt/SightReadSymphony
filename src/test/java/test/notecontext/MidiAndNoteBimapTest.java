package test.notecontext;

import notecontext.MidiAndNoteBimap;
import notecontext.MidiNote;
import notecontext.NamedNote;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MidiAndNoteBimapTest {

    public MidiAndNoteBimap mapper;

    @BeforeEach
    public void init() {
        mapper = new MidiAndNoteBimap();
    }

    @AfterEach
    public void teardown() {
        mapper = null;
    }

    @Test
    public void test_boundaries() {
        int midiID_a0 = MidiNote.A_0;
        int midiID_c8 = MidiNote.C_8;
        int noteID_a0 = mapper.getNoteIDWithMidiID(midiID_a0);
        int noteID_c8 = mapper.getNoteIDWithMidiID(midiID_c8);
        NamedNote a0 = new NamedNote(noteID_a0);
        NamedNote c8 = new NamedNote(noteID_c8);

        assertEquals(NamedNote.A, a0.getNoteLetter());
        assertEquals(NamedNote.C, c8.getNoteLetter());
        assertEquals(NamedNote.NO_ACCIDENTAL, a0.getAccidental());
        assertEquals(NamedNote.NO_ACCIDENTAL, c8.getAccidental());
        assertEquals(NamedNote.ZERO, a0.getOctave());
        assertEquals(NamedNote.EIGHT, c8.getOctave());
    }

    @Test
    public void test_sharps() {
        int noteID_a_sharp_0 = mapper.getNoteIDWithMidiID(MidiNote.A_SHARP_0);
        int noteID_c_sharp_1 = mapper.getNoteIDWithMidiID(MidiNote.C_SHARP_1);
        int noteID_d_sharp_2 = mapper.getNoteIDWithMidiID(MidiNote.D_SHARP_2);
        int noteID_f_sharp_3 = mapper.getNoteIDWithMidiID(MidiNote.F_SHARP_3);
        int noteID_g_sharp_4 = mapper.getNoteIDWithMidiID(MidiNote.G_SHARP_4);

        NamedNote a_sharp_0 = new NamedNote(noteID_a_sharp_0);
        NamedNote c_sharp_0 = new NamedNote(noteID_c_sharp_1);
        NamedNote d_sharp_0 = new NamedNote(noteID_d_sharp_2);
        NamedNote f_sharp_0 = new NamedNote(noteID_f_sharp_3);
        NamedNote g_sharp_0 = new NamedNote(noteID_g_sharp_4);

        assertEquals(NamedNote.SHARP, a_sharp_0.getAccidental());
        assertEquals(NamedNote.SHARP, c_sharp_0.getAccidental());
        assertEquals(NamedNote.SHARP, d_sharp_0.getAccidental());
        assertEquals(NamedNote.SHARP, f_sharp_0.getAccidental());
        assertEquals(NamedNote.SHARP, g_sharp_0.getAccidental());
    }
}
