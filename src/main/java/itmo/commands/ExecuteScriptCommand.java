package itmo.commands;

import itmo.iowork.FileScan;
import itmo.iowork.Scannable;
import itmo.organization.Organization;
import itmo.upgradedcollections.UpgradedPriorityQueue;

/**
 * Execute script command
 * @author Gabriela Ticu
 */
public class ExecuteScriptCommand implements UserCommand {

    /**
     * Name for file with itmo.commands
     */
    private String fileName;
    /**
     * Collection
     */
    private UpgradedPriorityQueue<Organization> upgradedPriorityQueue;

    /**
     * @param upgradedPriorityQueue
     * @param fileName
     */
    public ExecuteScriptCommand(UpgradedPriorityQueue<Organization> upgradedPriorityQueue, String fileName) {
        this.fileName = fileName;
        this.upgradedPriorityQueue = upgradedPriorityQueue;
    }

    /**
     * Execute command method
     */
    @Override
    public void execute() {
        try {
            Scannable fileScan = new FileScan(fileName);
            CommandReader commandReader = new CommandReader(upgradedPriorityQueue);
            for (UserCommand userCommand : commandReader.commandsFromFile(fileScan)) {
                CommandInvoker.invoke(userCommand);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "execute script";
    }

    /**
     * @return command name
     */
    public static String name(){
        return "execute_script";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo(){
        return new CommandInfo(1,0,true,false, null);
    }
}
