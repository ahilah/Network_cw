package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class NumberCustomers implements MenuCommand {

    private Network network;

    public NumberCustomers(Network network) {
        this.network = network;
    }

    public void execute() {
        int numberCustomersInAvailableTariffs = numberCustomers(network.getNumberAvailableTariffs());
        int numberCustomersInArchivedTariffs = numberCustomers(network.getNumberArchivedTariffs());
        System.out.println("\nGeneral number of customers: ");
        System.out.print(numberCustomersInArchivedTariffs + numberCustomersInAvailableTariffs);
    }

    private int numberCustomers(int numberTariffs) {
        int numberCustomers = 0;
        for(int i = 0; i < numberTariffs; ++i) {
            numberCustomers += network.getTariff(i).getNumberOfUsers();
        }
        return numberCustomers;
    }

    /*
    public String getCommandInfo() {
        return COMMAND_INFO;
    }
    //private String COMMAND_INFO = "calculate general number of customers";
    */
}

