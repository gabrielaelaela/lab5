package itmo.commands;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;

/**
 * List of command
 * @author Gabriela Ticu
 */
public class CommandList {

    /**
     * list of itmo.commands
     */
    public static List<Class<? extends UserCommand>> commandList = new ArrayList<>();

    /**
     * @param packageName
     */
    public static void FillList(String packageName) {
        Reflections reflections = new Reflections(packageName);
        commandList.addAll(reflections.getSubTypesOf(UserCommand.class));
    }
}
