package hileta.com.command;

import hileta.com.command.commandable.MenuCommand;

public class ViewCommand implements MenuCommand {
    private String COMMAND_INFO = "view object";
    private Network network;

    public ViewCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("view");
        this.network.showAbroad();
        this.network.showTariffs();
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }
}
