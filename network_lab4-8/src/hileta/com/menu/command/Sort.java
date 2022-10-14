package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class Sort implements MenuCommand {
    //private String COMMAND_INFO = "sort tariffs of their price";
    private Network network;

    public Sort(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("sort");
        network.sortTariffs();
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}