import exceptions.InvalidOptionsException;
import gameoptions.ChordOptions;
import gameoptions.KeySignatureOptions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KeySignatureOptionsTest {

    @Test public void test_one_key_signature_chosen() {
        KeySignatureOptions keySig = new KeySignatureOptions();
        keySig.setAflatMajor_Fminor(true);
        boolean isValid = false;
        try {
            isValid = keySig.isValid();
        } catch (InvalidOptionsException e) {
            System.out.println(e.getMessage());
        }
        assertTrue(isValid);
    }

    @Test public void test_no_key_signatures_chosen() {
        KeySignatureOptions keySig = new KeySignatureOptions();
        // everything is false right now
        Exception exception = null;
        try {
            keySig.isValid();
        } catch (InvalidOptionsException e) {
            exception = e;
        }
        assertTrue(exception != null);
    }
}
