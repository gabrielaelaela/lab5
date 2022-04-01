package itmo.exceptions;

/**
 * Exception
 * @author Gabriela Ticu
 */
public class WrongInputException extends RuntimeException{
    /**
     * @param s
     */
    public WrongInputException(String s) {
        super(s);
    }
}
