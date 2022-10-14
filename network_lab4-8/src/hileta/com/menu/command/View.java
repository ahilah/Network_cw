package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class View implements MenuCommand {
    //private String COMMAND_INFO = "view object";
    private Network network;

    public View(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("view");
        this.network.showAbroad();
        this.network.showTariffs();
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}
