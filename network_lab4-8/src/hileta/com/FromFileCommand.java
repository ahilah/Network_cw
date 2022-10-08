package hileta.com;

import hileta.com.commandable.MenuCommand;

public class FromFileCommand implements MenuCommand {
    private String COMMAND_INFO = "input from file";
    private Network network;

    public FromFileCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("from file.");
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }
}