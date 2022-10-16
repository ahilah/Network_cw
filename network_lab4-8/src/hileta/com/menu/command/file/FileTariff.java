package hileta.com.menu.command.file;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FileTariff extends FileCommand {
    //private Network network;
    //private BufferedReader buff;
    //private String filePath;

    public FileTariff(Network network) {
        super(network);
        //this.filePath = getFilePath();
    }

    /*private String getFilePath() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type file path: ");
        return scanner.nextLine();
    }*/

    @Override
    public void execute() {
        //String filePath = getFilePath();
        super.execute();
        int numberTariffs = network.getNumberAvailableTariffs();
            try { // open file
                readFile();
                showAddedTariffs(numberTariffs);
            }
            catch (IOException e) {
                System.out.println("Can't open: " + filePath);
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

    private void readFile() throws IOException {
        buff = new BufferedReader(new FileReader(filePath));
        //int isEndFile = Integer.parseInt(buff.readLine());
        int [] info = getAmountAndTariffType(buff.readLine());
        BaseTariff baseTariff;
        String[] tariffInfo;
        while(info != null) {
            for(int i = 0; i < info[1]; i++) {
                tariffInfo = buff.readLine().split(" ");
                switch(info[0]) {
                    case 1 -> baseTariff = getNewStartTariff(tariffInfo);
                    case 2 -> baseTariff = getNewSuperTariff(tariffInfo);
                    default -> baseTariff = getNewSuperNetTariff(tariffInfo);
                }
                checkTariffCorrect(baseTariff);
            }
            info = getAmountAndTariffType(buff.readLine());
        }
        buff.close();
    }

    private void checkTariffCorrect(BaseTariff baseTariff) {
        if (!network.isTariffAlreadyExist(baseTariff.getTariffID()))
            network.addTariff(baseTariff);
        else System.out.println(ANSI_RED + "\nTariff " +
                baseTariff + "\nalready exists in list!" + ANSI_RESET);
    }

    private void showAddedTariffs(int numberTariffs) {
        //int newNumberTariffs = network.getNumberAvailableTariffs();
        System.out.println("\n\tAdded tariffs:");
        for(int i = numberTariffs; i < network.getNumberAvailableTariffs(); i++) {
            System.out.println(network.getTariff(i));
        }
    }
}
