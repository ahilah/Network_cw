package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.command.Archive.ANSI_GREEN;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class Delete implements MenuCommand {
    private final Network network;
    public Delete(Network network) {
        this.network = network;
    }
    public void execute() {
        int tariffNumber = getNumberOfTariff();
        if (network.getTariff(tariffNumber).getNumberOfUsers() != 0) {
            System.out.print("\n\n\tThis tariff has users. Choose another tariff to connect them to it: ");
            /*network.showTariffs();
            System.out.print("\nType here: ");*/
            int anotherTariff;
            try {
                anotherTariff = Integer.parseInt(scanner.nextLine());
                --anotherTariff;
            }
            catch (NumberFormatException e){
                System.out.println("Wrong input line!");
                anotherTariff = 0;
            }
            String oldTariffID = network.getTariff(tariffNumber).getTariffID();
            String newTariffID = network.getTariff(anotherTariff).getTariffID();
            for(MobileNumber mobileNumber : network.getListMobileNumbers()) {
                if(mobileNumber.getTariffID().equals(oldTariffID)) {
                    mobileNumber.setTariffID(newTariffID);
                }
            }
        }
        network.deleteTariff(tariffNumber);
        System.out.println(ANSI_GREEN + "\n\t\tTariff was successfully deleted!" + ANSI_RESET);
    }

    private int getNumberOfTariff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t There are available tariffs: ");
        try {
            network.showTariffs();
            System.out.print("Type number of tariff here: ");
            int numberOfTariff = Integer.parseInt(scanner.nextLine());
            --numberOfTariff;
            return numberOfTariff;
        }
        catch (NumberFormatException e){
            System.out.println("Wrong input line!");
            return  0;
        }
    }
}


    /*
    //private String COMMAND_INFO = "delete tariff";
    public String getCommandInfo() {
        return COMMAND_INFO;
    }*/

