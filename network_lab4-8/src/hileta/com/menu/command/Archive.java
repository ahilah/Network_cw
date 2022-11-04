package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class Archive implements MenuCommand {
    public static final String ANSI_GREEN = "\u001b[32m";
    private final Network network;
    Scanner scanner;
    public Archive(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("\n\t\tEnter 1 for archive all available tariffs 0 for archive one tariff.");
        System.out.print("Type here: ");
        try {
            int userChoice = Integer.parseInt(scanner.nextLine());
            if (userChoice != 1) {
                int tariffNumber = getNumberOfTariff();
                network.archiveTariff(network.getTariff(tariffNumber));
                network.deleteTariff(tariffNumber);
                System.out.println(ANSI_GREEN + "\n\tTariff was successfully archived!" + ANSI_RESET);
            } else {
                network.archiveAllAvailableTariffs();
                System.out.println(ANSI_GREEN + "\n\tAll tariffs was successfully archived!" + ANSI_RESET);
            }
        }
        catch (NumberFormatException e){
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
            return numberOfTariff;
        } catch (NumberFormatException e){
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

