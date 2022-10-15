package hileta.com.menu.command.file;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class FileTariffsArchive implements MenuCommand {
    private Network network;
    public FileTariffsArchive(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {
        FileTariff fileTariff = new FileTariff(network);
        fileTariff.execute();
        network.archiveAllAvailableTariffs();
        System.out.println("\n\tArchive of tariffs: ");
        network.showArchive();
    }
}
