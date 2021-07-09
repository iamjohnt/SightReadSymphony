package draw;

import java.util.HashMap;
import java.util.HashSet;

/** manages mapping of MusicNotes to a Y coordinate. This will be used to draw or spawn a note on to the music sheet onscreen */
public class CoordManager {

    // separate mappings for treble and bass
    private HashMap<MusicNote, Double> trebleMapping;
    private HashMap<MusicNote, Double> bassMapping;

    public CoordManager(double trebleTopLineY, double bassTopLineY, double lineSpacing) {
        trebleMapping = mapNoteAndYCoordinates(trebleTopLineY, lineSpacing, true);
        bassMapping = mapNoteAndYCoordinates(bassTopLineY, lineSpacing, false);
    }

    /** maps locations for all notes for treble clef, based on the top line's Y coordinate, and spacing between lines */
    public void mapTrebleNoteToCoord(double F5_Ycoordinate, double lineSpacing) {
        trebleMapping = mapNoteAndYCoordinates(F5_Ycoordinate, lineSpacing, true);
    }

    /** maps locations for all notes for bass clef, based on the top line's Y coordinate, and spacing between lines */
    public void mapBassNoteToCoord(double A3_Ycoordinate, double lineSpacing) {
        bassMapping = mapNoteAndYCoordinates(A3_Ycoordinate, lineSpacing, false);
    }

    /** gets coordinate for the treble clef, based on a MusicNote as a key */
    public double getTrebleYCoord(MusicNote note) {
        return trebleMapping.get(note);
    }

    /** gets coordinate for the bass clef, based on a MusicNote as a key */
    public double getBassYCoord(MusicNote note) {
        return bassMapping.get(note);
    }

    private HashMap<MusicNote, Double> mapNoteAndYCoordinates(double topLineY, double lineSpacing, boolean isTreble) {
        // the topline is F5 for treble, and A3 for bass
        HashMap<MusicNote, Double> map = new HashMap<>();
        double noteSpacing = lineSpacing / 2;
        double distTweenTopLineAndC8;
        if (isTreble) {
            distTweenTopLineAndC8 = noteSpacing * 18;
        } else {
            distTweenTopLineAndC8 = noteSpacing * 30;
        }
        double C8Coord = topLineY - distTweenTopLineAndC8;
        MusicNote[] whiteNotes = lineUpAllWhiteNotes();

        int whiteNoteLength = whiteNotes.length;
        double tempCoord = C8Coord;
        for (int i = 0; i < whiteNoteLength; i++) {
            map.put(whiteNotes[i], tempCoord);
            tempCoord += noteSpacing;
        }
        return map;
    }

    private MusicNote[] lineUpAllWhiteNotes() {
        final int DUMMY_ACCIDENTAL = 0;
        MusicNote[] whiteNotes = {
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 8),   // 0 index

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 7),   // 1
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 7),
                new MusicNote(draw.MusicNote.G, DUMMY_ACCIDENTAL, 7),
                new MusicNote(draw.MusicNote.F, DUMMY_ACCIDENTAL, 7),
                new MusicNote(draw.MusicNote.E, DUMMY_ACCIDENTAL, 7),
                new MusicNote(draw.MusicNote.D, DUMMY_ACCIDENTAL, 7),
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 7),

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 6),   // 8
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 6),
                new MusicNote(draw.MusicNote.G, DUMMY_ACCIDENTAL, 6),
                new MusicNote(draw.MusicNote.F, DUMMY_ACCIDENTAL, 6),
                new MusicNote(draw.MusicNote.E, DUMMY_ACCIDENTAL, 6),
                new MusicNote(draw.MusicNote.D, DUMMY_ACCIDENTAL, 6),
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 6),

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 5),   // 15
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 5),
                new MusicNote(draw.MusicNote.G, DUMMY_ACCIDENTAL, 5),
                new MusicNote(draw.MusicNote.F, DUMMY_ACCIDENTAL, 5),
                new MusicNote(draw.MusicNote.E, DUMMY_ACCIDENTAL, 5),
                new MusicNote(draw.MusicNote.D, DUMMY_ACCIDENTAL, 5),
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 5),

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 4),   // 22
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 4),
                new MusicNote(draw.MusicNote.G, DUMMY_ACCIDENTAL, 4),
                new MusicNote(draw.MusicNote.F, DUMMY_ACCIDENTAL, 4),
                new MusicNote(draw.MusicNote.E, DUMMY_ACCIDENTAL, 4),
                new MusicNote(draw.MusicNote.D, DUMMY_ACCIDENTAL, 4),
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 4),

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 3),   // 29
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 3),
                new MusicNote(draw.MusicNote.G, DUMMY_ACCIDENTAL, 3),
                new MusicNote(draw.MusicNote.F, DUMMY_ACCIDENTAL, 3),
                new MusicNote(draw.MusicNote.E, DUMMY_ACCIDENTAL, 3),
                new MusicNote(draw.MusicNote.D, DUMMY_ACCIDENTAL, 3),
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 3),

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 2),   // 36
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 2),
                new MusicNote(draw.MusicNote.G, DUMMY_ACCIDENTAL, 2),
                new MusicNote(draw.MusicNote.F, DUMMY_ACCIDENTAL, 2),
                new MusicNote(draw.MusicNote.E, DUMMY_ACCIDENTAL, 2),
                new MusicNote(draw.MusicNote.D, DUMMY_ACCIDENTAL, 2),
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 2),

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 1),   // 43
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 1),
                new MusicNote(draw.MusicNote.G, DUMMY_ACCIDENTAL, 1),
                new MusicNote(draw.MusicNote.F, DUMMY_ACCIDENTAL, 1),
                new MusicNote(draw.MusicNote.E, DUMMY_ACCIDENTAL, 1),
                new MusicNote(draw.MusicNote.D, DUMMY_ACCIDENTAL, 1),
                new MusicNote(draw.MusicNote.C, DUMMY_ACCIDENTAL, 1),

                new MusicNote(draw.MusicNote.B, DUMMY_ACCIDENTAL, 0),   // 50
                new MusicNote(draw.MusicNote.A, DUMMY_ACCIDENTAL, 0),
        };
        return whiteNotes;
    }
}


