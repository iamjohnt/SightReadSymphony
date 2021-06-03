package exceptions;

/** this exception should be thrown upon 2 conditions:
 * when a note is chosen that NOT between values 21 and 108
 * when a min note is over the max, or a max is over a min note (within the same clef)
 * <p>(context: min and maxes are chosen, so the user can decide the range they want to practice in,
 * which are the lowest and highest midi note, of a 88 key piano </p> */
public class InvalidOptionsException extends Exception{

    // 2 preset static messages, that you can use when throwing this exception
    public static final String MSG_OUT_OF_BOUNDS = "Midi note out of bounds of 21 to 108 inclusive";
    public static final String MSG_MIN_OVER_MAX = "Min note is higher than max note within same clef";
    private String message;

    public InvalidOptionsException(String message) {
        this.message = message;
    }

    public InvalidOptionsException() {
        this.message = MSG_OUT_OF_BOUNDS + ", or " + MSG_MIN_OVER_MAX;
    }

    public String getMessage() {
        return message;
    }

}
