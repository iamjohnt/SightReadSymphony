package notecontext;

import logic.Config;

public class NoteContext {

    private Clef bass;
    private Clef treble;
    private KeySignature keySig;

    public NoteContext(Config config) {
        this.keySig = new KeySignature(config.getKeySignature());
        this.treble = new Clef(Clef.IS_TREBLE, config.getTrebleClefY(), config.getTrebleClefLineHeight());
        this.bass = new Clef(Clef.IS_BASS, config.getBassClefY(), config.getBassClefLineHeight());
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
        return keySig.isChromatic(note.getId());
    }

    public boolean isTrebleNoteAboveOttava(int noteID) {
        return false;
    }

    public boolean isBassNoteBelowOttava(int noteID) {
        return false;
    }


}
