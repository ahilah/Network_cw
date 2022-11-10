package hileta.com.menu.command.fromfile;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FromFileCommand {
    private static Logger logger = LogManager.getLogger(FromFileCommand.class);
    private final Map<String, MenuCommand> fileItems;
    public final Network network;

    public FromFileCommand(Network network) {
        this.network = network;
        fileItems = new LinkedHashMap<>();
        FillFileItems();
    }

    private void FillFileItems() {
        logger.info("Fill file reading commands");
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
                logger.info("Reading from file command was found");
                command.getValue().execute();
                return;
            }
            position++;
        }
        logger.fatal("Command " + numberOfCommand + " does not exist");
        System.out.println(ANSI_RED + "\n\tIncorrect command! Try again." + ANSI_RESET);
    }

    public void showAvailableCommands() {
        logger.info("Show available reading from file commands");
        int nCommand = 1;
        for (String nameCommand : fileItems.keySet()) {
            System.out.println(nCommand + ". " + nameCommand);
            nCommand++;
        }
    }
}
