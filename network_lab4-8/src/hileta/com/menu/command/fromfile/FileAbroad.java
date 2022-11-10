package hileta.com.menu.command.fromfile;

import hileta.com.network.Abroad;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FileAbroad extends FileCommand {
    private static Logger logger = LogManager.getLogger(FileAbroad.class);
    public FileAbroad(Network network) {
        super(network);
    }

    public FileAbroad(Network network, String filePath) {
        //super(network);
        super(network, filePath);
    }


    @Override
    public void execute() {
        logger.info("Read abroad data from file was executed");
        int numberAbroad = network.getNumberAbroad();
        try { // open file
            readData();
            logger.info("Dta was successfully read");
            showAddedAbroad(numberAbroad);
        }
        catch (IOException e) {
            logger.error("Can't open: " + filePath);
            System.out.println(ANSI_RED + "\n\t\tCan't open: " + filePath + ANSI_RESET);
        }
    }

    private void readData() throws IOException {
        boolean isFileNotCorrect = true;
        while (isFileNotCorrect) {
            try {
                buff = new BufferedReader(new FileReader(filePath));
                String[] abroadInfo;
                String line = buff.readLine();
                while (line != null) {
                    abroadInfo = line.split(" ");
                    network.addAbroad(getNewAbroad(abroadInfo));
                    line = buff.readLine();
                }
                isFileNotCorrect = false;
                buff.close();
            } catch (IOException e) {
                logger.error("Can't open: " + filePath);
                System.out.println(ANSI_RED + "\n\t\tCan't open: " + filePath + ANSI_RESET);
                logger.warn("Get new file path");
                filePath = super.getFilePath();
            }
        }
    }

    private Abroad getNewAbroad(String[] abroadInfo) {
        return new Abroad(abroadInfo[0], Double.parseDouble(abroadInfo[1]));
    }

    private void showAddedAbroad(int numberAbroad) {
        System.out.println("\n\t\tAdded abroad:");
        for(int i = numberAbroad, j = 1; i < network.getNumberAbroad(); i++, j++) {
            System.out.println(j + ". " + network.getAbroad(i));
        }
    }
}
