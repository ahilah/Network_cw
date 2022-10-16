package hileta.com.menu.management;

import hileta.com.menu.command.*;
import hileta.com.menu.command.add.Add;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.LinkedHashMap;
import java.util.Map;

public class MainCommand {

    private final Map<String, MenuCommand> menuItems;
    public final Network operatorNetwork;
    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_RESET = "\u001b[0m";

    public MainCommand() {
        operatorNetwork = executeNewNetwork();
        menuItems = new LinkedHashMap<>();
        FillMenuItems();
    }

    private Network executeNewNetwork() {
        CreateNetwork createNetworkCommand = new CreateNetwork();
        createNetworkCommand.execute();
        return createNetworkCommand.networkCompanyInfo();
    }

    private void FillMenuItems() {
        menuItems.put("Add new object.", new Add(operatorNetwork));
        menuItems.put("Edit object.", new Edit(operatorNetwork));
        menuItems.put("View object.", new View(operatorNetwork));
        menuItems.put("Sort tariffs of their price.", new Sort(operatorNetwork));
        menuItems.put("Delete tariff.", new Delete(operatorNetwork));
        menuItems.put("Archive tariff.", new Archive(operatorNetwork));
        menuItems.put("Calculate general number of customers.", new NumberCustomers(operatorNetwork));
        menuItems.put("Exit.", new Exit());
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




    /*

    private List<MenuCommand> menuItems;
    menuItems = new ArrayList<>();

        menuItems.add(new Add(operatorNetwork));
        menuItems.add(new Edit(operatorNetwork));
        menuItems.add(new View(operatorNetwork));
        menuItems.add(new Sort(operatorNetwork));
        menuItems.add(new Delete(operatorNetwork));
        menuItems.add(new Archive(operatorNetwork));
        menuItems.add(new NumberCustomers(operatorNetwork));
        menuItems.add(new Exit());

        try {
            menuItems.get(numberOfCommand).execute();
        } catch (Exception var3) {
            System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
        }

        for(int i = 0, j = i + 1; i < menuItems.size(); ++j, ++i) {
            System.out.println(j + " - " + menuItems.get(i).getCommandInfo());


        */
}
