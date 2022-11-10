package hileta.com.menu.command;

import hileta.com.Tariff.BaseTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Sort implements MenuCommand {
    //private String COMMAND_INFO = "sort tariffs of their price";
    private static Logger logger = LogManager.getLogger(Sort.class);
    private Network network;

    public Sort(Network network) {
        this.network = network;
    }

    public void execute() {
        logger.info("Sort command executed");
        network.sortAvailableTariffs();
        System.out.println("\n\t\t Sorted tariffs by price: ");
        PrintTariffsHeadOfList();
        if (network.isListTariffsEmpty()) {
            logger.warn("Try to sort empty list");
            PrintEmptyTariffsList();
        }
        else {
            logger.info("Sorting by price was successful");
            for(BaseTariff tariff : network.getAvailableTariffs())
                System.out.println(tariff.rowTable());
        }
    }

    private void PrintTariffsHeadOfList() {
        System.out.println("|---------------------------------" +
                "-----|-----------|--------------|-----------|----------------|-----------|" +
                "---------------|---------------|----------|");
        System.out.println("|              Tariff name         " +
                "    |    SMS    | Min this net |   Price   |   Tariff ID    | Customers |" +
                " Min other net | Min countries | Internet |");
        System.out.println("|---------------------------------" +
                "-----|-----------|--------------|-----------|----------------|-----------|" +
                "---------------|---------------|----------|");
    }
    private void PrintEmptyTariffsList() {
        System.out.println("|                                                              There are no tariffs                                                                   |");
        System.out.println("|---------------------------------" +
                "--------------------------------------------------------------------------" +
                "------------------------------------------|");
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}
