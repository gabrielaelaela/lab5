package itmo.commands;

import itmo.iowork.Printable;
import itmo.upgradedcollections.UpgradedPriorityQueue;
import java.io.IOException;

/**
 * Print ascending command
 * @author Ganriela
 */
public class PrintAscendingCommand implements UserCommand {

    /**
     * variable to print
     */
    private Printable printable;
    /**
     * Collection
     */
    private UpgradedPriorityQueue<?> queue;

    /**
     * @param queue
     * @param printable
     */
    public PrintAscendingCommand(UpgradedPriorityQueue<?> queue, Printable printable) {
        this.printable = printable;
        this.queue = queue;
    }

    /**
     * Execute command method
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        queue.forEach(elem -> {
            try {
                printable.println(elem.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "print ascending";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "print_ascending";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo() {
        return new CommandInfo(0, 0, true, true, null);
    }
}
