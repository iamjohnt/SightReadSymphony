package notecontext;

import game.Config;

/** Overview - offers information about context of the note, or key signature
 * UseCase - will be instantiated within GameSession, where it can query this when needed */
public class NoteContext {

    private Clef bass;
    private Clef treble;
    private KeySignature keySig;

    /** constructrs NoteContext based on config object */
    public NoteContext(Config config) {
        this.keySig = new KeySignature(config.getKeySigID());
        this.treble = new Clef(Clef.IS_TREBLE, config.getTrebleClefY(), config.getTrebleClefLineHeight());
        this.bass = new Clef(Clef.IS_BASS, config.getBassClefY(), config.getBassClefLineHeight());
    }

    /** gets the y location of a treble note */
    public double getTrebleNoteY(int noteID) {
        return treble.getNoteY(noteID);
    }

    /** gets the y location of a treble note's line*/
    public double getTrebleLineY(int noteID) {
        return treble.getLineY(noteID);
    }

    /** gets the y location of a base note */
    public double getBassNoteY(int noteID) {
        return bass.getNoteY(noteID);
    }

    /** gets the y location of a bass note's line */
    public double getBassLineY(int noteID) {
        return bass.getLineY(noteID);
    }

    /** determines if a note is chromatic on the current key signature */
    public boolean isNoteChromatic(int noteID) {
        NamedNote note = new NamedNote(noteID);
        return keySig.isChromatic(note.getId());
    }

    /** gets the accidental of the current key signature */
    public int getKeySigAccidental() {
        return this.keySig.getKeySignatureAccidental();
    }

    /** gets the id of the current key signature */
    public int getKeySigID() {
        return this.keySig.getKeySigID();
    }

}
