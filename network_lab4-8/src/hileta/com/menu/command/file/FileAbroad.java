package hileta.com.menu.command.file;

import hileta.com.network.Abroad;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileAbroad extends FileCommand {

    public FileAbroad(Network network) {
        super(network);
    }

    @Override
    public void execute() {
        super.execute();
        int numberAbroad = network.getNumberAbroad();
        try { // open file
            readData();
            showAddedAbroad(numberAbroad);
        }
        catch (IOException e) {
            System.out.println("Can't open: " + filePath);
        }
    }

    private void readData() throws IOException {
        buff = new BufferedReader(new FileReader(filePath));
        String[] abroadInfo;
        String line = buff.readLine();
        while(line != null) {
            abroadInfo = line.split(" ");
            network.addAbroad(getNewAbroad(abroadInfo));
            line = buff.readLine();
        }
        buff.close();
    }

    private Abroad getNewAbroad(String[] abroadInfo) {
        return new Abroad(abroadInfo[0], Double.parseDouble(abroadInfo[1]));
    }

    private void showAddedAbroad(int numberAbroad) {
        System.out.println("\n\tAdded abroad:");
        for(int i = numberAbroad; i < network.getNumberAbroad(); i++) {
            System.out.println(network.getAbroad(i));
        }
    }
}
