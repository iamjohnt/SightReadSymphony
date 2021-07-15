package test.note_coord;

import note_coordinate.Clef;
import note_coordinate.KeySignature;
import note_coordinate.NamedNote;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoteContext {

    @Test
    public void run() {
        Clef treble = new Clef(Clef.IS_TREBLE, 0.0, 18);
        Clef bass = new Clef(Clef.IS_BASS, 0.0, 18);
        KeySignature gMajor = new KeySignature(KeySignature.G_MAJOR);
        note_coordinate.NoteContext context = new note_coordinate.NoteContext(gMajor, treble, bass);
        int f5 = NamedNote.F_5;
        assertEquals(-9.0, context.getTrebleNoteY(f5));
        assertEquals(0.0, context.getTrebleLineY(f5));
        assertFalse(context.isNoteChromatic(f5));
        assertTrue(context.isNoteChromatic(NamedNote.F_SHARP_1));

    }
}
