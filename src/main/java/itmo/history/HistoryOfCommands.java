package itmo.history;

import itmo.commands.UserCommand;

import java.util.ArrayList;

/**
 * Singleton class with itmo.history of itmo.commands
 * @author Gabriela Ticu
 */
public class HistoryOfCommands {

    /**
     * instance of class
     */
    private static HistoryOfCommands instance;
    /**
     * list with itmo.commands
     */
    private ArrayList<UserCommand> listOfCommands = new ArrayList<>();

    /**
     * Banned default constructor
     */
    private HistoryOfCommands() {}

    /**
     * @return instance of the class
     */
    public static HistoryOfCommands getInstance() {
        if (instance == null)
            instance = new HistoryOfCommands();
        return instance;
    }

    /**
     * @param command
     */
    public void addCommandToHistory(UserCommand command) {
        this.listOfCommands.add(command);
        if (listOfCommands.size() > 10)
            listOfCommands.remove(0);
    }

    /**
     * @param index
     * @return command {@link UserCommand}
     */
    public UserCommand get(int index){
        return listOfCommands.get(index);
    }

    /**
     * @return length of itmo.history
     */
    public int getLength(){
        return listOfCommands.size();
    }
}
