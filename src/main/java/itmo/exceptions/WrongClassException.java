package itmo.exceptions;

/**
 * Exception
 * @author Gabriela Ticu
 */
public class WrongClassException extends RuntimeException {
    /**
     * @param input
     */
    public WrongClassException(String input) {
        super(input);
    }
}
