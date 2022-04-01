package itmo.commands;

import itmo.iowork.Printable;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Print descending command
 * @author Gabriela Ticu
 */
public class PrintDescendingCommand implements UserCommand {

    /**
     * Variable to print
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
    public PrintDescendingCommand(UpgradedPriorityQueue<?> queue, Printable printable) {
        this.printable = printable;
        this.queue = queue;
    }

    /**
     * Execute command method
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        List<?> queueInList = new ArrayList<Object>(queue);
        for(int i = queueInList.size()-1; i > -1; i--) {
            printable.print(queueInList.get(i).toString());
        }
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "print descending";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "print_descending";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo() {
        return new CommandInfo(0, 0, true, true, null);
    }
}
