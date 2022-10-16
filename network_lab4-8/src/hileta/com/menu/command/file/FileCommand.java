package hileta.com.menu.command.file;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.util.Scanner;

public abstract class FileCommand implements MenuCommand {

    protected Network network;

    protected BufferedReader buff;

    protected String filePath;


    public FileCommand(Network network) {
        this.network = network;
        //this.filePath = getFilePath();
    }

    @Override
    public void execute() {
       this.filePath = getFilePath();
    }

    private String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type file path: ");
        return scanner.nextLine();
    }
}
