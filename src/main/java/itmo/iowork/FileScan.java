package itmo.iowork;

import itmo.exceptions.WrongInputException;

import java.io.*;

/**
 * Class to scan from the file
 * @author Gabriela Ticu
 */
public class FileScan implements Scannable{

    /**
     * Stream
     */
    private BufferedInputStream bufferedInputStream;
    /**
     * End of file
     */
    private boolean eof = false;

    /**
     * @param fileName
     * @throws Exception
     */
    public FileScan(String fileName) throws Exception {
        bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
        if (bufferedInputStream.read() == -1)
            eof = true;
        bufferedInputStream.close();
        bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));
    }

    /**
     * @return int
     * @throws IOException
     */
    @Override
    public int scanInt() throws IOException {
        if (hasNextLine()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int next = bufferedInputStream.read();
                if (next == -1){
                    eof = true;
                    break;
                }
                char nextChar = (char) next;
                if (nextChar == ' ' || nextChar == '\n')
                    break;
                stringBuilder.append(nextChar);
            }
            return Integer.parseInt(stringBuilder.toString().replaceAll("\r",""));
        }
        throw new WrongInputException("Not a number");
    }

    /**
     * @return String
     * @throws IOException
     */
    @Override
    public String scanLine() throws IOException {
        if (hasNextLine()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int next = bufferedInputStream.read();
                if (next == -1){
                    eof = true;
                    break;
                }
                char nextChar = (char) next;
                if (nextChar == '\n')
                    break;
                stringBuilder.append(nextChar);
            }
            return stringBuilder.toString().replaceAll("\r","");
        }
        return null;
    }

    /**
     * @return float
     * @throws IOException
     */
    @Override
    public float scanFloat() throws IOException {
        if (hasNextLine()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int next = bufferedInputStream.read();
                if (next == -1){
                    eof = true;
                    break;
                }
                char nextChar = (char) next;
                if (nextChar == ' ' || nextChar == '\n')
                    break;
                stringBuilder.append(nextChar);
            }
            return Float.parseFloat(stringBuilder.toString().replaceAll("\r",""));
        }
        throw new WrongInputException("Not a number");
    }

    /**
     * @return double
     * @throws IOException
     */
    @Override
    public double scanDouble() throws IOException {
        if (hasNextLine()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int next = bufferedInputStream.read();
                if (next == -1){
                    eof = true;
                    break;
                }
                char nextChar = (char) next;
                if (nextChar == ' ' || nextChar == '\n')
                    break;
                stringBuilder.append(nextChar);
            }
            return Double.parseDouble(stringBuilder.toString().replaceAll("\r",""));
        }
        throw new WrongInputException("Not a number");
    }

    /**
     * @return long
     * @throws IOException
     */
    @Override
    public long scanLong() throws IOException {
        if (hasNextLine()){
            StringBuilder stringBuilder = new StringBuilder();
            while (true){
                int next = bufferedInputStream.read();
                if (next == -1){
                    eof = true;
                    break;
                }
                char nextChar = (char) next;
                if (nextChar == ' ' || nextChar == '\n')
                    break;
                stringBuilder.append(nextChar);
            }
            return Long.parseLong(stringBuilder.toString().replaceAll("\r",""));
        }
        throw new WrongInputException("Not a number");
    }

    /**
     * Close stream method
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        bufferedInputStream.close();
    }

    /**
     * @return if file has next line
     */
    @Override
    public boolean hasNextLine() {
        return !eof;
    }
}
