package itmo.commands;

import itmo.constructors.Constructor;

import java.util.List;

/**
 * Describe command {@link UserCommand}
 * @author Gabriela Ticu
 */
public class CommandInfo {

    /**
     * Simple arguments
     */
    private int simpleArgs;
    /**
     * Complex arguments
     */
    private int complexArgs;
    /**
     * does command use queue
     */
    private boolean isQueue;
    /**
     * does command use printable {@link itmo.iowork.Printable}
     */
    private boolean isPrintable;
    /**
     * Constructor {@link Constructor} classes
     */
    private List<Class<? extends Constructor>> complexConstructors;

    /**
     * @param simpleArgs
     * @param complexArgs
     * @param isQueue
     * @param isPrintable
     * @param complexConstructors
     */
    public CommandInfo(int simpleArgs, int complexArgs, boolean isQueue, boolean isPrintable, List<Class<? extends Constructor>> complexConstructors) {
        this.simpleArgs = simpleArgs;
        this.complexArgs = complexArgs;
        this.isQueue = isQueue;
        this.isPrintable = isPrintable;
        this.complexConstructors = complexConstructors;
    }

    /**
     * @return simple arguments
     */
    public int getSimpleArgs(){
        return simpleArgs;
    }

    /**
     * @return complex arguments
     */
    public int getComplexArgs(){
        return complexArgs;
    }

    /**
     * @return is queue
     */
    public boolean getIsQueue(){
        return isQueue;
    }

    /**
     * @return is printable
     */
    public boolean getIsPrintable(){
        return isPrintable;
    }

    /**
     * @return Constructor {@link Constructor} classes
     */
    public List<Class<? extends Constructor>> getComplexConstructors() {
        return complexConstructors;
    }
}
