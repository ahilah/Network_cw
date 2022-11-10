package hileta.com.menu.command.add;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.menu.command.fromfile.FromFile;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class AddCommand {
    private static Logger logger = LogManager.getLogger(AddCommand.class);
    private final Map<String, MenuCommand> menuItems;
    public final Network network;
    public AddCommand(Network network) {
        this.network = network;
        menuItems = new LinkedHashMap<>();
        fillMenuItems();
    }
    private void fillMenuItems() {
        logger.info("fill add menu items");
        menuItems.put("Add new tariff.", new AddTariff(network));
        menuItems.put("Add new customer.", new AddCustomer(network));
        menuItems.put("Add new mobile number.", new AddMobileNumber(network));
        menuItems.put("Add new abroad.", new AddAbroad(network));
        menuItems.put("Read data from file.", new FromFile(network));
    }

    public void execute(int numberOfCommand) {
        int position = 1;
        for(Map.Entry<String, MenuCommand> command : menuItems.entrySet()) {
            if(numberOfCommand == position) {
                command.getValue().execute();
                return;
            }
            position++;
        }
        logger.error("Incorrect number of command");
        System.out.println(ANSI_RED + "\n\tIncorrect command! Try again." + ANSI_RESET);
    }

    public void showAvailableCommands() {
        logger.info("Show list od adding command");
        int nCommand = 1;
        for (String nameCommand : menuItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }
}
