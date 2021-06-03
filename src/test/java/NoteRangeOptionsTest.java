import exceptions.InvalidOptionsException;
import gameoptions.NoteRangeOptions;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/* this test is divided into 4 nested tests
* test setMinBass()
* test setMaxBass()
* test setMinTreble()
* test setMaxTreble()
* I recommend using IDE to view method structure, or fold methods, for convenience
* */
@DisplayName("NoteRangeOptions test")
public class NoteRangeOptionsTest {

    private NoteRangeOptions range;

    @BeforeEach
    public void init_all_valid_data() {
        range = new NoteRangeOptions();
    }

    @AfterEach public void teardown() {
        range = null;
    }

    @Nested
    @DisplayName("Test isValid()")
    class testIsValid {
        @Test
        public void is_exists_null_min_or_max() {
            try {
                range.setMinBass(30);
                // purposefully missing maxBass
                range.setMinTreble(50);
                range.setMaxTreble(70);
            } catch (Exception e) {
                assertTrue(e instanceof InvalidOptionsException);
            }
        }
    }

    @Nested
    @DisplayName("Test setMinBass()")
    class testSetMinBass {

        @Test
        public void minBass_slightly_below_thresh() {
            Exception exception = null;
            try {
                range.setMinBass(20);
            } catch (Exception e) {
                exception = e;
            }
            assertTrue(exception != null);
        }

        @Test
        public void minBass_at_lower_thresh() {
            try {
                range.setMinBass(21);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMinBass() == 21);
        }

        @Test
        public void minBass_at_upper_bound() {
            try {
                range.setMinBass(108);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMinBass() == 108);
        }

        @Test
        public void minBass_slightly_above_upper_bound() {
            Exception exception = null;
            try {
                range.setMinBass(109);
            } catch (Exception e) {
                exception = e;
            }
            assertTrue(exception != null);
        }

        @Test
        public void minBass_crosses_maxBass() {
            String msg = null;
            try {
                // the order of this matters, since the first setter may throw exception first, and skip execution of 2nd setter
                range.setMaxBass(49);
                range.setMinBass(50);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_MIN_OVER_MAX));
        }

        @Test
        public void minBass_equals_maxBass() {
            String msg = null;
            try {
                range.setMinBass(50);
                range.setMaxBass(50);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg == null);
            assertTrue(msg == null);
            assertTrue(range.getMinBass().equals(50));
            assertTrue(range.getMinBass().equals(50));
        }
    }

    @Nested
    @DisplayName("Test setMaxBass")
    class testingMaxBassOutOfBounds {

        @Test
        public void maxBass_slightly_below_thresh() {
            String msg = null;
            try {
                range.setMaxBass(20);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_OUT_OF_BOUNDS));
        }

        @Test
        public void maxBass_at_lower_thresh() {
            try {
                range.setMaxBass(21);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMaxBass() == 21);
        }

        @Test
        public void maxBass_at_upper_bound() {
            try {
                range.setMaxBass(108);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMaxBass() == 108);
        }

        @Test
        public void maxBass_slightly_above_upper_bound() {
            String msg = null;
            try {
                range.setMaxBass(109);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_OUT_OF_BOUNDS));
        }

        @Test
        public void maxBass_crosses_maxBass() {
            String msg = null;
            try {
                // the order of this matters, since the first setter may throw exception first, and skip execution of 2nd setter
                range.setMinBass(50);
                range.setMaxBass(49);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_MIN_OVER_MAX));
        }

        @Test
        public void maxBass_equals_maxBass() {
            String msg = null;
            try {
                range.setMinBass(50);
                range.setMaxBass(50);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg == null);
            assertTrue(range.getMinBass().equals(50));
            assertTrue(range.getMinBass().equals(50));
        }
    }

    @Nested
    @DisplayName("Test setMinTreble")
    class testSetMinTreble {

        @Test
        public void minTreble_slightly_below_thresh() {
            String msg = null;
            try {
                range.setMinTreble(20);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_OUT_OF_BOUNDS));
        }

        @Test
        public void minTreble_at_lower_thresh() {
            try {
                range.setMinTreble(21);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMinTreble() == 21);
        }

        @Test
        public void minTreble_at_upper_bound() {
            try {
                range.setMinTreble(108);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMinTreble() == 108);
        }

        @Test
        public void minTreble_slightly_above_upper_bound() {
            String msg = null;
            try {
                range.setMinTreble(109);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_OUT_OF_BOUNDS));
        }

        @Test
        public void minTreble_crosses_maxTreble() {
            String msg = null;
            try {
                // the order of this matters, since the first setter may throw exception first, and skip execution of 2nd setter
                range.setMaxTreble(49);
                range.setMinTreble(50);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_MIN_OVER_MAX));
        }

        @Test
        public void maxBass_equals_maxBass() {
            String msg = null;
            try {
                range.setMinBass(50);
                range.setMaxBass(50);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg == null);
            assertTrue(msg == null);
            assertTrue(range.getMinTreble().equals(50));
            assertTrue(range.getMinTreble().equals(50));
        }
    }

    @Nested
    @DisplayName("Test setMaxTreble")
    class testSetMaxTreble {
        @Test
        public void maxTreble_slightly_below_thresh() {
            String msg = null;
            try {
                range.setMaxTreble(20);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_OUT_OF_BOUNDS));
        }

        @Test
        public void maxTreble_at_lower_thresh() {
            try {
                range.setMaxTreble(21);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMaxTreble() == 21);
        }

        @Test
        public void maxTreble_at_upper_bound() {
            try {
                range.setMaxTreble(108);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertTrue(range.getMaxTreble() == 108);
        }

        @Test
        public void maxTreble_slightly_above_upper_bound() {
            Exception exception = null;
            try {
                range.setMaxTreble(109);
            } catch (Exception e) {
                exception = e;
            }
            assertTrue(exception.getMessage().contains(InvalidOptionsException.MSG_OUT_OF_BOUNDS));
        }

        @Test
        public void minTreble_crosses_maxTreble() {
            String msg = null;
            try {
                // the order of this matters, since the first setter may throw exception first, and skip execution of 2nd setter
                range.setMinTreble(50);
                range.setMaxTreble(49);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg.contains(InvalidOptionsException.MSG_MIN_OVER_MAX));
        }

        @Test
        public void maxBass_equals_maxBass() {
            String msg = null;
            try {
                range.setMinBass(50);
                range.setMaxBass(50);
            } catch (Exception e) {
                msg = e.getMessage();
            }
            assertTrue(msg == null);
            assertTrue(range.getMinTreble().equals(50));
            assertTrue(range.getMinTreble().equals(50));
        }

    }

}
