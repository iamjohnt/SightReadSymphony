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
        test = new CoordManager(0,0, 18);
    }

    @AfterEach
    public void teardown() {
        test = null;
    }

    @Test
    public void run() {
        System.out.println(test.getYCoordOfTrebleLine(new MusicNote(MusicNote.C, 0, 8)));
        System.out.println(test.getYCoordOfTrebleLine(new MusicNote(MusicNote.A, 0, 0)));
        System.out.println(test.getYCoordOfBassLine(new MusicNote(MusicNote.C, 0, 8)));
        System.out.println(test.getYCoordOfBassLine(new MusicNote(MusicNote.A, 0, 0)));
    }

    @Test
    public void testC8Linetreble() {
        double distF5_to_C8 = -18; // so distance is -18 * 9, the lineheight
        assertEquals(-18 * 9 + 0, test.getYCoordOfTrebleLine(new MusicNote(MusicNote.C, 0, 8)));
    }
}
