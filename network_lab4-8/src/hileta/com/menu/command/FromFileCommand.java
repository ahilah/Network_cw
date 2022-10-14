package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class FromFileCommand implements MenuCommand {
    private String COMMAND_INFO = "input from file";
    private final Network network;

    public FromFileCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("from file.");
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}