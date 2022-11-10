package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class Archive implements MenuCommand {
    private static Logger logger = LogManager.getLogger(Archive.class);
    public static final String ANSI_GREEN = "\u001b[32m";
    private final Network network;
    Scanner scanner;
    public Archive(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    public void execute() {
        logger.info("Archive command executed");
        if (network.isListTariffsEmpty()) {
            logger.fatal("There are no tariffs to delete");
            System.out.println(ANSI_RED + "\t Fill tariff list!" + ANSI_RESET);
            return;
        }
        System.out.println("\n\t\tEnter 1 for archive all available tariffs 0 for archive one tariff.");
        System.out.print("Type here: ");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (userChoice != 1) {
               logger.info("Delete one tariff");
                int tariffNumber = getNumberOfTariff();
                network.archiveTariff(network.getTariff(tariffNumber));
                network.deleteTariff(tariffNumber);
                logger.info("Tariff with ID " + tariffNumber + " was deleted");
                System.out.println(ANSI_GREEN + "\n\tTariff was successfully archived!" + ANSI_RESET);
            } else {
                logger.info("Archive all tariffs");
                network.archiveAllAvailableTariffs();
                System.out.println(ANSI_GREEN + "\n\tAll tariffs was successfully archived!" + ANSI_RESET);
            }
        }
        catch (NumberFormatException e){
            logger.fatal("Wrong input number");
            System.out.println("Wrong input line!");
        }
    }

    private int getNumberOfTariff() {
        System.out.println("\n\t There are available tariffs: ");
        network.showTariffs();
        System.out.print("Type number of tariff here: ");
        try {
            int numberOfTariff = Integer.parseInt(scanner.nextLine());
            --numberOfTariff;
            if (numberOfTariff > network.getNumberAvailableTariffs() - 1 || numberOfTariff < 0) {
                logger.fatal("Tariff with number " + numberOfTariff + " does not exist");
                logger.warn("Set default tariff number 0");
                numberOfTariff = 0;
            }
            return numberOfTariff;
        } catch (NumberFormatException e) {
            logger.fatal("Incorrect input line of tariff number");
            System.out.println("Wrong input line!");
            return 0;
        }
    }
}


    /*
    public String getCommandInfo() {
        return COMMAND_INFO;
    }
    //private String COMMAND_INFO = "archive tariff";
    */

