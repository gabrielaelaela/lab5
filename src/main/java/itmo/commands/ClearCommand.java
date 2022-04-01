package itmo.commands;

import itmo.idobjects.IdObject;
import itmo.upgradedcollections.UpgradedPriorityQueue;

/**
 * Clear command
 * @author Gabriela Ticu
 */
public class ClearCommand implements UserCommand {

    /**
     * Collection
     */
    private UpgradedPriorityQueue<IdObject> priorityQueue;

    /**
     * @param priorityQueue
     */
    public ClearCommand(UpgradedPriorityQueue<IdObject> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    /**
     * Execute command method
     */
    @Override
    public void execute() {
        this.priorityQueue.clear();
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "clear";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "clear";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo(){
        return new CommandInfo(0,0,true,false, null);
    }
}
