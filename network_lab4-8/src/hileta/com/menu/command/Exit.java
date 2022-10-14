package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class Exit implements MenuCommand {
    //private String COMMAND_INFO = "exit";

    public void execute() {
        System.out.println(ANSI_PURPLE + "\n\n\t Program is ended." + ANSI_RESET);
        System.exit(0);
    }

    /*public String getCommandInfo() {
        return this.COMMAND_INFO;
    }*/
}
