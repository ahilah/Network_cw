package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class Archive implements MenuCommand {
    public static final String ANSI_GREEN = "\u001b[32m";

    //private String COMMAND_INFO = "archive tariff";
    private Network network;

    public Archive(Network network) {
        this.network = network;
    }

    public void execute() {
        int tariffNumber = getNumberOfTariff();
        network.archiveTariff(network.getTariff(tariffNumber));
        network.deleteTariff(tariffNumber);
        System.out.println(ANSI_GREEN + "Tariff was successfully archived!" + ANSI_RESET);
    }

    private int getNumberOfTariff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t There are available commands: ");
        network.showTariffs();
        System.out.print("Type number of tariff here: ");
        int numberOfTariff = Integer.parseInt(scanner.nextLine());
        --numberOfTariff;
        return numberOfTariff;
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}

