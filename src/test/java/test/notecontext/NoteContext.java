package test.notecontext;

import game.Config;
import notecontext.Clef;
import notecontext.KeySignature;
import notecontext.NamedNote;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoteContext {

    @Test
    public void run() {
        Clef treble = new Clef(Clef.IS_TREBLE, 0.0, 18);
        Clef bass = new Clef(Clef.IS_BASS, 0.0, 18);
        KeySignature gMajor = new KeySignature(KeySignature.G_MAJOR);
        Config config = new Config();
        config.setKeySigID(KeySignature.G_MAJOR_ID);
        config.setBassClefY(0);
        config.setTrebleClefY(0);
        config.setTrebleClefHeight(18);
        config.setBassClefHeight(18);
        notecontext.NoteContext context = new notecontext.NoteContext(config);
        int f5 = NamedNote.F_5;
        assertEquals(-9.0, context.getTrebleNoteY(f5));
        assertEquals(0.0, context.getTrebleLineY(f5));
        assertFalse(context.isNoteChromatic(f5));
        assertTrue(context.isNoteChromatic(NamedNote.F_SHARP_1));

    }
}
