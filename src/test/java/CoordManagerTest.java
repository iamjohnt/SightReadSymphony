import draw.MusicNote;
import draw.CoordManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordManagerTest {

    private CoordManager test;

    @BeforeEach
    public void init() {
        test = new CoordManager();
    }

    @AfterEach
    public void teardown() {
        test = null;
    }

    @Test
    public void run() {
        test.mapTrebleNoteToCoord(200, 18);
        test.mapBassNoteToCoord(400, 18);
        System.out.println(test.getTrebleYCoord(new MusicNote(MusicNote.C, 0, 8)));
        System.out.println(test.getTrebleYCoord(new MusicNote(MusicNote.A, 0, 0)));
        System.out.println(test.getBassYCoord(new MusicNote(MusicNote.C, 0, 8)));
        System.out.println(test.getBassYCoord(new MusicNote(MusicNote.A, 0, 0)));
    }

    @Test
    public void testC8treble() {
        test.mapTrebleNoteToCoord(100, 18);
        assertEquals(-62.0, test.getTrebleYCoord(new MusicNote(MusicNote.C, 0, 8)));
    }

    @Test
    public void testF5treble() {
        test.mapTrebleNoteToCoord(100, 18);
        assertEquals(100, test.getTrebleYCoord(new MusicNote(MusicNote.F, 0, 5)));
    }

    @Test
    public void testA0treble() {
        test.mapTrebleNoteToCoord(100, 18);
        int distF5andA0 = 33 * 9;
        assertEquals(100 + distF5andA0, test.getTrebleYCoord(new MusicNote(MusicNote.A, 0,0)));
    }

    @Test
    public void test_C8_bass() {
        test.mapBassNoteToCoord(100, 18);
        int distA3_to_C8 = -30;
        double noteSpacing = 18 / 2;
        assertEquals(100 + (noteSpacing * distA3_to_C8), test.getBassYCoord(new MusicNote(MusicNote.C, 0, 8)));
    }

    @Test
    public void test_A3_bass() {
        test.mapBassNoteToCoord(100, 18);
        assertEquals(100, test.getBassYCoord(new MusicNote(MusicNote.A, 0, 3)));
    }

    @Test
    public void test_A0_bass() {
        test.mapBassNoteToCoord(100, 18);
        int distA3_to_A0 = 21;
        double noteSpacing = 18 / 2;
        assertEquals(100 + (noteSpacing * distA3_to_A0),  test.getBassYCoord(new MusicNote(MusicNote.A, 0,0)));
    }
}
