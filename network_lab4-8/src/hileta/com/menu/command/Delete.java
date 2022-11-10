package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.menu.management.MainCommand;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static hileta.com.menu.command.Archive.ANSI_GREEN;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class Delete implements MenuCommand {
    private static Logger logger = LogManager.getLogger(MainCommand.class);
    private final Network network;
    public Delete(Network network) {
        this.network = network;
    }
    public void execute() {
        int tariffNumber = getNumberOfTariff();
        if (network.getTariff(tariffNumber).getNumberOfUsers() != 0) {
            logger.warn("Try to delete tariff that has users");
            System.out.print("\n\n\tThis tariff has users. Choose another tariff to connect them to it: ");
            /*network.showTariffs();
            System.out.print("\nType here: ");*/
            int anotherTariff;
            try {
                anotherTariff = Integer.parseInt(scanner.nextLine());
                --anotherTariff;
                logger.info("User chooses tariff");
            }
            catch (NumberFormatException e){
                logger.fatal("Incorrect input line (not int or incorrect tariff ID)");
                System.out.println("Wrong input line!");
                anotherTariff = 0;
            }
        changeTariffsAfterRemoving(tariffNumber, anotherTariff);
            logger.info("Change users tariff in order to delete previous");
        }
        logger.info("Delete tariff: " + network.getTariff(tariffNumber).getTariffID());
        network.deleteTariff(tariffNumber);
        System.out.println(ANSI_GREEN + "\n\t\tTariff was successfully deleted!" + ANSI_RESET);
    }

    public void changeTariffsAfterRemoving(int oldID, int newID) {
        String oldTariffID = network.getTariff(oldID).getTariffID();
        String newTariffID = network.getTariff(newID).getTariffID();
        for(MobileNumber mobileNumber : network.getListMobileNumbers()) {
            if(mobileNumber.getTariffID().equals(oldTariffID)) {
                mobileNumber.setTariffID(newTariffID);
            }
        }
        logger.info("Removing tariff was successful");
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
        catch (NumberFormatException e) {
            logger.fatal("Incorrect input line (not int)");
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

