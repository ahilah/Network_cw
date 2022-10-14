package hileta.com.menu.management;

import hileta.com.menu.command.*;
import hileta.com.menu.command.add.AddCommand;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainCommand {

    private final Map<String, MenuCommand> menuItems;
    private final Network operatorNetwork;
    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_RESET = "\u001b[0m";

    public MainCommand() {
        operatorNetwork = executeNewNetwork();
        menuItems = new LinkedHashMap<>();
        FillMenuItems();
    }

    private Network executeNewNetwork() {
        CreateNetworkCommand createNetworkCommand = new CreateNetworkCommand();
        createNetworkCommand.execute();
        return createNetworkCommand.networkCompanyInfo();
    }

    private void FillMenuItems() {
        menuItems.put("Add new object.", new AddCommand(operatorNetwork));
        menuItems.put("Edit object.", new EditCommand(operatorNetwork));
        menuItems.put("View object.", new ViewCommand(operatorNetwork));
        menuItems.put("Sort tariffs of their price.", new SortCommand(operatorNetwork));
        menuItems.put("Delete tariff.", new DeleteCommand(operatorNetwork));
        menuItems.put("Archive tariff.", new ArchiveCommand(operatorNetwork));
        menuItems.put("Calculate general number of customers.", new NumberCustomersCommand(operatorNetwork));
        menuItems.put("Exit.", new ExitCommand());
    }

    public void execute(int numberOfCommand) {
        int position = 0;
        for(Map.Entry<String, MenuCommand> command : menuItems.entrySet()) {
            if(numberOfCommand == position) {
                command.getValue().execute();
                return;
            }
            position++;
        }
        System.out.println(ANSI_RED + " Incorrect command! Try again." + ANSI_RESET);
    }

    public void showAvailableCommands() {
        int nCommand = 1;
        for (String nameCommand : menuItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }




    /*

    private List<MenuCommand> menuItems;
    menuItems = new ArrayList<>();

        menuItems.add(new AddCommand(operatorNetwork));
        menuItems.add(new EditCommand(operatorNetwork));
        menuItems.add(new ViewCommand(operatorNetwork));
        menuItems.add(new SortCommand(operatorNetwork));
        menuItems.add(new DeleteCommand(operatorNetwork));
        menuItems.add(new ArchiveCommand(operatorNetwork));
        menuItems.add(new NumberCustomersCommand(operatorNetwork));
        menuItems.add(new ExitCommand());

        try {
            menuItems.get(numberOfCommand).execute();
        } catch (Exception var3) {
            System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
        }

        for(int i = 0, j = i + 1; i < menuItems.size(); ++j, ++i) {
            System.out.println(j + " - " + menuItems.get(i).getCommandInfo());


        */
}
