package hileta.com.menu.command.edit;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class Edit implements MenuCommand {
    private final EditCommand editCommand;
    public Edit(Network network) {
        editCommand = new EditCommand(network);
    }
    public void execute() {
        while (true) {
            System.out.println("\n\n\tPres " + ANSI_RED + "0 " + ANSI_RESET +
                    "for end editing items.\n\tAvailable commands: ");
            this.editCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            try {
                int command = Integer.parseInt(scanner.nextLine());
                if (command != 0) editCommand.execute(command);
                else {
                    System.out.println(ANSI_PURPLE + "\n\tEditing data was successfully over!" + ANSI_RESET);
                    return;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Wrong input line!");
            }
        }
    }
}

/*
    //private String COMMAND_INFO = "edit object";
    public String getCommandInfo() {
        return COMMAND_INFO;
    }
    */
