package itmo.commands;

import itmo.iowork.Printable;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.io.IOException;

/**
 * Show command
 * @author Gabriela Ticu
 */
public class ShowCommand implements UserCommand{

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
    public ShowCommand(UpgradedPriorityQueue<?> queue, Printable printable) {
        this.queue = queue;
        this.printable = printable;
    }

    /**
     * Execute command method
     */
    @Override
    public void execute() {
        queue.forEach(elem -> {
            try {
                printable.println(elem.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        if (queue.isEmpty()) System.out.println("The collection is empty");
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "show";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "show";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo(){
        return new CommandInfo(0,0,true,true, null);
    }
}
