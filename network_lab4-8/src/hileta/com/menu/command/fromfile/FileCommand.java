package hileta.com.menu.command.fromfile;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.util.Scanner;

public abstract class FileCommand implements MenuCommand {
    private static Logger logger = LogManager.getLogger(FileCommand.class);
    protected Network network;
    protected BufferedReader buff;
    protected String filePath;
    public FileCommand(Network network) {
        this.network = network;
        this.filePath = getFilePath();
    }

    public FileCommand(Network network, String filePath) {
        this.network = network;
        this.filePath = filePath;
    }

    @Override
    public void execute() {
       this.filePath = getFilePath();
    }

    public String getFilePath() {
        logger.info("Get file path was executed");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type file path: ");
        return scanner.nextLine();
    }
}
