package hileta.com.menu.command.edit;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class EditTariff implements MenuCommand {
    private final Network network;

    public EditTariff(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {

    }
}
