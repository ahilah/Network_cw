package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class Edit implements MenuCommand {

    private Network network;

    public Edit(Network network) {
        network = network;
    }

    public void execute() {
        System.out.println("edit");
    }




    /*
    //private String COMMAND_INFO = "edit object";
    public String getCommandInfo() {
        return COMMAND_INFO;
    }


    */
}
