package hileta.com;

import hileta.com.commandable.MenuCommand;

public class EditCommand implements MenuCommand {
    private String COMMAND_INFO = "edit object";
    private Network network;

    public EditCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("edit");
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }
}
