package test.session;

import game.Config;
import notecontext.NamedNote;
import org.junit.jupiter.api.Test;
import game.NoteGenerator;

public class NoteGeneratorTest {

    @Test
    public void run() {
        Config config = new Config();
        NoteGenerator gen = new NoteGenerator(config);
        for (int i = 0; i < 100; i++) {
            System.out.println(gen.getRandomNamedNote().toString());
        }
    }
}
