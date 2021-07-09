package draw;

import java.util.HashMap;

/** manages mapping of MusicNotes to a Y coordinate. This will be used to draw or spawn a note on to the music sheet onscreen */
public class CoordManager {

    // separate mappings for treble and bass
    private HashMap<MusicNote, Double> trebleLineMapping;
    private HashMap<MusicNote, Double> bassLineMapping;
    private double lineSpacing;

    public CoordManager(double trebleTopLineY, double bassTopLineY, double lineSpacing) {
        trebleLineMapping = mapLineCoords(trebleTopLineY, lineSpacing, true);
        bassLineMapping = mapLineCoords(bassTopLineY, lineSpacing, false);
        this.lineSpacing = lineSpacing;
    }

    /** gets coordinate for the treble clef LINE, based on a MusicNote as a key.
     * a line is different from a note, since the root of the line is center, whereas the root of the note is top left */
    public double getYCoordOfTrebleLine(MusicNote note) {
        return trebleLineMapping.get(note);
    }

    /** gets coordinate for the bass clef LINE, based on a MusicNote as a key
     * a line is different from a note, since the root of the line is center, whereas the root of the note is top left */
    public double getYCoordOfBassLine(MusicNote note) {
        return bassLineMapping.get(note);
    }

    /** gets coordinate for the treble clef NOTE, based on a MusicNote as a key
     * a line is different from a note, since the root of the line is center, whereas the root of the note is top left */
    public double getYCoordOfTrebleNote(MusicNote note) {
        return trebleLineMapping.get(note) - (lineSpacing / 2);
    }

    /** gets coordinate for the bass clef NOTE, based on a MusicNote as a key
     * a line is different from a note, since the root of the line is center, whereas the root of the note is top left */
    public double getYCoordOfBassNote(MusicNote note) {
        return bassLineMapping.get(note) - (lineSpacing / 2);
    }

    private HashMap<MusicNote, Double> mapLineCoords(double topLineY, double lineSpacing, boolean isTreble) {
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


