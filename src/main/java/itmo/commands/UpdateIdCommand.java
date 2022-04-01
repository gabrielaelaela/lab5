package itmo.commands;

import itmo.idobjects.IdObject;
import itmo.organization.Organization;
import itmo.organization.OrganizationFactory;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.util.Arrays;

/**
 * Update id command
 * @author Gabriela Ticu
 */
public class UpdateIdCommand implements UserCommand {

    /**
     * Collection
     */
    private UpgradedPriorityQueue<IdObject> priorityQueue;
    /**
     * Organization to be updated
     */
    private Organization organization;

    /**
     * @param priorityQueue
     * @param organization
     */
    public UpdateIdCommand(UpgradedPriorityQueue<IdObject> priorityQueue, Organization organization) {
        this.priorityQueue = priorityQueue;
        this.organization = organization;
    }

    /**
     * Execute command method
     */
    @Override
    public void execute() {
        int id = organization.getId();
        this.priorityQueue.remove(this.priorityQueue.getElementById(id));
        this.priorityQueue.add(organization);
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "update id";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "update_id";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo(){
        return new CommandInfo(0,1,true,false, Arrays.asList(OrganizationFactory.class));
    }
}
