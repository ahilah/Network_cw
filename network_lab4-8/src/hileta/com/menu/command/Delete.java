package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.command.Archive.ANSI_GREEN;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class Delete implements MenuCommand {
    //private String COMMAND_INFO = "delete tariff";
    private Network network;

    public Delete(Network network) {
        this.network = network;
    }

    public void execute() {
        network.deleteTariff(getNumberOfTariff());
        System.out.println(ANSI_GREEN + "Tariff was successfully deleted!" + ANSI_RESET);
    }

    private int getNumberOfTariff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t There are available tariffs: ");
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

