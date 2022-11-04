package hileta.com.menu.command;

import hileta.com.Tariff.BaseTariff;
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
                case 1 -> showTariffs();
                case 2 -> showArchive();
                case 3 -> {
                    System.out.println("\n\t\t Customers list: ");
                    network.showCustomers();
                }
                case 4 -> {
                    System.out.println("\n\t\t Mobile numbers list: ");
                    network.showMobileNumbers();
                }
                case 5 -> showAbroad();
                case 6 -> network.getNetworkInfo();
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
                    6 - company network info.
                    0 - to exit.""".indent(0));
        System.out.print("Type here: ");
        try {
            return Integer.parseInt(scanner.nextLine()); //scanner.nextInt();
        }
        catch (NumberFormatException e){
            System.out.println("Wrong input line!");
            return 666;
        }
    }
    private void showTariffs() {
        System.out.println("\n\t\t Available tariffs list: ");
        PrintTariffsHeadOfList();
        if (network.isListTariffsEmpty()) PrintEmptyTariffsList();
        else {
            for(BaseTariff tariff : network.getAvailableTariffs())
                System.out.println(tariff.rowTable());
        }
        //network.showTariffs();
    }
    private void PrintTariffsHeadOfList() {
        System.out.println("|---------------------------------" +
                "-----|-----------|--------------|-----------|----------------|-----------|" +
                "---------------|---------------|----------|");
        System.out.println("|              Tariff name         " +
                "    |    SMS    | Min this net |   Price   |   Tariff ID    | Customers |" +
                " Min other net | Min countries | Internet |");
        System.out.println("|---------------------------------" +
                "-----|-----------|--------------|-----------|----------------|-----------|" +
                "---------------|---------------|----------|");
    }
    private void PrintEmptyTariffsList() {
        System.out.println("|                                                              There are no tariffs                                                                   |");
        System.out.println("|---------------------------------" +
                "--------------------------------------------------------------------------" +
                "------------------------------------------|");
    }
    private void showArchive() {
        System.out.println("\n\t\t Archived tariffs list: ");
        PrintTariffsHeadOfList();
        if (network.getArchivedTariffs().isEmpty()) PrintEmptyTariffsList();
        else network.showArchive();
        //network.showArchive();
    }
    private void showAbroad() {
        System.out.println("\n\t\t Abroad list: ");
        printAbroadHeadList();
        if (network.getListAbroad().isEmpty()) printEmptyRowAbroad();
        else network.showAbroad();
    }
    private void printAbroadHeadList() {
        System.out.println("|----------------------------------------------|");
        System.out.println("|           Country             |     Price    |");
        System.out.println("|----------------------------------------------|");
    }
    private void printEmptyRowAbroad() {
        System.out.println("|              There are no abroad             |");
        System.out.println("|----------------------------------------------|");
    }
}
