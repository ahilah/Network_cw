package hileta.com.menu.command.edit;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class EditMobileNumber implements MenuCommand {
    private final Network network;
    public EditMobileNumber(Network network) {
        this.network = network;
    }
    @Override
    public void execute() {
        if(network.isListTariffsEmpty() || network.isListCustomersEmpty() || network.isListMobileNumbersEmpty()) {
            System.out.println(ANSI_RED +
                    "\n\tList of tariffs or customers or mobile numbers is empty. Please, input data firstly. "
                    + ANSI_RESET);
            return;
        }
        int number = getNumber();
        String newCustomerID = getNewCustomerID(number);
        double newBalance = getNewBalance(number);
        String newTariffID = getNewTariffID(number);
        network.getMobileNumber(number).setBalance(newBalance);
        network.getMobileNumber(number).setUserID(newCustomerID);
        network.getMobileNumber(number).setTariffID(newTariffID);
        System.out.println("\n\tMobile number has been edited: ");
        System.out.println(network.getMobileNumber(number));
    }
    private int getNumber() {
        System.out.println("\n\t Choose number to edit: ");
        network.showMobileNumbers();
        System.out.print("\nType here: ");
        return Integer.parseInt(scanner.nextLine());
    }
    private String getNewCustomerID(int number) {
        System.out.println("\n\tChoose new customer: ");
        network.showCustomers();
        System.out.print("\nType customer ID: ");
        String newCustomerID = scanner.nextLine().replaceAll("\\s+", "");
        if(!network.isCustomerAlreadyExist(newCustomerID)) {
            System.out.println(ANSI_RED + "\n\tCustomer hasn't been found!" + ANSI_RESET);
            newCustomerID = network.getMobileNumber(number).getUserID();
        }
        return newCustomerID;
    }
    private double getNewBalance(int number) {
        System.out.print("\nEnter new balance: ");
        double newBalance = Double.parseDouble(scanner.nextLine());
        if (newBalance < 0) {
            System.out.println(ANSI_RED + "\n\tBalance can't be less, than 0!" + ANSI_RESET);
            newBalance = network.getMobileNumber(number).getBalance();
        }
        return newBalance;
    }
    private String getNewTariffID(int number) {
        System.out.println("\n\tChoose new tariff: ");
        network.showTariffs();
        System.out.print("\nType tariff ID: ");
        String newTariffID = scanner.nextLine();
        if (!network.isTariffAvailableExists(newTariffID)) {
            System.out.println(ANSI_RED + "\n\tIncorrect tariff ID!" + ANSI_RESET);
            newTariffID = network.getMobileNumber(number).getTariffID();
        }
        return newTariffID;
    }
}
