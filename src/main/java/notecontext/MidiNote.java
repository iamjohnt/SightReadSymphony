package notecontext;

public class MidiNote {

    public static final int A_0 = 211;
    public static final int A_SHARP_0 = 222;
    public static final int B_FLAT_0 = 220;
    public static final int B_0 = 231;

    public static final int C_1 = 241;
    public static final int C_SHARP_1 = 252;
    public static final int D_FLAT_1 = 250;
    public static final int D_1 = 261;
    public static final int D_SHARP_1 = 272;
    public static final int E_FLAT_1 = 271;
    public static final int E_1 = 281;
    public static final int F_1 = 291;
    public static final int F_SHARP_1 = 302;
    public static final int G_FLAT_1 = 301;
    public static final int G_1 = 311;
    public static final int G_SHARP_1 = 322;
    public static final int A_FLAT_1 = 320;
    public static final int A_1 = 331;
    public static final int A_SHARP_1 = 342;
    public static final int B_FLAT_1 = 340;
    public static final int B_1 = 351;

    public static final int C_2 = 361;
    public static final int C_SHARP_2 = 372;
    public static final int D_FLAT_2 = 370;
    public static final int D_2 = 381;
    public static final int D_SHARP_2 = 392;
    public static final int E_FLAT_2 = 390;
    public static final int E_2 = 401;
    public static final int F_2 = 411;
    public static final int F_SHARP_2 = 422;
    public static final int G_FLAT_2 = 420;
    public static final int G_2 = 431;
    public static final int G_SHARP_2 = 442;
    public static final int A_FLAT_2 = 440;
    public static final int A_2 = 451;
    public static final int A_SHARP_2 = 462;
    public static final int B_FLAT_2 = 460;
    public static final int B_2 = 471;

    public static final int C_3 = 481;
    public static final int C_SHARP_3 = 492;
    public static final int D_FLAT_3 = 490;
    public static final int D_3 = 501;
    public static final int D_SHARP_3 = 512;
    public static final int E_FLAT_3 = 510;
    public static final int E_3 = 521;
    public static final int F_3 = 531;
    public static final int F_SHARP_3 = 542;
    public static final int G_FLAT_3 = 540;
    public static final int G_3 = 551;
    public static final int G_SHARP_3 = 562;
    public static final int A_FLAT_3 = 560;
    public static final int A_3 = 571;
    public static final int A_SHARP_3 = 582;
    public static final int B_FLAT_3 = 580;
    public static final int B_3 = 591;

    public static final int C_4 = 601;
    public static final int C_SHARP_4 = 612;
    public static final int D_FLAT_4 = 610;
    public static final int D_4 = 621;
    public static final int D_SHARP_4 = 632;
    public static final int E_FLAT_4 = 630;
    public static final int E_4 = 641;
    public static final int F_4 = 651;
    public static final int F_SHARP_4 = 662;
    public static final int G_FLAT_4 = 660;
    public static final int G_4 = 671;
    public static final int G_SHARP_4 = 682;
    public static final int A_FLAT_4 = 680;
    public static final int A_4 = 691;
    public static final int A_SHARP_4 = 702;
    public static final int B_FLAT_4 = 700;
    public static final int B_4 = 711;

    public static final int C_5 = 721;
    public static final int C_SHARP_5 = 732;
    public static final int D_FLAT_5 = 730;
    public static final int D_5 = 741;
    public static final int D_SHARP_5 = 752;
    public static final int E_FLAT_5 = 750;
    public static final int E_5 = 761;
    public static final int F_5 = 771;
    public static final int F_SHARP_5 = 782;
    public static final int G_FLAT_5 = 780;
    public static final int G_5 = 791;
    public static final int G_SHARP_5 = 802;
    public static final int A_FLAT_5 = 800;
    public static final int A_5 = 811;
    public static final int A_SHARP_5 = 822;
    public static final int B_FLAT_5 = 820;
    public static final int B_5 = 831;

    public static final int C_6 = 841;
    public static final int C_SHARP_6 = 852;
    public static final int D_FLAT_6 = 850;
    public static final int D_6 = 861;
    public static final int D_SHARP_6 = 872;
    public static final int E_FLAT_6 = 870;
    public static final int E_6 = 881;
    public static final int F_6 = 891;
    public static final int F_SHARP_6 = 902;
    public static final int G_FLAT_6 = 900;
    public static final int G_6 = 911;
    public static final int G_SHARP_6 = 922;
    public static final int A_FLAT_6 = 920;
    public static final int A_6 = 931;
    public static final int A_SHARP_6 = 942;
    public static final int B_FLAT_6 = 940;
    public static final int B_6 = 951;

    public static final int C_7 = 961;
    public static final int C_SHARP_7 = 972;
    public static final int D_FLAT_7 = 970;
    public static final int D_7 = 981;
    public static final int D_SHARP_7 = 992;
    public static final int E_FLAT_7 = 990;
    public static final int E_7 = 1001;
    public static final int F_7 = 1011;
    public static final int F_SHARP_7 = 1022;
    public static final int G_FLAT_7 = 1020;
    public static final int G_7 = 1031;
    public static final int G_SHARP_7 = 1042;
    public static final int A_FLAT_7 = 1040;
    public static final int A_7 = 1051;
    public static final int A_SHARP_7 = 1062;
    public static final int B_FLAT_7 = 1060;
    public static final int B_7 = 1071;

    public static final int C_8 = 1081;

    public static final int FLAT = 0;
    public static final int NO_ACCIDENTAL = 1;
    public static final int SHARP = 2;
    private int id;
    private int midiValue;
    private int requestedAccidental;
    private MidiAndNoteBimap mapper;

    public MidiNote(int midiValue, int requestedAccidental) {
        this.midiValue = midiValue;
        this.requestedAccidental = requestedAccidental;
        this.id = midiValue * 10 + requestedAccidental;
    }

    public MidiNote(int midiID) {
        this.id = midiID;
        this.midiValue = midiID / 10;               // drops right digit
        this.requestedAccidental = midiID % 10;     // isolates right digit
    }

    public NamedNote toNamedNote() {
        mapper = new MidiAndNoteBimap();
        int noteID = mapper.getNoteIDWithMidiID(this.id);
        return new NamedNote(noteID);
    }

    public NamedNote toNamedNoteV2(int requestedAccidental) {
        int note = getNote(this.midiValue, requestedAccidental);
        int accidental = getAccidental(this.midiValue, requestedAccidental);
        int octave = getOctave(this.midiValue, requestedAccidental);
        return new NamedNote(note, accidental, octave);
    }

    private int getNote(int midi, int requestedAccidental) {
        int[] octaveNotePatternWhenSharp = new int[]{
                NamedNote.A,
                NamedNote.A,
                NamedNote.B,
                NamedNote.C,
                NamedNote.C,
                NamedNote.D,
                NamedNote.D,
                NamedNote.E,
                NamedNote.F,
                NamedNote.F,
                NamedNote.G,
                NamedNote.G
        };
        int index = (midi - 21) % 12;
        int tempNote = octaveNotePatternWhenSharp[index];
        if (isBlackKey(midi) && requestedAccidental == MidiNote.FLAT) {
            tempNote = (tempNote + 1) % 7;
        }
        return tempNote;
    }

    private int getOctave(int midi, int requestedAccidental) {
        int count = 0;
        int curr = midi;
        while (curr > 23) {
            curr -= 12;
            count++;
        }
        int note = getNote(midi, requestedAccidental);
        return count;
    }


    private int getAccidental(int midi, int requestedAccidental) {
        if (isBlackKey(midi)) {
            return requestedAccidental;
        } else {
            return MidiNote.NO_ACCIDENTAL;
        }
    }

    private boolean isBlackKey(int midi) {
        int index = (midi - 21) % 12;
        return index == 1 || index == 4 || index == 6 || index == 9 || index == 11;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public int getMidiValue() {
        return midiValue;
    }

    public int getRequestedAccidental() {
        return requestedAccidental;
    }
}
