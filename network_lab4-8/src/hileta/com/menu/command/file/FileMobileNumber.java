package hileta.com.menu.command.file;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class FileMobileNumber implements MenuCommand {
    private Network network;

    public FileMobileNumber(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {

    }
}
