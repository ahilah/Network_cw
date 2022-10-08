package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;

import java.util.Scanner;

public class ArchiveCommand implements MenuCommand {
    private static final String ANSI_GREEN = "\u001b[32m";
    private static final String ANSI_RESET = "\u001b[0m";
    private String COMMAND_INFO = "archive tariff";
    private Network network;

    public ArchiveCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        this.network.archiveTariff(this.network.getTariff(this.getNumberOfTariff()));
        System.out.println("\u001b[32mTariff was successfully archived!\u001b[0m");
    }

    private int getNumberOfTariff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\t There are available commands: ");
        this.network.showTariffs();
        System.out.print("Type number of tariff here: ");
        int numberOfTariff = scanner.nextInt();
        --numberOfTariff;
        return numberOfTariff;
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }
}

