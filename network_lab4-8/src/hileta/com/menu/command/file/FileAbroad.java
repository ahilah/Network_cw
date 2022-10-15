package hileta.com.menu.command.file;

import hileta.com.network.Abroad;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAbroad extends FileCommand {

    //private Network network;

    public FileAbroad(Network network) {
        super(network);
    }

    @Override
    public void execute() {
        super.execute();
        try { // open file
            buff = new BufferedReader(new FileReader(filePath));
            String[] abroadInfo;
            String line = buff.readLine();
            while(line != null) {
                abroadInfo = line.split(" ");
                network.addAbroad(getNewAbroad(abroadInfo));
                line = buff.readLine();
            }
            buff.close();
            System.out.println("\n\tAdded abroad:");
            network.showAbroad();
        }
        catch (IOException e) {
            System.out.println("Can't open: " + filePath);
        }
    }

    private Abroad getNewAbroad(String[] abroadInfo) {
        return new Abroad(abroadInfo[0], Double.parseDouble(abroadInfo[1]));
    }
}
