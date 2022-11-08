package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Abroad;
import hileta.com.network.Network;

import java.util.List;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class SearchAbroad implements MenuCommand {
    private final Network network;
    public SearchAbroad(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {
        while(true) {
            System.out.print("\n\t Enter country: ");
            String country = scanner.nextLine();
            Abroad abroad = searchAbroad(country);
            if (abroad == null) {
                System.out.println(ANSI_RED + "\n\tIncorrect country, try again!" + ANSI_RESET);
                return;
            }
        }
    }

    public Abroad searchAbroad(String country) {
        List<Abroad> abroad = network.getListAbroad();
        Abroad abrd = null;
        for (int i = 0; i < abroad.size(); i++) {
            abrd = abroad.get(i);
            if (abrd.getCountry().equals(country)) {
                System.out.println(network.getAbroad(i));
                break;
            }
        }
        return abrd;
    }
}
