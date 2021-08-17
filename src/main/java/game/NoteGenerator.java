package game;

import util.MusicUtil;
import notecontext.KeySignature;
import notecontext.NamedNote;

import java.util.*;

/** Overview -  generates random notes, within certain bounds
 * UseCase - spawner can spawn random notes, by using this class */
public class NoteGenerator {

    private final int C8 = NamedNote.C_8;
    private final int A0 = NamedNote.A_0;
    private int maxTreble;
    private int minTreble;
    private int maxBass;
    private int minBass;
    private int overallMin;
    private int overallMax;
    private KeySignature keySig;
    private boolean includeChromatics;
    private boolean includeNonChromatics;
    private List<Integer> bassNotePool;
    private List<Integer> trebleNotePool;

    /** constructs NoteGenerator based on config object argument. The bounds within the config object, will determine what will be generated */
    public NoteGenerator(Config config) {
        // loads necessary info from the config object
        this.maxTreble = config.getMaxTreble();
        this.minTreble = config.getMinTreble();
        this.maxBass = config.getMaxBass();
        this.minBass = config.getMinBass();
        this.overallMin = config.getOverallMin();
        this.overallMax = config.getOverallMax();
        this.includeChromatics = config.isIncludesChromatic();
        this.includeNonChromatics = config.isIncludesNonChromatic();
        this.keySig = new KeySignature(config.getKeySigID());

        // determine the pool of bass notes, and the pool of treble notes, that we can generate from
        bassNotePool = new ArrayList<>();
        trebleNotePool = new ArrayList<>();
        NamedNote[] namedNoteArray = MusicUtil.getAllNamedNotesAsArray();
        for (int i = 0; i < namedNoteArray.length; i++) {
            int currNoteID = namedNoteArray[i].getId();
            boolean isBassIncluded = isIncluded(currNoteID, overallMin, overallMax);
            if (isBassIncluded) {
                bassNotePool.add(currNoteID);
            }
            if (isIncluded(currNoteID, overallMin, overallMax)) {
                trebleNotePool.add(currNoteID);
            }
        }
        System.out.println("breakpoint");
    }

    /** gets a random NamedNote, based on the bounds from the config object that was passed to the NoteGenerator */
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

    private NamedNote getRandomTrebleNamedNote() {
        int min = 0;
        int max = trebleNotePool.size();
        int randIndex = new Random().nextInt(max - min) + min;
        int randNoteID = trebleNotePool.get(randIndex);
        return new NamedNote(randNoteID);
    }

    private NamedNote getRandomBassNamedNote() {
        int min = 0;
        int max = bassNotePool.size();
        int randIndex = new Random().nextInt(max - min) + min;
        int randNoteID = bassNotePool.get(randIndex);
        return new NamedNote(randNoteID);
    }

    /** check if a particular note is included based on the config */
    private boolean isIncluded(int noteID, int minNoteID, int maxNoteID) {
        if (includeChromatics == false && includeNonChromatics == false) {
            return false;
        }
        boolean isChromatic = true;
        boolean isNonChromatic = true;
        boolean isUnderMax = true;
        boolean isOverMin = true;
        boolean isSameKeySig = true;
        NamedNote note = new NamedNote(noteID);
        isSameKeySig = note.getAccidental() == keySig.getKeySignatureAccidental() || note.getAccidental() == KeySignature.NATL;
        if (includeNonChromatics && includeChromatics) {
            isChromatic = true;
            isNonChromatic = true;
        } else {
            if (includeChromatics) {
                // check if actually chromatic. this will automatically weed out notes that are wrong accidental
                isChromatic = keySig.isChromatic(noteID);
            }

            if (includeNonChromatics) {
                // i need to also check if non chromatic, and if so, the accidental needs to be either that matching accidental
                int debugKeySigAcc = keySig.getKeySignatureAccidental();
                boolean debugIsChromatic = keySig.isChromatic(noteID);
                int debugNoteID = noteID;
                isNonChromatic =
                        (!keySig.isChromatic(noteID) && (note.getAccidental() == keySig.getKeySignatureAccidental())) ||
                        (!keySig.isChromatic(noteID) && (note.getAccidental() == KeySignature.NATL));
            }
        }

        NamedNote thisNote = new NamedNote(noteID);
        NamedNote maxNote = new NamedNote(maxNoteID);
        NamedNote minNote = new NamedNote(minNoteID);
        isUnderMax = thisNote.compare(maxNote) <= 0;
        isOverMin = thisNote.compare(minNote) >= 0;
        return  isChromatic &&
                isNonChromatic &&
                isOverMin &&
                isUnderMax &&
                isSameKeySig;
    }

}
