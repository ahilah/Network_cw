package hileta.com.menu.management;

import hileta.com.menu.command.*;
import hileta.com.menu.command.commandable.MenuCommand;

import hileta.com.network.Network;

import java.util.ArrayList;
import java.util.List;

public class MainCommand {
    private List<MenuCommand> menuItems;
    private Network operatorNetwork;
    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_RESET = "\u001b[0m";

    public MainCommand() {
        operatorNetwork = executeNewNetwork();
        menuItems = new ArrayList<>();
        FillMenuItems();
    }

    private Network executeNewNetwork() {
        CreateNetworkCommand createNetworkCommand = new CreateNetworkCommand();
        createNetworkCommand.execute();
        return createNetworkCommand.networkCompanyInfo();
    }

    private void FillMenuItems() {
        menuItems.add(new AddCommand(operatorNetwork));
        menuItems.add(new EditCommand(operatorNetwork));
        menuItems.add(new ViewCommand(operatorNetwork));
        menuItems.add(new SortCommand(operatorNetwork));
        menuItems.add(new DeleteCommand(operatorNetwork));
        menuItems.add(new ArchiveCommand(operatorNetwork));
        menuItems.add(new NumberCustomersCommand(operatorNetwork));
        menuItems.add(new ExitCommand());
    }

    public void execute(int numberOfCommand) {
        try {
            menuItems.get(numberOfCommand).execute();
        } catch (Exception var3) {
            System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
        }
    }

    public void showAvailableCommands() {
        for(int i = 0, j = i + 1; i < menuItems.size(); ++j, ++i) {
            System.out.println(j + " - " + menuItems.get(i).getCommandInfo());
        }
    }
}
