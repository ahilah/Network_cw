package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class Exit implements MenuCommand {
    private static Logger logger = LogManager.getLogger(Exit.class);
    public void execute() {
        logger.info("End of program");
        System.out.println(ANSI_PURPLE + "\n\n\t Program is ended.\n" + ANSI_RESET);
        System.exit(0);
    }
}

    /*
    //private String COMMAND_INFO = "exit";

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }*/
