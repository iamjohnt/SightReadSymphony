package note_coordinate;

import java.util.HashMap;

public class CoordinateMapper {

    private static final int HALF_STEPS_TWEEN_F5_C8 = 18;
    private static final int HALF_STEPS_TWEEN_A3_C8 = 31;
    private static final boolean IS_TREBLE = true;
    private static final boolean IS_BASS = false;

    private static final int DUMMY_ACCIDENTAL = 0;
    private Note[] whiteNotes = {
            new Note(Note.C, DUMMY_ACCIDENTAL, 8),   // 0 index

            new Note(Note.B, DUMMY_ACCIDENTAL, 7),   // 1
            new Note(Note.A, DUMMY_ACCIDENTAL, 7),
            new Note(Note.G, DUMMY_ACCIDENTAL, 7),
            new Note(Note.F, DUMMY_ACCIDENTAL, 7),
            new Note(Note.E, DUMMY_ACCIDENTAL, 7),
            new Note(Note.D, DUMMY_ACCIDENTAL, 7),
            new Note(Note.C, DUMMY_ACCIDENTAL, 7),

            new Note(Note.B, DUMMY_ACCIDENTAL, 6),   // 8
            new Note(Note.A, DUMMY_ACCIDENTAL, 6),
            new Note(Note.G, DUMMY_ACCIDENTAL, 6),
            new Note(Note.F, DUMMY_ACCIDENTAL, 6),
            new Note(Note.E, DUMMY_ACCIDENTAL, 6),
            new Note(Note.D, DUMMY_ACCIDENTAL, 6),
            new Note(Note.C, DUMMY_ACCIDENTAL, 6),

            new Note(Note.B, DUMMY_ACCIDENTAL, 5),   // 15
            new Note(Note.A, DUMMY_ACCIDENTAL, 5),
            new Note(Note.G, DUMMY_ACCIDENTAL, 5),
            new Note(Note.F, DUMMY_ACCIDENTAL, 5),
            new Note(Note.E, DUMMY_ACCIDENTAL, 5),
            new Note(Note.D, DUMMY_ACCIDENTAL, 5),
            new Note(Note.C, DUMMY_ACCIDENTAL, 5),

            new Note(Note.B, DUMMY_ACCIDENTAL, 4),   // 22
            new Note(Note.A, DUMMY_ACCIDENTAL, 4),
            new Note(Note.G, DUMMY_ACCIDENTAL, 4),
            new Note(Note.F, DUMMY_ACCIDENTAL, 4),
            new Note(Note.E, DUMMY_ACCIDENTAL, 4),
            new Note(Note.D, DUMMY_ACCIDENTAL, 4),
            new Note(Note.C, DUMMY_ACCIDENTAL, 4),

            new Note(Note.B, DUMMY_ACCIDENTAL, 3),   // 29
            new Note(Note.A, DUMMY_ACCIDENTAL, 3),
            new Note(Note.G, DUMMY_ACCIDENTAL, 3),
            new Note(Note.F, DUMMY_ACCIDENTAL, 3),
            new Note(Note.E, DUMMY_ACCIDENTAL, 3),
            new Note(Note.D, DUMMY_ACCIDENTAL, 3),
            new Note(Note.C, DUMMY_ACCIDENTAL, 3),

            new Note(Note.B, DUMMY_ACCIDENTAL, 2),   // 36
            new Note(Note.A, DUMMY_ACCIDENTAL, 2),
            new Note(Note.G, DUMMY_ACCIDENTAL, 2),
            new Note(Note.F, DUMMY_ACCIDENTAL, 2),
            new Note(Note.E, DUMMY_ACCIDENTAL, 2),
            new Note(Note.D, DUMMY_ACCIDENTAL, 2),
            new Note(Note.C, DUMMY_ACCIDENTAL, 2),

            new Note(Note.B, DUMMY_ACCIDENTAL, 1),   // 43
            new Note(Note.A, DUMMY_ACCIDENTAL, 1),
            new Note(Note.G, DUMMY_ACCIDENTAL, 1),
            new Note(Note.F, DUMMY_ACCIDENTAL, 1),
            new Note(Note.E, DUMMY_ACCIDENTAL, 1),
            new Note(Note.D, DUMMY_ACCIDENTAL, 1),
            new Note(Note.C, DUMMY_ACCIDENTAL, 1),

            new Note(Note.B, DUMMY_ACCIDENTAL, 0),   // 50
            new Note(Note.A, DUMMY_ACCIDENTAL, 0),
    };

    public HashMap<Note, Double> calcNoteCoordMapping(double topLineY, double distTweenLines, boolean isTreble) {
        // the topline is F5 for treble, and A3 for bass
        HashMap<Note, Double> map = new HashMap<>();
        double distTweenNotes = distTweenLines / 2;
        double distTweenTopLineAndC8;
        double C8Coord = calcC8_YCoord(IS_TREBLE, topLineY, distTweenNotes);
        double nextCoord = C8Coord;
        for (int i = 0; i < whiteNotes.length; i++) {
            map.put(whiteNotes[i], nextCoord);
            nextCoord = nextCoord + distTweenNotes;
        }
        return map;
    }

    private double calcC8_YCoord(boolean isTreble, double topLineY, double distTweenNotes) {
        if (isTreble) {
            return topLineY - (distTweenNotes * HALF_STEPS_TWEEN_F5_C8);
        } else {
            return topLineY - (distTweenNotes * HALF_STEPS_TWEEN_A3_C8);
        }
    }

}
