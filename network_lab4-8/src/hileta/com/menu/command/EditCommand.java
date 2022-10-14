package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class EditCommand implements MenuCommand {
    //private String COMMAND_INFO = "edit object";
    private Network network;

    public EditCommand(Network network) {
        network = network;
    }

    public void execute() {
        System.out.println("edit");
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}
