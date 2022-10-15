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
        int numberTariffs = network.getNumberAvailableTariffs();
        fileTariff.execute();
        int numberTariffsArchive = network.getNumberAvailableTariffs();
        for (int i = numberTariffs; i < network.getNumberAvailableTariffs(); i++) {
            network.archiveTariff(network.getTariff(i));
        }

        /*for (int i = numberTariffs; i < network.getNumberAvailableTariffs(); i++) {
            network.archiveTariff(network.getTariff(i));
        }*/

        //network.archiveAllAvailableTariffs();

        System.out.println("\n\tArchive of tariffs: ");
        network.showArchive();
    }
}
