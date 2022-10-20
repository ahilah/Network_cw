package hileta.com.menu.command.calculate;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

public class Calculate implements MenuCommand {
    private final Network network;
    final String delimited = "\n----------------------------------------";
    public Calculate(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("\n\n\t\tNetwork company info: ");
        showTariffInfo();
        showCustomerInfo();
        showMobileNumbersInfo();
        System.out.println("\n");
    }

    private void showTariffInfo() {
        System.out.print("\tGeneral tariff number: ");
        System.out.print(network.getNumberAvailableTariffs() + network.getNumberArchivedTariffs());
        System.out.print("\n\tNumber of available tariffs:  ");
        System.out.print(network.getNumberAvailableTariffs());
        System.out.print("\n\tNumber of archived tariffs:  ");
        System.out.print(network.getNumberArchivedTariffs());
        System.out.println(delimited);
    }

    private void showCustomerInfo() {
        System.out.print("\n\tGeneral number of users: ");
        System.out.print(network.getNumberCustomers());
        System.out.println(delimited);
    }

    private void showMobileNumbersInfo() {
        System.out.print("\n\tGeneral number of mobile numbers: ");
        System.out.print(network.getNumberMobileNumbers());
        CalculateNumberTariff calculateAvailableTariffs = new CalculateNumberTariff(network.getAvailableTariffs()),
                calculateArchivedTariffs = new CalculateNumberTariff(network.getArchivedTariffs());
        System.out.print("\n\tNumber tariffs of type Start Tariff: ");
        System.out.print(calculateAvailableTariffs.getStartNumber() + calculateArchivedTariffs.getStartNumber());
        System.out.print("\n\tNumber tariffs of type Super Tariff: ");
        System.out.print(calculateAvailableTariffs.getSuperNumber() + calculateArchivedTariffs.getSuperNumber());
        System.out.print("\n\tNumber tariffs of type Super Net Tariff: ");
        System.out.print(calculateAvailableTariffs.getSuperNetNumber() + calculateArchivedTariffs.getSuperNetNumber());
    }

    /*
    public String getCommandInfo() {
        return COMMAND_INFO;
    }
    //private String COMMAND_INFO = "calculate general number of customers";

    private int numberCustomers(int numberTariffs) {
        int numberCustomers = 0;
        for(int i = 0; i < numberTariffs; ++i) {
            numberCustomers += network.getTariff(i).getNumberOfUsers();
        }
        return numberCustomers;
    }

    int numberCustomersInAvailableTariffs = numberCustomers(network.getNumberAvailableTariffs());
        int numberCustomersInArchivedTariffs = numberCustomers(network.getNumberArchivedTariffs());
        System.out.println("\nGeneral number of customers: ");
        System.out.print(numberCustomersInArchivedTariffs + numberCustomersInAvailableTariffs);
    */
}

