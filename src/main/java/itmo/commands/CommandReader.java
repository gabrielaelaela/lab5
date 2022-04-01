package itmo.commands;

import itmo.exceptions.WrongCommandException;
import itmo.iowork.ConsolePrint;
import itmo.iowork.ConsoleScan;
import itmo.iowork.Printable;
import itmo.iowork.Scannable;
import itmo.constructors.Constructor;
import itmo.organization.Organization;
import itmo.upgradedcollections.UpgradedPriorityQueue;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to read itmo.commands from console or file
 * @author Gabriela Ticu
 */
public class CommandReader {

    /**
     * Collection
     */
    private UpgradedPriorityQueue<Organization> organizationQueue;

    /**
     * @param organizationQueue
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public CommandReader(UpgradedPriorityQueue<Organization> organizationQueue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        this.organizationQueue = organizationQueue;
    }

    /**
     * @param commandName
     * @return command class
     * @throws Exception
     */
    private Class<? extends itmo.commands.UserCommand> getCommand(String commandName) throws Exception {
        for (Class<? extends itmo.commands.UserCommand> command : CommandList.commandList) {
            if (command.getMethod("name").invoke(null).equals(commandName.trim())){
                return command;
            }
        }
        throw new WrongCommandException("Incorrect command");
    }

    /**
     * @param command
     * @return command info {@link CommandInfo}
     * @throws Exception
     */
    private CommandInfo getCommandInfo(Class<? extends itmo.commands.UserCommand> command) throws Exception {
        return (CommandInfo) command.getMethod("getInfo").invoke(null);
    }

    /**
     * @param line
     * @return list of words
     */
    private List<String> getWordList(String line) {
        return Arrays.asList(line.split("[ \r]"));
    }

    /**
     * @param command
     * @param commandInfo
     * @param printable
     * @param scannable
     * @return list of complex arguments as Object
     * @throws Exception
     */
    private List<Object> askComplexArgs(Class<? extends itmo.commands.UserCommand> command, CommandInfo commandInfo, Printable printable, Scannable scannable) throws Exception {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < commandInfo.getComplexArgs(); ++i){
            Constructor constructor = (Constructor) commandInfo.getComplexConstructors().get(i).getConstructors()[0].newInstance(printable, scannable);
            list.add(constructor.askConstruct());
        }
        return list;
    }

    /**
     * @param command
     * @param commandInfo
     * @param printable
     * @param simpleArgs
     * @param complexArgs
     * @return command {@link UserCommand}
     * @throws Exception
     */
    private itmo.commands.UserCommand createCommand(Class<? extends itmo.commands.UserCommand> command, CommandInfo commandInfo, Printable printable, List<String> simpleArgs, List<Object> complexArgs) throws Exception {
        List<Object> finalArgs = new ArrayList<>();
        if (commandInfo.getIsQueue()){
            finalArgs.add(organizationQueue);
        }
        if (commandInfo.getIsPrintable()){
            finalArgs.add(printable);
        }
        finalArgs.addAll(simpleArgs);
        finalArgs.addAll(complexArgs);
        return (itmo.commands.UserCommand) command.getConstructors()[0].newInstance(finalArgs.toArray());
    }

    /**
     * @param commandInfo
     * @param words
     * @return list of simple arguments
     */
    private List<String> scanSimpleArgs(CommandInfo commandInfo, List<String> words) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < commandInfo.getSimpleArgs(); ++i){
            list.add(words.get(1 + i));
        }
        return list;
    }

    /**
     * @param command
     * @param commandInfo
     * @param printable
     * @param scannable
     * @return list of complex arguments as Object
     * @throws Exception
     */
    private List<Object> scanComplexArgs(Class<? extends itmo.commands.UserCommand> command, CommandInfo commandInfo, Printable printable, Scannable scannable) throws Exception {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < commandInfo.getComplexArgs(); ++i){
            Constructor constructor = (Constructor) commandInfo.getComplexConstructors().get(i).getConstructors()[0].newInstance(printable, scannable);
            list.add(constructor.scanConstruct());
        }
        return list;
    }

    /**
     * @return command {@link UserCommand}
     * @throws Exception
     */
    public UserCommand commandFromConsole() throws Exception {
        Printable printable = new ConsolePrint();
        Scannable scannable = new ConsoleScan(printable);
        printable.print("Enter command name: ");

        String input = scannable.scanLine();

        List<String> words = getWordList(input);
        Class<? extends itmo.commands.UserCommand> command = getCommand(words.get(0));
        CommandInfo commandInfo = getCommandInfo(command);

        List<String> simpleArgs = scanSimpleArgs(commandInfo, words);
        List<Object> complexArgs = askComplexArgs(command, commandInfo, printable, scannable);

        itmo.commands.UserCommand userCommand = createCommand(command, commandInfo, printable, simpleArgs, complexArgs);
        return userCommand;
    }

    /**
     * @param scannable
     * @return list of itmo.commands
     * @throws Exception
     */
    public List<itmo.commands.UserCommand> commandsFromFile(Scannable scannable) throws Exception {
        List<itmo.commands.UserCommand> userCommands = new ArrayList<>();
        int lineNumber = 0;
        while (scannable.hasNextLine()){
            ++lineNumber;
            String line = scannable.scanLine();
            if (line == null)
                break;
            if (line.equals(""))
                continue;
            List<String> words = getWordList(line);

            Class<? extends itmo.commands.UserCommand> command;

            try {
                command = getCommand(words.get(0));
            } catch (Exception e) {
                System.out.println();
                System.out.println("---------------Exception---------------");
                System.out.println(e.getMessage() + " on line " + lineNumber);
                System.out.println("---------------------------------------");
                System.out.println();
                break;
            }
            CommandInfo commandInfo = getCommandInfo(command);

            List<String> simpleArgs = scanSimpleArgs(commandInfo, words);
            List<Object> complexArgs = scanComplexArgs(command, commandInfo, null, scannable);
            itmo.commands.UserCommand userCommand = createCommand(command, commandInfo, new ConsolePrint(), simpleArgs, complexArgs);
            userCommands.add(userCommand);
        }
        return userCommands;
    }
}
