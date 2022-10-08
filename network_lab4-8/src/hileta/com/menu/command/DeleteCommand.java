package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

public class DeleteCommand implements MenuCommand {
    private static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_RESET = "\u001b[0m";
    private String COMMAND_INFO = "delete tariff";
    private Network network;

    public DeleteCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        network.deleteTariff(getNumberOfTariff());
        System.out.println(ANSI_GREEN + "Tariff was successfully deleted!" + ANSI_RESET);
    }

    private int getNumberOfTariff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t There are available commands: ");
        network.showTariffs();
        System.out.print("Type number of tariff here: ");
        int numberOfTariff = scanner.nextInt();
        --numberOfTariff;
        return numberOfTariff;
    }

    public String getCommandInfo() {
        return COMMAND_INFO;
    }
}

