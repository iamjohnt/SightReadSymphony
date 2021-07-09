import draw.CoordManager;
import draw.MusicNote;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import spawn.SpawnManager;

import java.io.File;
import java.net.MalformedURLException;

public class SpawnManagerTest {

    private SpawnManager spawn;

    @BeforeEach
    public void init() {
        spawn = new SpawnManager();
    }

    @AfterEach
    public void teardown() {
        spawn = null;
    }

    @Test
    public void run() throws MalformedURLException {
        MusicNote C4 = new MusicNote(MusicNote.C, MusicNote.NO_ACCIDENTAL, 4);
        Rectangle view = spawn.createRectangleToHoldNote(C4, SpawnManager.WHOLE, SpawnManager.TAIL_NONE, 0);
    }

    @Test
    public void test_x() {
        CoordManager coordManager = new CoordManager(0, 0, 18);
        MusicNote C4 = new MusicNote(MusicNote.C, MusicNote.NO_ACCIDENTAL, 4);
        Rectangle rect = spawn.createRectangleToHoldNote(C4, SpawnManager.WHOLE, SpawnManager.TAIL_NONE, 0);
        assertEquals(0, rect.getX());
    }

    @Test
    public void test_y() {
        CoordManager coordManager = new CoordManager(0, 0, 18);
        MusicNote C4 = new MusicNote(MusicNote.C, MusicNote.NO_ACCIDENTAL, 4);
        Rectangle rect = spawn.createRectangleToHoldNote(C4, SpawnManager.WHOLE, SpawnManager.TAIL_NONE, 0);
        assertEquals(coordManager.getTrebleYCoord(C4), rect.getY());
    }

    @Test
    public void test_height() {
        MusicNote C4 = new MusicNote(MusicNote.C, MusicNote.NO_ACCIDENTAL, 4);
        Rectangle rect = spawn.createRectangleToHoldNote(C4, SpawnManager.WHOLE, SpawnManager.TAIL_NONE, 0);
        double height = rect.getHeight();
        assertEquals(18, height);
    }

    @Test
    public void test_width() {
        MusicNote C4 = new MusicNote(MusicNote.C, MusicNote.NO_ACCIDENTAL, 4);
        Rectangle rect = spawn.createRectangleToHoldNote(C4, SpawnManager.WHOLE, SpawnManager.TAIL_NONE, 0);
        double width = rect.getWidth();
        assertTrue(width > 18);
    }
}
