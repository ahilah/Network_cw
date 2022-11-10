package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class Search implements MenuCommand {
    private static Logger logger = LogManager.getLogger(Search.class);
    private final Network network;
    private SearchCommand searchCommand;
    public Search(Network network) {
        this.network = network;
        searchCommand = new SearchCommand(network);
    }

    public void execute() {
        logger.info("Search command was executed");
        while (true) {
            System.out.println("\n\n\tPres " + ANSI_RED + "0 " + ANSI_RESET +
                    "for end searching.\n\tAvailable commands: ");
            searchCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            try {
                int command = Integer.parseInt(scanner.nextLine());
                if (command != 0) searchCommand.execute(command);
                else {
                    logger.info("Searching data was over");
                    System.out.println(ANSI_PURPLE + "\n\tSearching data is successfully over!" + ANSI_RESET);
                    return;
                }
            }
            catch (NumberFormatException e) {
                logger.error("Wrong input line (not int)");
                System.out.println("Wrong input line!");
            }
        }
    }

    /*

    public String getCommandInfo() {
        return COMMAND_INFO;
    }
    //private String COMMAND_INFO = "view object";
    */
}
