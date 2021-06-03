import exceptions.InvalidOptionsException;
import gameoptions.MiscOptions;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MiscOptionsTest {

    private MiscOptions miscOptions;

    @BeforeEach
    public void init() {
        miscOptions = new MiscOptions();
    }

    @AfterEach
    public void teardown() {
        miscOptions = null;
    }

    @DisplayName("test isValid()")
    @Nested
    public class testIsValid {
        @Test
        public void no_notation_is_set() {
            miscOptions.setShowNotationName(false);
            miscOptions.setShowNotationImage(false);
            miscOptions.setBassClef(true);
            miscOptions.setTrebleClef(true);

            Exception exception = null;
            try {
                miscOptions.isValid();
            } catch (InvalidOptionsException e) {
                exception = e;
            }
            assertTrue(exception != null);
        }

        @Test
        public void no_clef_is_set() {
            miscOptions.setShowNotationName(true);
            miscOptions.setShowNotationImage(true);
            miscOptions.setBassClef(true);
            miscOptions.setTrebleClef(true);

            Exception exception = null;
            try {
                miscOptions.isValid();
            } catch (InvalidOptionsException e) {
                exception = e;
            }
            assertTrue(exception != null);
        }
    }


}
