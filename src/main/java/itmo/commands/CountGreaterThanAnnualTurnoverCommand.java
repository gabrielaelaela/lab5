package itmo.commands;

import itmo.iowork.Printable;
import itmo.organization.Organization;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.io.IOException;

/**
 * Count greater than annual turnover command
 * @author Gabriela Ticu
 */
public class CountGreaterThanAnnualTurnoverCommand implements UserCommand {

    /**
     * comparable annual turnover
     */
    private long annualTurnover;
    /**
     * colletion
     */
    private UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue;
    /**
     * variable to print
     */
    private Printable printable;

    /**
     * @param organizationUpgradedPriorityQueue
     * @param printable
     * @param annualTurnover
     */
    public CountGreaterThanAnnualTurnoverCommand(UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue, Printable printable, String annualTurnover) {
        this.annualTurnover = Long.parseLong(annualTurnover);
        this.organizationUpgradedPriorityQueue = organizationUpgradedPriorityQueue;
    }

    /**
     * Execute command method
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        int number = (int) organizationUpgradedPriorityQueue.stream().filter(elem -> elem.getAnnualTurnover() > this.annualTurnover).count();
        printable.println(String.valueOf(number));
    }

    /**
     * @return string
     */
    @Override
    public String toString() {return "count greater than annual turnover";}

    /**
     * @return command name
     */
    public static String name() {return "count_greater_than_annual_turnover";}

    /**
     * @return command info
     */
    public static CommandInfo getInfo() {
        return new CommandInfo(1, 0, true, true, null);
    }
}
