package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class SearchMobileNumbers implements MenuCommand {
    private Network network;
    public SearchMobileNumbers(Network network) {
        this.network = network;
    }
    @Override
    public void execute() {

    }
}
