package hileta.com.menu.command.fromfile;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.LinkedHashMap;
import java.util.Map;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FromFileCommand {
    private final Map<String, MenuCommand> fileItems;
    public final Network network;

    public FromFileCommand(Network network) {
        this.network = network;
        fileItems = new LinkedHashMap<>();
        FillFileItems();
    }

    private void FillFileItems() {
        fileItems.put("Read new tariffs.", new FileTariff(network));
        fileItems.put("Read archived tariffs.", new FileTariffsArchive(network));
        fileItems.put("Read new customers.", new FileCustomer(network));
        fileItems.put("Read new mobile numbers.", new FileMobileNumber(network));
        fileItems.put("Read new abroad.", new FileAbroad(network));

    }

    public void execute(int numberOfCommand) {
            int position = 1;
            for (Map.Entry<String, MenuCommand> command : fileItems.entrySet()) {
                if (numberOfCommand == position) {
                    command.getValue().execute();
                    return;
                }
                position++;
            }
            System.out.println(ANSI_RED + "\n\tIncorrect command! Try again." + ANSI_RESET);
    }

    public void showAvailableCommands() {
        int nCommand = 1;
        for (String nameCommand : fileItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }
}
