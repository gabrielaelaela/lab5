package itmo.iowork;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class to scan from the console
 * @author Gabriela Ticu
 */
public class ConsoleScan implements Scannable{

    /**
     * scanner
     */
    private Scanner scanner;
    /**
     * printable
     */
    private Printable printable;

    /**
     * @param printable
     */
    public ConsoleScan(Printable printable) {
        this.scanner = new Scanner(System.in);
        this.printable = printable;
    }

    /**
     * @return int
     * @throws IOException
     */
    @Override
    public int scanInt() throws IOException {
        String input = scanner.nextLine();
        int inputInteger;
        try {
            inputInteger = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            printable.print("Wrong number format, please, try again: ");
            return scanInt();
        }
        return inputInteger;
    }

    @Override
    public String scanLine() {
        return scanner.nextLine();
    }

    /**
     * @return float
     * @throws IOException
     */
    @Override
    public float scanFloat() throws IOException {
        String input = scanner.nextLine();
        float inputFloat;
        try {
            inputFloat = Float.parseFloat(input);
        } catch (NumberFormatException e) {
            printable.print("Wrong number format, please, try again: ");
            return scanFloat();
        }
        return inputFloat;
    }

    /**
     * @return double
     * @throws IOException
     */
    @Override
    public double scanDouble() throws IOException {
        String input = scanner.nextLine();
        double inputDouble;
        try {
            inputDouble = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            printable.print("Wrong number format, please, try again: ");
            return scanDouble();
        }
        return inputDouble;
    }

    /**
     * @return long
     * @throws IOException
     */
    @Override
    public long scanLong() throws IOException {
        String input = scanner.nextLine();
        long inputLong;
        try {
            inputLong = Long.parseLong(input);
        } catch (NumberFormatException e) {
            printable.print("Wrong number format, please, try again: ");
            return scanLong();
        }
        return inputLong;
    }

    /**
     * Close scanner method
     * @throws IOException
     */
    @Override
    public void close() throws IOException {
        scanner.close();
    }

    /**
     * @return if scanner has next line
     */
    @Override
    public boolean hasNextLine() {
        return scanner.hasNext();
    }
}
