package hileta.com;

import hileta.com.commandable.MenuCommand;

public class ExitCommand implements MenuCommand {
    private String COMMAND_INFO = "exit";
    private static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_RESET = "\u001b[0m";

    public ExitCommand() {
    }

    public void execute() {
        System.out.println(ANSI_PURPLE + "\n\n\t Program is ended." + ANSI_RESET);
        System.exit(0);
    }

    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }
}
