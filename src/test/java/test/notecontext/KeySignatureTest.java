package test.notecontext;

import notecontext.KeySignature;
import notecontext.NamedNote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KeySignatureTest {

    @Test
    public void test_c_major_is_chromatic() {
        KeySignature k = new KeySignature(KeySignature.C_MAJOR_ID);
        assertEquals(true, k.isChromatic(NamedNote.C_4));
        assertEquals(false, k.isChromatic(NamedNote.C_SHARP_4));
    }
}
