package itmo.commands;

/**
 * Exit command
 * @author Gabriela Ticu
 */
public class ExitCommand implements UserCommand{
    /**
     * Execute command method
     */
    @Override
    public void execute() {
        System.exit(0);
    }

    /**
     * @return string
     */
    @Override
    public String toString() {
        return "exit";
    }

    /**
     * @return command name
     */
    public static String name() {
        return "exit";
    }

    /**
     * @return command info
     */
    public static CommandInfo getInfo(){
        return new CommandInfo(0,0,false,false, null);
    }
}
