
/* package hileta.com.menu.command.edit;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class Edit implements MenuCommand {
    private final EditCommand editCommand;
    public Edit(Network network) {
        editCommand = new EditCommand(network);
    }
    public void execute() {
        while (true) {
            System.out.println("\n\n\tPres " + ANSI_RED + "0 " + ANSI_RESET +
                    "for end editing items.\n\tAvailable commands: ");
            this.editCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            try {
                int command = Integer.parseInt(scanner.nextLine());
                if (command != 0) editCommand.execute(command);
                else {
                    System.out.println(ANSI_PURPLE + "\n\tEditing data was successfully over!" + ANSI_RESET);
                    return;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Wrong input line!");
            }
        }
    }
}

/*
package hileta.com.menu.command.edit;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.LinkedHashMap;
import java.util.Map;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class EditCommand {
    private final Map<String, MenuCommand> menuItems;
    public final Network network;
    public EditCommand(Network network) {
        this.network = network;
        menuItems = new LinkedHashMap<>();
        fillMenuItems();
    }
    private void fillMenuItems() {
        menuItems.put("Edit tariff.", new EditTariff(network));
        menuItems.put("Edit mobile number.", new EditMobileNumber(network));
    }
    public void execute(int numberOfCommand) {
        int position = 1;
        for(Map.Entry<String, MenuCommand> command : menuItems.entrySet()) {
            if(numberOfCommand == position) {
                command.getValue().execute();
                return;
            }
            position++;
        }
        System.out.println(ANSI_RED + "\n\tIncorrect command! Try again." + ANSI_RESET);
    }
    public void showAvailableCommands() {
        int nCommand = 1;
        for (String nameCommand : menuItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }
}
------------------------------------------------------------------------------------------

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
        int i = Integer.parseInt(scanner.nextLine());
        return --i;
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
-------------------------------------------------------------------------------------------------

package hileta.com.menu.command.edit;

import hileta.com.Tariff.BaseTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class EditTariff implements MenuCommand {
    private final Network network;

    public EditTariff(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {
        if(network.isListTariffsEmpty()) {
            System.out.println(ANSI_RED +
                    "\n\tList of tariffs is empty. Please, input data firstly. " + ANSI_RESET);
            return;
        }
        int tariffNumber = getNumberTariff();
        String [] tariffInfo = getInputTariffInfo();
        BaseTariff startTariff = network.getTariff(tariffNumber);
        editBaseTariff(startTariff, tariffInfo);
        System.out.println("\n\t\tEdited tariff: ");
        System.out.println(network.getTariff(tariffNumber));
    }

    private int getNumberTariff() {
        System.out.println("\n\t Choose number to edit: ");
        network.showTariffs();
        System.out.print("Type here: ");
        int i = Integer.parseInt(scanner.nextLine());
        return --i;
    }
    private String[] getInputTariffInfo() {
        System.out.println("\n\tEnter your tariff parameters like [name]---[sms]--[]--[]--[]");
        System.out.print("Type: ");
        String tariffInputInfo = scanner.nextLine();
        return splitString(tariffInputInfo);
    }
    public String[] splitString(String inputString) {
        String delims = "[-.,?!]+";
        return inputString.split(delims);
    }
    public void editBaseTariff(BaseTariff tariff, String [] tariffInfo) {
        //tariff = tariff.setSMSNumber(Integer.parseInt(tariffInfo[0]))
        .setNumberMinutesThisOperator(Double.parseDouble(tariffInfo[1]))
        .setPriceTariff(Integer.parseInt(tariffInfo[2]))
        .setTariffID(tariffInfo[3]);
        }
        }

---------------------------------------------------------------


    //private String COMMAND_INFO = "edit object";
    public String getCommandInfo() {
        return COMMAND_INFO;
    }

-------------------------------------------------------------------------------------------

*/