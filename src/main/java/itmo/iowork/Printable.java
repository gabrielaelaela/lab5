package itmo.iowork;

import java.io.IOException;

/**
 * Class to print
 * @author Gabriela Ticu
 */
public interface Printable {
    /**
     * @param s
     * @throws IOException
     */
    void println(String s) throws IOException;

    /**
     * @param s
     * @throws IOException
     */
    void print(String s) throws IOException;
}
