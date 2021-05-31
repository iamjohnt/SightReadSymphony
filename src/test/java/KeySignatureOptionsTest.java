import gameoptions.ChordOptions;
import gameoptions.KeySignatureOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeySignatureOptionsTest {

    @Test public void test_one_key_signature_chosen() {
        KeySignatureOptions keySig = new KeySignatureOptions();
        keySig.setAflatMajor_Fminor(true);
        assertEquals(true, keySig.isValid());
    }

    @Test public void test_no_key_signatures_chosen() {
        KeySignatureOptions keySig = new KeySignatureOptions();
        // everything is false right now
        assertEquals(false, keySig.isValid());
    }
}
