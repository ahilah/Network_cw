package hileta.com;

import hileta.com.commandable.MenuCommand;

public class AddCommand implements MenuCommand {
    private String COMMAND_INFO = "add new object";
    private Network network;

    public AddCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("add");
        this.network.addAbroad();
        this.network.addCustomer();
        this.network.addNumber();
        (new FromFileCommand(this.network)).execute();
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }
}
