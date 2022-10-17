package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class SearchAbroad implements MenuCommand {
    private Network network;
    public SearchAbroad(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {
        while(true) {
            System.out.print("\n\t Enter country: ");
            String country = scanner.nextLine();
            for (int i = 0; i < network.getNumberAbroad(); i++) {
                if (network.getAbroad(i).getCountry().equals(country)) {
                    System.out.println(network.getAbroad(i));
                    return;
                }
            }
            System.out.println(ANSI_RED + "\n\tIncorrect country, try again!" + ANSI_RESET);
        }
    }
}
