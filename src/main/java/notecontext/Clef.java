package notecontext;

import java.util.HashMap;

/** Overview - represents either the treble, or bass clef.
 * Purpose - to determine where on the Y axis of the clef, of a certain note, such as C-4, should be placed.
 * Utilization - 2 of these will be instantiated within NoteContext, one treble and one bass.
 * you won't ask Clef directly for the note location, you would call NoteContext methods, which internally call Clef methods
 * FYI - location of note is slightly above location of a line - since a note's image is at the top left, and the line is at the center */
public class Clef {

    public static final boolean IS_TREBLE = true;
    public static final boolean IS_BASS = false;
    private static final int HALF_STEPS_TWEEN_F5_C8 = 18;
    private static final int HALF_STEPS_TWEEN_A3_C8 = 30;
    private HashMap<Integer, Double> noteToCoord;
    private HashMap<Integer, Double> lineToCoord;

    // the notes on the clef lines and spaces are identified by note letters and octaves only - no octaves. so we need a list of white notes here.
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

    /** constructs a treble or bass clef. it's location and scale on screen is calculated from y location, and lineHeight argument*/
    public Clef(boolean isTreble, double topLineY, double distTweenLines) {
        lineToCoord = calcLineCoordMap(isTreble, topLineY, distTweenLines);
        noteToCoord = calcNoteCoordMap(isTreble, topLineY, distTweenLines);
    }

    /** gets the location of the line of a note */
    public double getLineY(int noteID) {
        int idWithoutAccidental = removeAccidentalFromNoteID(noteID);
        return lineToCoord.get(idWithoutAccidental);
    }

    /** gets the y location of the top left of a note (note images's root are at the top left) */
    public double getNoteY(int noteID) {
        int idWithoutAccidental = removeAccidentalFromNoteID(noteID);
        return noteToCoord.get(idWithoutAccidental);
    }

    // removes accidental of any incoming note, so you can identify where it is (note locations ignore note accidentals)
    private int removeAccidentalFromNoteID(int noteID) {
        int noteLetter = NamedNote.extractNoteLetter(noteID);
        int octave = NamedNote.extractOctave(noteID);
        int natural = 1;
        int idWithoutAccidental = NamedNote.buildNoteID(noteLetter, natural, octave);
        return idWithoutAccidental;
    }

    // initializes map of notes to their y locations
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

    // initializes map of notes to their y locations
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

    // determines the starting location of the highest note in the clef, which is C8.
    // the reset of the notes are calculated down from this location
    private double calcC8_YCoord(boolean isTreble, double topLineY, double distTweenNotes) {
        if (isTreble) {
            return topLineY - (distTweenNotes * HALF_STEPS_TWEEN_F5_C8);
        } else {
            return topLineY - (distTweenNotes * HALF_STEPS_TWEEN_A3_C8);
        }
    }

}
