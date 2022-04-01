package itmo.commands;

import com.google.gson.GsonBuilder;
import itmo.Main;
import itmo.iowork.FilePrint;
import itmo.organization.Organization;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Save command
 * @author Gabriela Ticu
 */
public class SaveCommand implements UserCommand {

    /**
     * Collection
     */
    private UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue;
    /**
     * file name
     */
    private String fileName;

    /**
     * @param organizationUpgradedPriorityQueue
     */
    public SaveCommand(UpgradedPriorityQueue<Organization> organizationUpgradedPriorityQueue) {
        this.organizationUpgradedPriorityQueue = organizationUpgradedPriorityQueue;
        this.fileName = Main.FILENAME;
    }

    /**
     * Execute command method
     * @throws FileNotFoundException
     */
    @Override
    public void execute() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            new FilePrint(fileName).println(gson.toJson(this.organizationUpgradedPriorityQueue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "save";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "save";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo(){
        return new CommandInfo(0,0,true,false, null);
    }
}
