package hileta.com.menu.command.fromfile;

import hileta.com.Tariff.BaseTariff;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FileMobileNumber extends FileCommand {
    //private Network network;

    public FileMobileNumber(Network network) {
        super(network);
    }

    @Override
    public void execute() {
        super.execute();
        if (network.isListCustomersEmpty() || network.isListTariffsEmpty()) {
            System.out.println(ANSI_RED +
                    "List of tariffs or customers is empty. Create at least one object of both!"
                    + ANSI_RESET);
            return;
        }
        int sizeMobileNumbers = network.getNumberMobileNumbers();
        try {
            readData();
            showAddedNumbers(sizeMobileNumbers);
        }
        catch (IOException e) {
            System.out.println(ANSI_RED + "\n\t\tCan't open: " + filePath + ANSI_RESET);
        }
    }

    private void readData() throws IOException {
        // open file
        buff = new BufferedReader(new FileReader(filePath));
        MobileNumber newMobileNumber;
        String[] mobileNumberInfo;
        String line = buff.readLine();
        while(line != null) {
            mobileNumberInfo = line.split(" ");
            newMobileNumber = getNewMobileNumber(mobileNumberInfo);
            if (newMobileNumber != null) {
                network.addMobileNumber(newMobileNumber);
                BaseTariff tariff = network.searchTariff(newMobileNumber.getTariffID());
                tariff.setNumberOfUsers(tariff.getNumberOfUsers() + 1);
            }
            else System.out.println(ANSI_RED + "\n\tLine " + line + " contains incorrect parameters." + ANSI_RESET);
            line = buff.readLine();
        }
        buff.close();
    }

    private MobileNumber getNewMobileNumber(String[] mobileNumberInfo) {
        MobileNumber mobileNumber = null;
        if(isParametersCorrect(mobileNumberInfo))
            mobileNumber = new MobileNumber(mobileNumberInfo[0], mobileNumberInfo[1],
                    mobileNumberInfo[2], Double.parseDouble(mobileNumberInfo[3]));
        return mobileNumber;
    }

    private boolean isParametersCorrect(String[] mobileNumberInfo) {
        return network.isTariffAlreadyExists(mobileNumberInfo[1]) &&
                network.isCustomerAlreadyExist(mobileNumberInfo[2]) &&
                Double.parseDouble(mobileNumberInfo[3]) >= 0 &&
                !network.isMobileNumberAlreadyExist(mobileNumberInfo[0]);
    }

    private void showAddedNumbers(int sizeMobileNumbers) {
        System.out.println("\n\tAdded mobile numbers:");
        for(int i = sizeMobileNumbers, j = 1; i < network.getNumberMobileNumbers(); i++, j++) {
            System.out.println(j + ". " + network.getMobileNumber(i));
        }
    }
}
