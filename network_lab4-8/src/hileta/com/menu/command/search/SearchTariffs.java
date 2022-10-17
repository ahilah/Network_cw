package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class SearchTariffs implements MenuCommand {
    private Network network;
    public SearchTariffs(Network network) {
        this.network = network;
    }
    @Override
    public void execute() {

    }
}
