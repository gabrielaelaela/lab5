package itmo.commands;

import itmo.iowork.Printable;
import itmo.organization.Organization;
import itmo.organization.OrganizationFactory;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Add element max command
 * @author Gabriela Ticu
 */
public class AddIfMaxCommand implements UserCommand {
    /**
     * Organization to add
     */
    private Organization organization;
    /**
     * Collection
     */
    private UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue;
    /**
     * Variable to print
     */
    private Printable printable;

    /**
     * @param organizationUpgradedPriorityQueue
     * @param printable
     * @param organization
     */
    public AddIfMaxCommand(UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue, Printable printable, Organization organization) {
        this.organization = organization;
        this.organizationUpgradedPriorityQueue = organizationUpgradedPriorityQueue;
        this.printable = printable;
    }

    /**
     * Execute command method
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        List<Organization> organizationList = new ArrayList<>(organizationUpgradedPriorityQueue);
        if (organization.getId() > organizationList.get(organizationList.size()-1).getId())  {
            this.organizationUpgradedPriorityQueue.add(organization);
            printable.println("The itmo.organization was added");
        } else {
            printable.print("The itmo.organization was not added");
        }
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "add if max";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "add_if_max";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo() {
        return new CommandInfo(0, 1, true, true, Arrays.asList(OrganizationFactory.class));
    }
}
