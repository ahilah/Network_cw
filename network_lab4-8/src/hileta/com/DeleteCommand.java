package hileta.com;

import hileta.com.commandable.MenuCommand;

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
        this.network.deleteTariff(this.getNumberOfTariff());
        System.out.println("\u001b[32mTariff was successfully deleted!\u001b[0m");
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

