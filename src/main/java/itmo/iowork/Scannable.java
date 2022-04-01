package itmo.iowork;

import java.io.IOException;

/**
 * Class to scan
 * @author Gabriela Ticu
 */
public interface Scannable {
    /**
     * @return int
     * @throws IOException
     */
    int scanInt() throws IOException;

    /**
     * @return String
     * @throws IOException
     */
    String scanLine() throws IOException;

    /**
     * @return float
     * @throws IOException
     */
    float scanFloat() throws IOException;

    /**
     * @return double
     * @throws IOException
     */
    double scanDouble() throws IOException;

    /**
     * @return long
     * @throws IOException
     */
    long scanLong() throws IOException;

    /**
     * Close scanner method
     * @throws IOException
     */
    void close() throws IOException;

    /**
     * @return if has next line
     */
    boolean hasNextLine();
}
