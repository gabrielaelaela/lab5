package itmo.commands;

import java.io.IOException;

public interface UserCommand {
    /**
     * Execute command method
     * @throws IOException
     */
    void execute() throws IOException;
}
