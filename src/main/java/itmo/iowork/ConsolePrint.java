package itmo.iowork;

/**
 * Class to print on console
 * @author Gabriela Ticu
 */
public class ConsolePrint implements Printable{
    /**
     * @param s
     */
    @Override
    public void println(String s) {
        System.out.println(s);
    }

    /**
     * @param s
     */
    @Override
    public void print(String s) {
        System.out.print(s);
    }
}
