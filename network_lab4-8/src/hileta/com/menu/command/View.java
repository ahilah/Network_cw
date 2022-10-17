package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class View implements MenuCommand {
    private final Network network;

    public View (Network network) {
        this.network = network;
    }

    @Override
    public void execute() {
        while (true) {
            switch (getUserDecisionObject()) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("\n\t\t Available tariffs list: ");
                    network.showTariffs();
                }
                case 2 -> {
                    System.out.println("\n\t\t Archived tariffs list: ");
                    network.showArchive();
                }
                case 3 -> {
                    System.out.println("\n\t\t Customers list: ");
                    network.showCustomers();
                }
                case 4 -> {
                    System.out.println("\n\t\t Mobile numbers list: ");
                    network.showMobileNumbers();
                }
                case 5 -> {
                    System.out.println("\n\t\t Abroad list: ");
                    network.showAbroad();
                }
                default -> System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
            }
        }
    }

    private int getUserDecisionObject() {
        System.out.println("\n\nPress to view");
        System.out.print("""
                    1 - available tariffs list.
                    2 - archived tariffs list.
                    3 - customers list.
                    4 - mobile numbers list.
                    5 - abroad list.
                    0 - to exit.""".indent(0));
        System.out.print("Type here: ");
        return Integer.parseInt(scanner.nextLine()); //scanner.nextInt();
    }
}
