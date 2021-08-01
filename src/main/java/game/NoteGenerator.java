package game;

import global.NoteArray;
import notecontext.KeySignature;
import notecontext.NamedNote;

import java.util.*;

public class NoteGenerator {

    private final int C8 = NamedNote.C_8;
    private final int A0 = NamedNote.A_0;
    private int maxTreble;
    private int minTreble;
    private int maxBass;
    private int minBass;
    private HashMap<Integer, Integer> noteIDindices;
    private KeySignature keySig;
    private boolean includeFlats;
    private boolean includeNaturals;
    private boolean includeSharps;
    private boolean includeChromatics;
    private List<Integer> bassNotePool;
    private List<Integer> trebleNotePool;

    public NoteGenerator(Config config) {
        this.maxTreble = config.getMaxTreble();
        this.minTreble = config.getMinTreble();
        this.maxBass = config.getMaxBass();
        this.minBass = config.getMinBass();
        this.includeFlats = config.isIncludesFlat();
        this.includeNaturals = config.isIncludesNatural();
        this.includeSharps = config.isIncludesSharp();
        this.includeChromatics = config.isIncludesChromatic();
        this.noteIDindices = new HashMap<>();
        this.keySig = new KeySignature(config.getKeySignature());
        for (int i = 0; i < NoteArray.noteIDArray.length; i++) {
            noteIDindices.put(NoteArray.noteIDArray[i], i);
        }

        // filter pool of bass notes and treble notes
        bassNotePool = new ArrayList<>();
        trebleNotePool = new ArrayList<>();
        for (int i = 0; i < NoteArray.noteIDArray.length; i++) {
            int currNoteID = NoteArray.noteIDArray[i];
            boolean isBassIncluded = isIncluded(currNoteID, minBass, maxBass);
            if (isBassIncluded) {
                bassNotePool.add(currNoteID);
            }
            if (isIncluded(currNoteID, minTreble, maxTreble)) {
                trebleNotePool.add(currNoteID);
            }
        }

    }

    public NamedNote getRandomNamedNote() {
        NamedNote rtn = null;
        int min = 0;
        int max = 2;
        Random rand = new Random();
        int isTreble = rand.nextInt(max - min) + min;
        if (min <= 0) {
            rtn = getRandomTrebleNamedNote();
        } else if (min > 0) {
            rtn = getRandomBassNamedNote();
        }
        return rtn;
    }

    public NamedNote getRandomTrebleNamedNote() {
        return new NamedNote(getRandomTrebleNoteID());
    }

    public NamedNote getRandomBassNamedNote() {
        return new NamedNote(getRandomBassNoteID());
    }

    public int getRandomTrebleNoteID() {
        int min = 0;
        int max = trebleNotePool.size();
        int randIndex = new Random().nextInt(max - min) + min;
        int randNoteID = trebleNotePool.get(randIndex);
        return randNoteID;
    }

    public int getRandomBassNoteID() {
        int min = 0;
        int max = bassNotePool.size();
        int randIndex = new Random().nextInt(max - min) + min;
        int randNoteID = bassNotePool.get(randIndex);
        return randNoteID;
    }

    private boolean isIncluded(int noteID, int minNoteID, int maxNoteID) {
        boolean isFlat = true;
        boolean isSharp = true;
        boolean isNatural = true;
        boolean isChromatic = true;
        boolean isUnderMax = true;
        boolean isOverMin = true;
        NamedNote note = new NamedNote(noteID);
        if (includeFlats) {
            isFlat = note.getAccidental() == NamedNote.FLAT;
        }
        if (includeSharps) {
            isSharp = note.getAccidental() == NamedNote.SHARP;
        }
        if (includeNaturals) {
            isNatural = note.getAccidental() == NamedNote.NO_ACCIDENTAL;
        }
        if (includeChromatics) {
            isChromatic = keySig.isChromatic(noteID);
        }
        NamedNote thisNote = new NamedNote(noteID);
        NamedNote maxNote = new NamedNote(maxNoteID);
        NamedNote minNote = new NamedNote(minNoteID);
        isUnderMax = thisNote.compare(maxNote) <= 0;
        isOverMin = thisNote.compare(minNote) >= 0;
        return  isFlat &&
                isSharp &&
                isNatural &&
                isChromatic &&
                isOverMin &&
                isUnderMax;
    }

}
