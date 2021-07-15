package note_coordinate;

/** Contains variables named as specific notes, that each map to a unique 3 digit integer.
 * Each digit position represents an attribute of the note.<br/>
 *
 * --- First digit = Octave (ranged 0 - 8)<br/>
 * --- Second digit = Note (ranged 0 - 6, where A is 0 and B is 6)<br/>
 * --- Third digit = Accidental (ranged 0 - 2, where 0 is Flat, 1 is NONE, and 2 is Sharp)<br/>
 * <b>Example:</b> D_FLAT_1 is mapped to 130.<br/>
 *
 * 1 represents octave 1, and 3 represents third note D, and 0 represents the lowest accidental: flat
 *<br/><br/>
 * Also, you can use these to compare which notes are greater, since each variable here is guarunteed to map to a unique integer, and in order. <br/><br/>
 * */
public class StaticValuesNamedNote {

    public static final int A_0 = 001;
    public static final int A_SHARP_0 = 002;
    public static final int B_FLAT_0 = 010;
    public static final int B_0 = 011;

    public static final int C_1 = 121;
    public static final int C_SHARP_1 = 122;
    public static final int D_FLAT_1 = 130;
    public static final int D_1 = 131;
    public static final int D_SHARP_1 = 132;
    public static final int E_FLAT_1 = 140;
    public static final int E_1 = 141;
    public static final int F_1 = 151;
    public static final int F_SHARP_1 = 152;
    public static final int G_FLAT_1 = 160;
    public static final int G_1 = 161;
    public static final int G_SHARP_1 = 162;
    public static final int A_FLAT_1 = 100;
    public static final int A_1 = 101;
    public static final int A_SHARP_1 = 102;
    public static final int B_FLAT_1 = 110;
    public static final int B_1 = 111;

    public static final int C_2 = 221;
    public static final int C_SHARP_2 = 222;
    public static final int D_FLAT_2 = 230;
    public static final int D_2 = 231;
    public static final int D_SHARP_2 = 232;
    public static final int E_FLAT_2 = 240;
    public static final int E_2 = 241;
    public static final int F_2 = 251;
    public static final int F_SHARP_2 = 252;
    public static final int G_FLAT_2 = 260;
    public static final int G_2 = 261;
    public static final int G_SHARP_2 = 262;
    public static final int A_FLAT_2 = 200;
    public static final int A_2 = 201;
    public static final int A_SHARP_2 = 202;
    public static final int B_FLAT_2 = 210;
    public static final int B_2 = 211;

    public static final int C_3 = 321;
    public static final int C_SHARP_3 = 322;
    public static final int D_FLAT_3 = 330;
    public static final int D_3 = 331;
    public static final int D_SHARP_3 = 332;
    public static final int E_FLAT_3 = 340;
    public static final int E_3 = 341;
    public static final int F_3 = 351;
    public static final int F_SHARP_3 = 352;
    public static final int G_FLAT_3 = 360;
    public static final int G_3 = 361;
    public static final int G_SHARP_3 = 362;
    public static final int A_FLAT_3 = 300;
    public static final int A_3 = 301;
    public static final int A_SHARP_3 = 302;
    public static final int B_FLAT_3 = 310;
    public static final int B_3 = 311;

    public static final int C_4 = 421;
    public static final int C_SHARP_4 = 422;
    public static final int D_FLAT_4 = 430;
    public static final int D_4 = 431;
    public static final int D_SHARP_4 = 432;
    public static final int E_FLAT_4 = 440;
    public static final int E_4 = 441;
    public static final int F_4 = 451;
    public static final int F_SHARP_4 = 452;
    public static final int G_FLAT_4 = 460;
    public static final int G_4 = 461;
    public static final int G_SHARP_4 = 462;
    public static final int A_FLAT_4 = 400;
    public static final int A_4 = 401;
    public static final int A_SHARP_4 = 402;
    public static final int B_FLAT_4 = 410;
    public static final int B_4 = 411;

    public static final int C_5 = 521;
    public static final int C_SHARP_5 = 522;
    public static final int D_FLAT_5 = 530;
    public static final int D_5 = 531;
    public static final int D_SHARP_5 = 532;
    public static final int E_FLAT_5 = 540;
    public static final int E_5 = 541;
    public static final int F_5 = 551;
    public static final int F_SHARP_5 = 552;
    public static final int G_FLAT_5 = 560;
    public static final int G_5 = 561;
    public static final int G_SHARP_5 = 562;
    public static final int A_FLAT_5 = 500;
    public static final int A_5 = 501;
    public static final int A_SHARP_5 = 502;
    public static final int B_FLAT_5 = 510;
    public static final int B_5 = 511;

    public static final int C_6 = 621;
    public static final int C_SHARP_6 = 622;
    public static final int D_FLAT_6 = 630;
    public static final int D_6 = 631;
    public static final int D_SHARP_6 = 632;
    public static final int E_FLAT_6 = 640;
    public static final int E_6 = 641;
    public static final int F_6 = 651;
    public static final int F_SHARP_6 = 652;
    public static final int G_FLAT_6 = 660;
    public static final int G_6 = 661;
    public static final int G_SHARP_6 = 662;
    public static final int A_FLAT_6 = 600;
    public static final int A_6 = 601;
    public static final int A_SHARP_6 = 602;
    public static final int B_FLAT_6 = 610;
    public static final int B_6 = 611;

    public static final int C_7 = 721;
    public static final int C_SHARP_7 = 722;
    public static final int D_FLAT_7 = 730;
    public static final int D_7 = 731;
    public static final int D_SHARP_7 = 732;
    public static final int E_FLAT_7 = 740;
    public static final int E_7 = 741;
    public static final int F_7 = 751;
    public static final int F_SHARP_7 = 752;
    public static final int G_FLAT_7 = 760;
    public static final int G_7 = 761;
    public static final int G_SHARP_7 = 762;
    public static final int A_FLAT_7 = 700;
    public static final int A_7 = 701;
    public static final int A_SHARP_7 = 702;
    public static final int B_FLAT_7 = 710;
    public static final int B_7 = 711;

    public static final int C_8 = 821;

}
