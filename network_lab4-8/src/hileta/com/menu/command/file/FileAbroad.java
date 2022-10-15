package hileta.com.menu.command.file;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class FileAbroad implements MenuCommand {

    private Network network;

    public FileAbroad(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {

    }
}
