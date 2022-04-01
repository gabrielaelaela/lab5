package itmo.commands;

import itmo.history.HistoryOfCommands;

/**
 * Class to invoke itmo.commands
 * @author Gabriela Ticu
 */
public class CommandInvoker {
    /**
     * @param userCommand {@link UserCommand}
     * @throws Exception
     */
    public static void invoke(itmo.commands.UserCommand userCommand) throws Exception {
        System.out.println();
        HistoryOfCommands.getInstance().addCommandToHistory(userCommand);
        userCommand.execute();
        System.out.println();
    }
}
