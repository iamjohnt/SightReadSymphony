package notecontext;

import java.util.HashMap;

public class MidiAndNoteBimap {

    private int[] midiIDArray;
    private int[] noteIDArray;
    private HashMap<Integer, Integer> midiToSharpNote = new HashMap<>();
    private HashMap<Integer, Integer> midiToFlatNote = new HashMap<>();
    private HashMap<Integer, Integer> noteToMidi = new HashMap<>();

    public MidiAndNoteBimap() {
        initMidiArray();
        initNoteArray();
        mapBothWays();
    }

    public int getNoteIDWithMidiID(int midiID) {
        return midiToFlatNote.get(midiID);
    }

    public int getMidiIDWithNoteID(int noteID) {
        return noteToMidi.get(noteID);
    }

    private void mapBothWays() {
        for (int i = 0; i < midiIDArray.length; i++) {
            midiToFlatNote.put(midiIDArray[i], noteIDArray[i]);
            noteToMidi.put(noteIDArray[i], midiIDArray[i]);
        }
    }

    public void initMidiArray() {
        midiIDArray = new int[]{
            MidiNote.A_0,
            MidiNote.A_SHARP_0,
            MidiNote.B_FLAT_0,
            MidiNote.B_0,
    
            MidiNote.C_1,
            MidiNote.C_SHARP_1,
            MidiNote.D_FLAT_1,
            MidiNote.D_1,
            MidiNote.D_SHARP_1,
            MidiNote.E_FLAT_1,
            MidiNote.E_1,
            MidiNote.F_1,
            MidiNote.F_SHARP_1,
            MidiNote.G_FLAT_1,
            MidiNote.G_1,
            MidiNote.G_SHARP_1,
            MidiNote.A_FLAT_1,
            MidiNote.A_1,
            MidiNote.A_SHARP_1,
            MidiNote.B_FLAT_1,
            MidiNote.B_1,
    
            MidiNote.C_2,
            MidiNote.C_SHARP_2,
            MidiNote.D_FLAT_2,
            MidiNote.D_2,
            MidiNote.D_SHARP_2,
            MidiNote.E_FLAT_2,
            MidiNote.E_2,
            MidiNote.F_2,
            MidiNote.F_SHARP_2,
            MidiNote.G_FLAT_2,
            MidiNote.G_2,
            MidiNote.G_SHARP_2,
            MidiNote.A_FLAT_2,
            MidiNote.A_2,
            MidiNote.A_SHARP_2,
            MidiNote.B_FLAT_2,
            MidiNote.B_2,
    
            MidiNote.C_3,
            MidiNote.C_SHARP_3,
            MidiNote.D_FLAT_3,
            MidiNote.D_3,
            MidiNote.D_SHARP_3,
            MidiNote.E_FLAT_3,
            MidiNote.E_3,
            MidiNote.F_3,
            MidiNote.F_SHARP_3,
            MidiNote.G_FLAT_3,
            MidiNote.G_3,
            MidiNote.G_SHARP_3,
            MidiNote.A_FLAT_3,
            MidiNote.A_3,
            MidiNote.A_SHARP_3,
            MidiNote.B_FLAT_3,
            MidiNote.B_3,
    
            MidiNote.C_4,
            MidiNote.C_SHARP_4,
            MidiNote.D_FLAT_4,
            MidiNote.D_4,
            MidiNote.D_SHARP_4,
            MidiNote.E_FLAT_4,
            MidiNote.E_4,
            MidiNote.F_4,
            MidiNote.F_SHARP_4,
            MidiNote.G_FLAT_4,
            MidiNote.G_4,
            MidiNote.G_SHARP_4,
            MidiNote.A_FLAT_4,
            MidiNote.A_4,
            MidiNote.A_SHARP_4,
            MidiNote.B_FLAT_4,
            MidiNote.B_4,
    
            MidiNote.C_5,
            MidiNote.C_SHARP_5,
            MidiNote.D_FLAT_5,
            MidiNote.D_5,
            MidiNote.D_SHARP_5,
            MidiNote.E_FLAT_5,
            MidiNote.E_5,
            MidiNote.F_5,
            MidiNote.F_SHARP_5,
            MidiNote.G_FLAT_5,
            MidiNote.G_5,
            MidiNote.G_SHARP_5,
            MidiNote.A_FLAT_5,
            MidiNote.A_5,
            MidiNote.A_SHARP_5,
            MidiNote.B_FLAT_5,
            MidiNote.B_5,
    
            MidiNote.C_6,
            MidiNote.C_SHARP_6,
            MidiNote.D_FLAT_6,
            MidiNote.D_6,
            MidiNote.D_SHARP_6,
            MidiNote.E_FLAT_6,
            MidiNote.E_6,
            MidiNote.F_6,
            MidiNote.F_SHARP_6,
            MidiNote.G_FLAT_6,
            MidiNote.G_6,
            MidiNote.G_SHARP_6,
            MidiNote.A_FLAT_6,
            MidiNote.A_6,
            MidiNote.A_SHARP_6,
            MidiNote.B_FLAT_6,
            MidiNote.B_6,
    
            MidiNote.C_7,
            MidiNote.C_SHARP_7,
            MidiNote.D_FLAT_7,
            MidiNote.D_7,
            MidiNote.D_SHARP_7,
            MidiNote.E_FLAT_7,
            MidiNote.E_7,
            MidiNote.F_7,
            MidiNote.F_SHARP_7,
            MidiNote.G_FLAT_7,
            MidiNote.G_7,
            MidiNote.G_SHARP_7,
            MidiNote.A_FLAT_7,
            MidiNote.A_7,
            MidiNote.A_SHARP_7,
            MidiNote.B_FLAT_7,
            MidiNote.B_7,
    
            MidiNote.C_8
        };
    }

    private void initNoteArray() {
        noteIDArray = new int[]{
            NamedNote.A_0,
            NamedNote.A_SHARP_0,
            NamedNote.B_FLAT_0,
            NamedNote.B_0,

            NamedNote.C_1,
            NamedNote.C_SHARP_1,
            NamedNote.D_FLAT_1,
            NamedNote.D_1,
            NamedNote.D_SHARP_1,
            NamedNote.E_FLAT_1,
            NamedNote.E_1,
            NamedNote.F_1,
            NamedNote.F_SHARP_1,
            NamedNote.G_FLAT_1,
            NamedNote.G_1,
            NamedNote.G_SHARP_1,
            NamedNote.A_FLAT_1,
            NamedNote.A_1,
            NamedNote.A_SHARP_1,
            NamedNote.B_FLAT_1,
            NamedNote.B_1,

            NamedNote.C_2,
            NamedNote.C_SHARP_2,
            NamedNote.D_FLAT_2,
            NamedNote.D_2,
            NamedNote.D_SHARP_2,
            NamedNote.E_FLAT_2,
            NamedNote.E_2,
            NamedNote.F_2,
            NamedNote.F_SHARP_2,
            NamedNote.G_FLAT_2,
            NamedNote.G_2,
            NamedNote.G_SHARP_2,
            NamedNote.A_FLAT_2,
            NamedNote.A_2,
            NamedNote.A_SHARP_2,
            NamedNote.B_FLAT_2,
            NamedNote.B_2,

            NamedNote.C_3,
            NamedNote.C_SHARP_3,
            NamedNote.D_FLAT_3,
            NamedNote.D_3,
            NamedNote.D_SHARP_3,
            NamedNote.E_FLAT_3,
            NamedNote.E_3,
            NamedNote.F_3,
            NamedNote.F_SHARP_3,
            NamedNote.G_FLAT_3,
            NamedNote.G_3,
            NamedNote.G_SHARP_3,
            NamedNote.A_FLAT_3,
            NamedNote.A_3,
            NamedNote.A_SHARP_3,
            NamedNote.B_FLAT_3,
            NamedNote.B_3,

            NamedNote.C_4,
            NamedNote.C_SHARP_4,
            NamedNote.D_FLAT_4,
            NamedNote.D_4,
            NamedNote.D_SHARP_4,
            NamedNote.E_FLAT_4,
            NamedNote.E_4,
            NamedNote.F_4,
            NamedNote.F_SHARP_4,
            NamedNote.G_FLAT_4,
            NamedNote.G_4,
            NamedNote.G_SHARP_4,
            NamedNote.A_FLAT_4,
            NamedNote.A_4,
            NamedNote.A_SHARP_4,
            NamedNote.B_FLAT_4,
            NamedNote.B_4,

            NamedNote.C_5,
            NamedNote.C_SHARP_5,
            NamedNote.D_FLAT_5,
            NamedNote.D_5,
            NamedNote.D_SHARP_5,
            NamedNote.E_FLAT_5,
            NamedNote.E_5,
            NamedNote.F_5,
            NamedNote.F_SHARP_5,
            NamedNote.G_FLAT_5,
            NamedNote.G_5,
            NamedNote.G_SHARP_5,
            NamedNote.A_FLAT_5,
            NamedNote.A_5,
            NamedNote.A_SHARP_5,
            NamedNote.B_FLAT_5,
            NamedNote.B_5,

            NamedNote.C_6,
            NamedNote.C_SHARP_6,
            NamedNote.D_FLAT_6,
            NamedNote.D_6,
            NamedNote.D_SHARP_6,
            NamedNote.E_FLAT_6,
            NamedNote.E_6,
            NamedNote.F_6,
            NamedNote.F_SHARP_6,
            NamedNote.G_FLAT_6,
            NamedNote.G_6,
            NamedNote.G_SHARP_6,
            NamedNote.A_FLAT_6,
            NamedNote.A_6,
            NamedNote.A_SHARP_6,
            NamedNote.B_FLAT_6,
            NamedNote.B_6,

            NamedNote.C_7,
            NamedNote.C_SHARP_7,
            NamedNote.D_FLAT_7,
            NamedNote.D_7,
            NamedNote.D_SHARP_7,
            NamedNote.E_FLAT_7,
            NamedNote.E_7,
            NamedNote.F_7,
            NamedNote.F_SHARP_7,
            NamedNote.G_FLAT_7,
            NamedNote.G_7,
            NamedNote.G_SHARP_7,
            NamedNote.A_FLAT_7,
            NamedNote.A_7,
            NamedNote.A_SHARP_7,
            NamedNote.B_FLAT_7,
            NamedNote.B_7,

            NamedNote.C_8
        };
    }

}
