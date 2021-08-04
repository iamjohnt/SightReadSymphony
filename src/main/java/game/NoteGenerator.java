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
    private boolean includeChromatics;
    private boolean includeNonChromatics;
    private List<Integer> bassNotePool;
    private List<Integer> trebleNotePool;

    public NoteGenerator(Config config) {
        this.maxTreble = config.getMaxTreble();
        this.minTreble = config.getMinTreble();
        this.maxBass = config.getMaxBass();
        this.minBass = config.getMinBass();
        this.includeChromatics = config.isIncludesChromatic();
        this.includeNonChromatics = config.isIncludesNonChromatic();
        this.noteIDindices = new HashMap<>();
        this.keySig = new KeySignature(config.getKeySigID());
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
        System.out.println("breakpoint");
    }

    public NamedNote getRandomNamedNote() {
        NamedNote rtn = null;
        int min = 0;
        int max = 2;
        Random rand = new Random();
        int isTreble = rand.nextInt(max - min) + min;
        if (isTreble <= 0) {
            rtn = getRandomTrebleNamedNote();
        } else if (isTreble > 0) {
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

    int debug;
    public boolean isIncluded(int noteID, int minNoteID, int maxNoteID) {
        if (includeChromatics && includeNonChromatics) {
            return false;
        }
        debug = noteID;
        boolean isChromatic = true;
        boolean isNonChromatic = true;
        boolean isUnderMax = true;
        boolean isOverMin = true;
        NamedNote note = new NamedNote(noteID);
        if (includeChromatics) {
            // check if actually chromatic. this will automatically weed out notes that are wrong accidental
            isChromatic = keySig.isChromatic(noteID);
        }

        if (includeNonChromatics) {
            // i need to also check if non chromatic, and if so, the accidental needs to be either that matching accidental
            isNonChromatic =
                    (!keySig.isChromatic(noteID) && (note.getAccidental() == keySig.getNonChromaticAccidental())) ||
                    (!keySig.isChromatic(noteID) && (note.getAccidental() == KeySignature.NATL));
        }

        NamedNote thisNote = new NamedNote(noteID);
        NamedNote maxNote = new NamedNote(maxNoteID);
        NamedNote minNote = new NamedNote(minNoteID);
        isUnderMax = thisNote.compare(maxNote) <= 0;
        isOverMin = thisNote.compare(minNote) >= 0;
        return  isChromatic &&
                isNonChromatic &&
                isOverMin &&
                isUnderMax;
    }

    public static void main(String[] args) {
        Config config = new Config();
        config.setMaxTreble(NamedNote.C_8);
        config.setMinTreble(NamedNote.A_0);
        config.setMaxBass(NamedNote.C_8);
        config.setMinBass(NamedNote.A_0);
        config.setKeySigID(KeySignature.G_MAJOR_ID);
        config.setIncludesNonChromatic(true);
        config.setIncludesChromatic(false);
        NoteGenerator gen = new NoteGenerator(config);
        System.out.println(gen.isIncluded(NamedNote.F_SHARP_2, NamedNote.A_0, NamedNote.C_8));
        System.out.println(gen.isIncluded(NamedNote.F_2, NamedNote.A_0, NamedNote.C_8));
        System.out.println(gen.isIncluded(NamedNote.A_FLAT_2, NamedNote.A_0, NamedNote.C_8));
    }

}
