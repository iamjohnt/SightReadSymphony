package note_coordinate;

import java.util.HashMap;

public class Clef {

    // static "enums"
    public static boolean IS_TREBLE = true;
    public static boolean IS_BASS = false;

    // constructor fields
    private double x;
    private double y;
    private double width;
    private double height;
    private boolean clefType;

    // other fields
    private double distTweenLines;
    private double distTweenNotes;
    private String clefSymbolImagePath;
    private int firstOttavaNoteAbove;
    private int firstOttaveNoteBelow;

    // mapping
    HashMap<Note, Double> noteCoords = null;

    public Clef(double x, double y, double width, double height, boolean clefType) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.clefType = clefType;
        distTweenLines = height / 4;
        distTweenNotes = distTweenLines / 2;
        CoordinateMapper mapper = new CoordinateMapper();
        noteCoords = mapper.calcNoteCoordMapping(this.y, this.distTweenLines, this.clefType);
    }

    public void setFirstOttavaNoteAbove(int firstOttavaNoteAbove) {
        this.firstOttavaNoteAbove = firstOttavaNoteAbove;
    }

    public void setFirstOttaveNoteBelow(int firstOttaveNoteBelow) {
        this.firstOttaveNoteBelow = firstOttaveNoteBelow;
    }

}
