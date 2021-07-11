package test.note_coord;

import note_coordinate.Note;
import note_coordinate.StaticValuesMidi;
import note_coordinate.StaticValuesNamedNote;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NoteTest {

    @Nested
    @DisplayName("test constructors")
    public class Constructors {
        /* psuedo scratchpad please ignore
         * what do i need to test
         * run
         * for each constructors i need to test the following
         *       test top boundary
         *       test bottom boundary
         *       test random middle
         *       test random middle
         * */

        @Test
        public void run() {
            Note A_0 = new Note(StaticValuesNamedNote.A_0);
            Note A_1 = new Note(StaticValuesMidi.A_1, Note.NO_ACCIDENTAL);
            Note A_2 = new Note(Note.A, Note.NO_ACCIDENTAL, Note.TWO);
        }

        @Test
        public void construct_with_id() {
            Note c4 = new Note(StaticValuesNamedNote.C_4);
            int C = Note.C;
            int NONE = Note.NO_ACCIDENTAL;
            int FOUR = Note.FOUR;
            assertEquals(C, c4.getNoteLetter());
            assertEquals(NONE, c4.getAccidental());
            assertEquals(FOUR, c4.getOctave());
        }

        @Test
        public void construct_with_midiValue_and_requestedAccidental() {
            Note a0 = new Note(StaticValuesMidi.A_0, Note.NO_ACCIDENTAL);
            Note c8 = new Note(StaticValuesMidi.C_8, Note.NO_ACCIDENTAL);
            Note c_sharp_4 = new Note(StaticValuesMidi.C_SHARP_4, Note.SHARP);
            Note d_flat_4 = new Note(StaticValuesMidi.D_FLAT_4, Note.FLAT);

            Note expected_a0 = new Note(Note.A, Note.NO_ACCIDENTAL, Note.ZERO);
            Note expected_c8 = new Note(Note.C, Note.NO_ACCIDENTAL, Note.EIGHT);
            Note expected_c_sharp_4 = new Note(Note.C, Note.SHARP, Note.FOUR);
            Note expected_d_flat_4 = new Note(Note.D, Note.FLAT, Note.FOUR);

            assertEquals(expected_a0, a0);
            assertEquals(expected_c8, c8);
            assertEquals(expected_c_sharp_4, c_sharp_4);
            assertEquals(expected_d_flat_4, d_flat_4);
        }

        @Test
        public void construct_with_noteLetter_accidental_octave() {
            Note c8 = new Note(Note.C, Note.NO_ACCIDENTAL, Note.EIGHT);
            int C = 2;
            int NONE = 1;
            int EIGHT = 8;
            assertEquals(C, c8.getNoteLetter());
            assertEquals(NONE, c8.getAccidental());
            assertEquals(EIGHT, c8.getOctave());
        }
    }

    @Nested
    @DisplayName("Equals")
    public class Equals {

        @Test
        public void test_equals_C4_andC4() {
            Note note1 = new Note(Note.C, Note.NO_ACCIDENTAL, Note.FOUR);
            Note note2 = new Note(Note.C, Note.NO_ACCIDENTAL, Note.FOUR);
            assertTrue(note1.equals(note2));
            assertTrue(note2.equals(note1));
        }

        @Test
        public void test_equals_A0_and_C8() {
            Note a0 = new Note(Note.A, Note.NO_ACCIDENTAL, Note.ZERO);
            Note c_sharp_4 = new Note(Note.C, Note.SHARP, Note.FOUR);
            assertTrue( ! a0.equals(c_sharp_4));
            assertTrue( ! c_sharp_4.equals(a0));
        }

    }


    @Test
    public void test_hashCode() {

    }


}
