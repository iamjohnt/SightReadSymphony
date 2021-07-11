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
    private class Constructors {
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
        public void test_construct_using_midi_value_and_requested_accidental() {
            Note A0 = new Note(StaticValuesMidi.A_0, Note.NO_ACCIDENTAL);
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
