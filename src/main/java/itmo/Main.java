package itmo;

import itmo.commands.CommandInvoker;
import itmo.commands.CommandList;
import itmo.commands.UserCommand;
import itmo.commands.PriorityQueueDeserializer;
import itmo.iowork.*;
import itmo.commands.CommandReader;
import itmo.exceptions.WrongInputException;
import itmo.organization.Organization;
import itmo.upgradedcollections.UpgradedPriorityQueue;

/**
 * itmo.Main class
 * @author Gabriela Ticu
 */
public class Main {

    public static String FILENAME;

    /**
     * itmo.Main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Printable printable = new ConsolePrint();

        FILENAME = args[0];

        PriorityQueueDeserializer priorityQueueDeserializer = new PriorityQueueDeserializer(FILENAME);
        UpgradedPriorityQueue<Organization> upgradedPriorityQueue = priorityQueueDeserializer.deserialize();

        CommandList.FillList("itmo.commands");

        CommandReader commandReader = new CommandReader(upgradedPriorityQueue);
        waitForAction(commandReader, printable);
    }

    /**
     * Method to read itmo.commands from the console while the user do not enter 'exit' as a command name
     * @param commandReader
     * @param printable
     * @throws Exception
     */
    private static void waitForAction(CommandReader commandReader, Printable printable) throws Exception {
        try {
            UserCommand userCommand = commandReader.commandFromConsole();
            CommandInvoker.invoke(userCommand);
        } catch (WrongInputException e) {
            printable.println("Wrong input. Please, try again");
        } finally {
            waitForAction(commandReader, printable);
        }
    }
}
