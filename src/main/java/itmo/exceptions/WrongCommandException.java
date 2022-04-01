package itmo.exceptions;

/**
 * Exception
 * @author Gabriela Ticu
 */
public class WrongCommandException extends RuntimeException{
    /**
     * @param s
     */
    public WrongCommandException(String s) {
        super(s);
    }
}
