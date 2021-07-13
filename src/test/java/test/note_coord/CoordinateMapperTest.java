package test.note_coord;

import note_coordinate.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

public class CoordinateMapperTest {

    private CoordinateMapper mapper;
    private HashMap<Integer, Double> result;

    @BeforeEach
    public void init() {
        mapper = new CoordinateMapper();
        result = new HashMap<>();
    }

    @AfterEach
    public void teardown() {
        mapper = null;
        result = null;
    }

    @Test
    public void run() {
        result = mapper.calcNoteCoordMapping(true,0, 18);
    }

    @Test
    public void test_C8_treble() {
        result = mapper.calcNoteCoordMapping(CoordinateMapper.IS_TREBLE,0.0, 18);
        double actual = result.get(NamedNote.C_8);
        double expected = -162.0;
        assertEquals(expected, actual);
    }

    @Test
    public void test_F5_treble() {
        result = mapper.calcNoteCoordMapping(CoordinateMapper.IS_TREBLE,0.0, 18);
        double actual = result.get(NamedNote.F_5);
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    public void test_A0_treble() {
        result = mapper.calcNoteCoordMapping(CoordinateMapper.IS_TREBLE,0.0, 18);
        double actual = result.get(NamedNote.A_0);
        double expected = 297.0;
        assertEquals(expected, actual);
    }

    @Test
    public void A3_bass() {
        System.out.println(NamedNote.A_3);
        result = mapper.calcNoteCoordMapping(CoordinateMapper.IS_BASS,0.0, 18);
        double actual = result.get(NamedNote.A_3);
        double expected = 0.0;
        assertEquals(expected, actual);
    }

    @Test
    public void c8_bass() {
        result = mapper.calcNoteCoordMapping(CoordinateMapper.IS_BASS,0.0, 18);
        double actual = result.get(NamedNote.C_8);
        double expected = 30 * 9 * -1;
        assertEquals(expected, actual);
    }

    @Test
    public void a0_bass() {
        result = mapper.calcNoteCoordMapping(CoordinateMapper.IS_BASS,0.0, 18);
        double actual = result.get(NamedNote.A_0);
        int HALF_STEPS_TWEEN_A3_A0 = 21;
        double expected = HALF_STEPS_TWEEN_A3_A0 * 9;
        assertEquals(expected, actual);
    }
}
