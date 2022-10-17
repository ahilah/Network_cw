package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class Search implements MenuCommand {
    private final Network network;
    private SearchCommand searchCommand;
    public Search(Network network) {
        this.network = network;
        searchCommand = new SearchCommand(network);
    }

    public void execute() {
        while (true) {
            System.out.println("\n\n\tPres " + ANSI_RED + "0 " + ANSI_RESET +
                    "for end searching.\n\tAvailable commands: ");
            searchCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            int command = Integer.parseInt(scanner.nextLine());
            if (command != 0) searchCommand.execute(command);
            else {
                System.out.println(ANSI_PURPLE + "\n\tInput data from file was successfully over!" + ANSI_RESET);
                return;
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
