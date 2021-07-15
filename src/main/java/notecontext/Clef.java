package note_coordinate;

import java.util.HashMap;

public class Clef {

    public static final boolean IS_TREBLE = true;
    public static final boolean IS_BASS = false;
    private static final int HALF_STEPS_TWEEN_F5_C8 = 18;
    private static final int HALF_STEPS_TWEEN_A3_C8 = 30;
    private int topOttavaNoteID;
    private int bottomOttavaNoteID;
    private KeySignature keySignature;
    private HashMap<Integer, Double> noteToCoord;
    private HashMap<Integer, Double> lineToCoord;

    private int[] whiteNotes = {
            NamedNote.C_8,   // 0 index

            NamedNote.B_7,   // 1
            NamedNote.A_7,
            NamedNote.G_7,
            NamedNote.F_7,
            NamedNote.E_7,
            NamedNote.D_7,
            NamedNote.C_7,

            NamedNote.B_6,   // 8
            NamedNote.A_6,
            NamedNote.G_6,
            NamedNote.F_6,
            NamedNote.E_6,
            NamedNote.D_6,
            NamedNote.C_6,

            NamedNote.B_5,   // 15
            NamedNote.A_5,
            NamedNote.G_5,
            NamedNote.F_5,
            NamedNote.E_5,
            NamedNote.D_5,
            NamedNote.C_5,

            NamedNote.B_4,   // 22
            NamedNote.A_4,
            NamedNote.G_4,
            NamedNote.F_4,
            NamedNote.E_4,
            NamedNote.D_4,
            NamedNote.C_4,

            NamedNote.B_3,   // 29
            NamedNote.A_3,
            NamedNote.G_3,
            NamedNote.F_3,
            NamedNote.E_3,
            NamedNote.D_3,
            NamedNote.C_3,

            NamedNote.B_2,   // 36
            NamedNote.A_2,
            NamedNote.G_2,
            NamedNote.F_2,
            NamedNote.E_2,
            NamedNote.D_2,
            NamedNote.C_2,

            NamedNote.B_1,   // 43
            NamedNote.A_1,
            NamedNote.G_1,
            NamedNote.F_1,
            NamedNote.E_1,
            NamedNote.D_1,
            NamedNote.C_1,

            NamedNote.B_0,   // 50
            NamedNote.A_0,
    };

    public Clef(boolean isTreble, double topLineY, double distTweenLines) {
        lineToCoord = calcLineCoordMap(isTreble, topLineY, distTweenLines);
        noteToCoord = calcNoteCoordMap(isTreble, topLineY, distTweenLines);
    }

    public double getLineY(int noteID) {
        return lineToCoord.get(noteID);
    }

    public double getNoteY(int noteID) {
        return noteToCoord.get(noteID);
    }

    private HashMap<Integer, Double> calcLineCoordMap(boolean isTreble, double topLineY, double distTweenLines) {
        // the topline is F5 for treble, and A3 for bass
        HashMap<Integer, Double> map = new HashMap<>();
        double distTweenNotes = distTweenLines / 2;
        double C8Coord = calcC8_YCoord(isTreble, topLineY, distTweenNotes);
        double nextCoord = C8Coord;
        for (int i = 0; i < whiteNotes.length; i++) {
            map.put(whiteNotes[i], nextCoord);
            nextCoord = nextCoord + distTweenNotes;
        }
        return map;
    }

    private HashMap<Integer, Double> calcNoteCoordMap(boolean isTreble, double topLineY, double distTweenLines) {
        // the topline is F5 for treble, and A3 for bass
        HashMap<Integer, Double> map = new HashMap<>();
        double distTweenNotes = distTweenLines / 2;
        double C8Coord = calcC8_YCoord(isTreble, topLineY, distTweenNotes);
        double nextCoord = C8Coord;
        double halfStep = distTweenNotes;
        for (int i = 0; i < whiteNotes.length; i++) {
            map.put(whiteNotes[i], nextCoord - halfStep);
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
