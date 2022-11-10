package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.menu.command.search.tariffs.SearchTariffs;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class SearchCommand {
    private static Logger logger = LogManager.getLogger(SearchCommand.class);
    private final Network network;
    private final Map<String, MenuCommand> menuItems;
    public SearchCommand(Network network) {
        this.network = network;
        menuItems = new LinkedHashMap<>();
        fillMenuItems();
    }

    private void fillMenuItems() {
        logger.info("Fill searching menu items");
        menuItems.put("Search tariffs with parameters from .", new SearchTariffs(network));
        menuItems.put("Search debtors.", new SearchDebtors(network));
        menuItems.put("Search customer's mobile numbers.", new SearchMobileNumbers(network));
        menuItems.put("Search abroad.", new SearchAbroad(network));
    }

    public void execute(int numberOfCommand) {
        int position = 1;
        for(Map.Entry<String, MenuCommand> command : menuItems.entrySet()) {
            if(numberOfCommand == position) {
                command.getValue().execute();
                logger.info("Command was found");
                return;
            }
            position++;
        }
        logger.error("Incorrect type of command");
        System.out.println(ANSI_RED + "\n\tIncorrect command! Try again." + ANSI_RESET);
    }

    public void showAvailableCommands() {
        logger.info("Show available searching commands");
        int nCommand = 1;
        for (String nameCommand : menuItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }
}
