package itmo.commands;

import itmo.iowork.Printable;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.io.IOException;

/**
 * Info command
 * @author Gabriela Ticu
 */
public class InfoCommand implements UserCommand {

    /**
     * Collection
     */
    private UpgradedPriorityQueue<?> queue;
    /**
     * Variable to print
     */
    private Printable printable;

    /**
     * @param queue
     * @param printable
     */
    public InfoCommand(UpgradedPriorityQueue<?> queue, Printable printable) {
        this.queue = queue;
        this.printable = printable;
    }

    /**
     * Execute command method
     */
    @Override
    public void execute() {
        try {
            printable.println("Type: " + queue.getClass());
            printable.println("Creation date: " + queue.getCreationDate());
            printable.println("Number of the elements: " + queue.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "info";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "info";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo() {
        return new CommandInfo(0,0,true,true, null);
    }
}
