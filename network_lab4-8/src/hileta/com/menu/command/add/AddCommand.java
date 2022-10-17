package hileta.com.menu.command.add;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.menu.command.fromfile.FromFile;
import hileta.com.network.Network;

import java.util.LinkedHashMap;
import java.util.Map;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class AddCommand {
    private final Map<String, MenuCommand> menuItems;
    public final Network network;


    public AddCommand(Network network) {
        this.network = network;
        menuItems = new LinkedHashMap<>();
        fillMenuItems();
    }

    private void fillMenuItems() {
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
        System.out.println(ANSI_RED + "\n\tIncorrect command! Try again." + ANSI_RESET);
    }

    public void showAvailableCommands() {
        int nCommand = 1;
        for (String nameCommand : menuItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }
}
