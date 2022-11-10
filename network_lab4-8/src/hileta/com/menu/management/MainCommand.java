package hileta.com.menu.management;

import hileta.com.menu.command.*;
import hileta.com.menu.command.add.Add;
import hileta.com.menu.command.calculate.Calculate;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.menu.command.search.Search;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;


public class MainCommand {
    private static Logger logger = LogManager.getLogger(MainCommand.class);
    private final Map<String, MenuCommand> menuItems;
    private final Network operatorNetwork;

    public static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_RESET = "\u001b[0m";

    public MainCommand() {
        operatorNetwork = executeNewNetwork();
        menuItems = new LinkedHashMap<>();
        fillMenuItems();
    }

    private Network executeNewNetwork() {
        CreateNetwork createNetworkCommand = new CreateNetwork();
        createNetworkCommand.execute();
        return createNetworkCommand.networkCompanyInfo();
    }

    private void fillMenuItems() {
        logger.info("Fill menu items");
        menuItems.put("Add new object.", new Add(operatorNetwork));
        //menuItems.put("Edit object.", new Edit(operatorNetwork));
        menuItems.put("View object.", new View(operatorNetwork));
        menuItems.put("Search object.", new Search(operatorNetwork));
        menuItems.put("Sort tariffs of their price.", new Sort(operatorNetwork));
        menuItems.put("Delete tariff.", new Delete(operatorNetwork));
        menuItems.put("Archive tariff.", new Archive(operatorNetwork));
        menuItems.put("Calculate general number of customers.", new Calculate(operatorNetwork));
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
        logger.warn("Incorrect command: " + numberOfCommand);
    }

    public void showAvailableCommands() {
        logger.info("Show all commands");
        int nCommand = 1;
        for (String nameCommand : menuItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }
}



    /*

    private List<MenuCommand> menuItems;
    menuItems = new ArrayList<>();

        menuItems.add(new Add(operatorNetwork));
        menuItems.add(new Edit(operatorNetwork));
        menuItems.add(new Search(operatorNetwork));
        menuItems.add(new Sort(operatorNetwork));
        menuItems.add(new Delete(operatorNetwork));
        menuItems.add(new Archive(operatorNetwork));
        menuItems.add(new Calculate(operatorNetwork));
        menuItems.add(new Exit());

        try {
            menuItems.get(numberOfCommand).execute();
        } catch (Exception var3) {
            System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
        }

        for(int i = 0, j = i + 1; i < menuItems.size(); ++j, ++i) {
            System.out.println(j + " - " + menuItems.get(i).getCommandInfo());


        */
