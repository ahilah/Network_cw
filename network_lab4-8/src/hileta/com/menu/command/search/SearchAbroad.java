package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Abroad;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class SearchAbroad implements MenuCommand {
    private static Logger logger = LogManager.getLogger(SearchAbroad.class);
    private final Network network;
    public SearchAbroad(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {
        logger.info("Search abroad command was executed");
        while(true) {
            System.out.print("\n\t Enter country: ");
            logger.warn("Name of country was inputted");
            String country = scanner.nextLine();
            Abroad abroad = searchAbroad(country);
            if (abroad == null) {
                logger.error("Incorrect name of country " + country);
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
                logger.info("Country was found");
                System.out.println(network.getAbroad(i));
                break;
            }
        }
        return abrd;
    }
}