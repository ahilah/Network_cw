package hileta.com.command;

import hileta.com.command.commandable.MenuCommand;

public class NumberCustomersCommand implements MenuCommand {
    private String COMMAND_INFO = "calculate general number of customers";
    private Network network;

    public NumberCustomersCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        int numberCustomersInAvailableTariffs = this.numberCustomers(this.network.getNumberAvailableTariffs());
        int numberCustomersInArchivedTariffs = this.numberCustomers(this.network.getNumberArchivedTariffs());
        System.out.println("\nGeneral number of customers: " + numberCustomersInArchivedTariffs + numberCustomersInAvailableTariffs);
    }

    private int numberCustomers(int numberTariffs) {
        int numberCustomers = 0;

        for(int i = 0; i < numberTariffs; ++i) {
            numberCustomers += this.network.getTariff(i).getNumberOfUsers();
        }

        return numberCustomers;
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }
}

