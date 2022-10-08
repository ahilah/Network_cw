package hileta.com.menu.management;

import hileta.com.menu.command.*;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.menu.management.command.commandable.*;

import java.util.ArrayList;
import java.util.List;

public class MainCommand {
    private List<MenuCommand> menuItems = new ArrayList();
    private Network operatorNetwork = new Network();
    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_RESET = "\u001b[0m";

    public MainCommand() {
        this.menuItems.add(new AddCommand(this.operatorNetwork));
        this.menuItems.add(new EditCommand(this.operatorNetwork));
        this.menuItems.add(new ViewCommand(this.operatorNetwork));
        this.menuItems.add(new SortCommand(this.operatorNetwork));
        this.menuItems.add(new DeleteCommand(this.operatorNetwork));
        this.menuItems.add(new ArchiveCommand(this.operatorNetwork));
        this.menuItems.add(new NumberCustomersCommand(this.operatorNetwork));
        this.menuItems.add(new ExitCommand());
    }

    public void execute(int numberOfCommand) {
        try {
            ((MenuCommand)this.menuItems.get(numberOfCommand)).execute();
        } catch (Exception var3) {
            System.out.println("\u001b[31mIncorrect command! Try again.\u001b[0m");
        }

    }

    public void showAvailableCommands() {
        int i = 0;

        for(int j = i + 1; i < this.menuItems.size(); ++j) {
            System.out.println("" + j + " - " + ((MenuCommand)this.menuItems.get(i)).getCommandInfo());
            ++i;
        }

    }
}
