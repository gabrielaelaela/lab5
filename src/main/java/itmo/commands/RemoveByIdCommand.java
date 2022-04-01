package itmo.commands;

import itmo.idobjects.IdObject;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.io.IOException;

/**
 * Remove by id command
 * @author Gabriela Ticu
 */
public class RemoveByIdCommand implements UserCommand {
    /**
     * Collection
     */
    private UpgradedPriorityQueue<IdObject> priorityQueue;
    /**
     * id to remove
     */
    private int id;

    /**
     * @param priorityQueue
     * @param id
     */
    public RemoveByIdCommand(UpgradedPriorityQueue<IdObject> priorityQueue, int id) {
        this.priorityQueue = priorityQueue;
        this.id = id;
    }

    /**
     * Execute command method
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        IdObject idObject = this.priorityQueue.getElementById(id);
        this.priorityQueue.remove(idObject);
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "remove by id";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "remove_by_id";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo() {
        return new CommandInfo(1,0,true,false, null);
    }
}
