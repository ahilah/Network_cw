package hileta.com.menu.command.fromfile;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FileTariff extends FileCommand {
    private static Logger logger = LogManager.getLogger(FileTariff.class);
    //private Network network;
    //private BufferedReader buff;
    //private String filePath;

    public FileTariff(Network network) {
        super(network);
        //this.filePath = getFilePath();
    }

    public FileTariff(Network network, String filePath) {
        //super(network);
        super(network, filePath);
    }

    /*private String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type file path: ");
        return scanner.nextLine();
    }*/

    @Override
    public void execute() {
        //String filePath = getFilePath();
        //super.execute();
        logger.info("Read tariffs from file command was executed");
        int numberTariffs = network.getNumberAvailableTariffs();
        try { // open file
            readFile();
            logger.info("Data was successfully read");
            showAddedTariffs(numberTariffs);
        }
        catch (IOException e) {
            logger.error("Can't open: " + filePath);
            System.out.println(ANSI_RED + "\n\t\tCan't open: " + filePath + ANSI_RESET);
        }
    }

    private void readFile() throws IOException {
        boolean isFileNotCorrect = true;
        while(isFileNotCorrect) {
            try {
                buff = new BufferedReader(new FileReader(filePath));
                //int isEndFile = Integer.parseInt(buff.readLine());
                int[] info = getAmountAndTariffType(buff.readLine());
                BaseTariff baseTariff;
                String[] tariffInfo;
                while (info != null) {
                    for (int i = 0; i < info[1]; i++) {
                        tariffInfo = buff.readLine().split(" ");
                        switch (info[0]) {
                            case 1 -> baseTariff = getNewStartTariff(tariffInfo);
                            case 2 -> baseTariff = getNewSuperTariff(tariffInfo);
                            default -> baseTariff = getNewSuperNetTariff(tariffInfo);
                        }
                        checkTariffCorrect(baseTariff);
                    }
                    info = getAmountAndTariffType(buff.readLine());
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

    private int [] getAmountAndTariffType(String inputString) {
        int[] numbers = null;
        if (inputString != null) {
            String[] stringNumbers = inputString.split(" ");
            numbers = new int[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }
        }
        return numbers;
    }
    private BaseTariff getNewStartTariff(String[] tariffInfo) {
        return new StartTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4]);
    }
    private BaseTariff getNewSuperTariff(String[] tariffInfo) {
        return new SuperTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]));
    }
    private BaseTariff getNewSuperNetTariff(String[] tariffInfo) {
        return new SuperNetTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]),
                Double.parseDouble(tariffInfo[7]));
    }
    private void checkTariffCorrect(BaseTariff baseTariff) {
        if (!network.isTariffAlreadyExists(baseTariff.getTariffID())) {
            logger.info("New tariff was successfully added");
            network.addTariff(baseTariff);
        }
        else {
            logger.warn("Attempt to add already existing tariff with ID " + baseTariff.getTariffID());
            System.out.println(ANSI_RED + "\nTariff " +
                    baseTariff + "\nalready exists in list!" + ANSI_RESET);
        }
    }
    private void showAddedTariffs(int numberTariffs) {
        //int newNumberTariffs = network.getNumberAvailableTariffs();
        System.out.println("\n\t\tAdded tariffs:");
        for(int i = numberTariffs, j = 1; i < network.getNumberAvailableTariffs(); i++, j++) {
            System.out.println(j + ". " + network.getTariff(i));
        }
    }
}