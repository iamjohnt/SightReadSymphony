package test.session;

import logic.Config;
import notecontext.NamedNote;
import org.junit.jupiter.api.Test;
import session.NoteGenerator;

public class NoteGeneratorTest {

    @Test
    public void run() {
        Config config = new Config();
        config.setMaxTreble(NamedNote.A_1);
        config.setMinTreble(NamedNote.A_0);
        config.setMaxBass(NamedNote.A_1);
        config.setMinBass(NamedNote.A_0);
        NoteGenerator gen = new NoteGenerator(config);
        for (int i = 0; i < 100; i++) {
            System.out.println(new NamedNote(gen.getRandomTrebleNoteID_v2()).toString());
        }
    }
}
