package note_coordinate;

public class NoteContext {

    private Clef bass;
    private Clef treble;
    private KeySignature keySig;

    public NoteContext(KeySignature keySig, Clef trebleClef, Clef bassClef) {
        this.keySig = keySig;
        this.treble = trebleClef;
        this.bass = bassClef;
    }

    public NamedNote getTrebleNote(int noteID) {
        return new NamedNote(noteID);
    }

    public NamedNote getBassNote(int noteID) {
        return new NamedNote(noteID);
    }

    public double getTrebleNoteY(int noteID) {
        return treble.getNoteY(noteID);
    }

    public double getTrebleLineY(int noteID) {
        return treble.getLineY(noteID);
    }

    public double getBassNoteY(int noteID) {
        return bass.getNoteY(noteID);
    }

    public double getBassLineY(int noteID) {
        return bass.getLineY(noteID);
    }

    public boolean isNoteChromatic(int noteID) {
        NamedNote note = new NamedNote(noteID);
        return keySig.isChromatic(note.getNoteLetter(), note.getAccidental());
    }

    public boolean isTrebleNoteAboveOttava(int noteID) {
        return false;
    }

    public boolean isBassNoteBelowOttava(int noteID) {
        return false;
    }


}
