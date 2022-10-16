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
        int numberArchivedTariffs = network.getNumberArchivedTariffs();
        //network.showTariffs();
        archiveTariffs(numberTariffs);
        showArchiveChanges(numberArchivedTariffs);
        /* System.out.println("------------------------");
        network.showTariffs();*/
    }

    private void archiveTariffs(int numberTariffs) {
        int numberTariffsArchive = network.getNumberAvailableTariffs();
        for (int i = numberTariffs; i < numberTariffsArchive; i++) {
            network.archiveTariff(network.getTariff(i));
        }

        for (int i = numberTariffs; i < numberTariffsArchive; i++) {
            network.deleteTariff(numberTariffs);
        }
    }

    private void showArchiveChanges(int numberArchivedTariffs) {
        System.out.println("\n\t\tArchive of added tariffs: ");
        for(int i = numberArchivedTariffs, j = 1; i < network.getNumberArchivedTariffs(); i++, j++) {
            System.out.println(j + ". " + network.getArchivedTariff(i));
        }
    }
}
