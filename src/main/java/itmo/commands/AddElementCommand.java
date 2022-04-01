package itmo.commands;

import itmo.organization.Organization;
import itmo.organization.OrganizationFactory;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.util.Arrays;

/**
 * Add command
 * @author Gabriela Ticu
 */
public class AddElementCommand implements UserCommand {

    /**
     * Collection
     */
    private UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue;

    /**
     * Organization to add
     */
    private Organization organization;

    /**
     * @param organizationUpgradedPriorityQueue
     * @param organization
     */
    public AddElementCommand(UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue, Organization organization) {
        this.organizationUpgradedPriorityQueue = organizationUpgradedPriorityQueue;
        this.organization = organization;
    }

    /**
     * Execute command method
     */
    @Override
    public void execute() {
        this.organizationUpgradedPriorityQueue.add(organization);
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "add";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "add";
    }

    /**
     * @return command info
     * @throws Exception
     */
    public static CommandInfo getInfo() throws Exception {
        return new CommandInfo(0,1,true,false, Arrays.asList(OrganizationFactory.class));
    }
}
