package itmo.iowork;

import java.io.*;

/**
 * Class to print in the file
 * @author Gabriela Ticu
 */
public class FilePrint implements Printable{

    /**
     * Stream
     */
    BufferedWriter bufferedWriter;

    /**
     * @param fileName
     * @throws IOException
     */
    public FilePrint(String fileName) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(fileName));
    }

    /**
     * @param s
     * @throws IOException
     */
    @Override
    public void println(String s) throws IOException {
        bufferedWriter.write(s + "\n");
        bufferedWriter.close();
    }

    /**
     * @param s
     * @throws IOException
     */
    @Override
    public void print(String s) throws IOException {
        bufferedWriter.write(s);
        bufferedWriter.close();
    }
}
