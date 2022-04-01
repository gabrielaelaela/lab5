package itmo.commands;

import itmo.iowork.Printable;
import itmo.history.HistoryOfCommands;

import java.io.IOException;

/**
 * History command
 * @author Gabriela Ticu
 */
public class HistoryCommand implements UserCommand{

    /**
     * Variable to print
     */
    private Printable printable;

    /**
     * @param printable
     */
    public HistoryCommand(Printable printable) {
        this.printable = printable;
    }

    /**
     * Execute command method
     */
    @Override
    public void execute() {
        int length = HistoryOfCommands.getInstance().getLength();
        for (int i = 0; i < length; i++) {
            try {
                printable.println(HistoryOfCommands.getInstance().get(i).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "history";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "history";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo(){
        return new CommandInfo(0,0,false,true, null);
    }
}
