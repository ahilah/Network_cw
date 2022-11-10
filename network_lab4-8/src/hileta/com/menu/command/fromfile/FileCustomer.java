package hileta.com.menu.command.fromfile;

import hileta.com.network.Customer;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FileCustomer extends FileCommand {
    private static Logger logger = LogManager.getLogger(FileCustomer.class);
    public FileCustomer(Network network) {
       super(network);
    }

    public FileCustomer(Network network, String filePath) {
        //super(network);
        super(network, filePath);
    }

    @Override
    public void execute() {
        logger.info("Read customers data from file was executed");
        int numberCustomers = network.getNumberCustomers();
        try {
            getFileData();
            logger.info("Dta was successfully read");
            showAddedCustomers(numberCustomers);
        }
        catch (IOException e) {
            System.out.println(ANSI_RED + "\n\t\tCan't open: " + filePath + ANSI_RESET);
        }
    }

    private void getFileData() throws IOException {
        boolean isFileNotCorrect = true;
        while (isFileNotCorrect) {
            try {
                // open file
                buff = new BufferedReader(new FileReader(filePath));
                String[] customerInfo;
                String line = buff.readLine();
                while (line != null) {
                    customerInfo = line.split(" ");
                    Customer newCustomer = getNewCustomer(customerInfo);
                    if (newCustomer != null)
                        network.addCustomer(newCustomer);
                    else
                        System.out.println(ANSI_RED + "\tLine " + line + " contains incorrect parameters." + ANSI_RESET);
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

    private Customer getNewCustomer(String[] customerInfo) {
        Customer customer = null;
        if(!network.isCustomerAlreadyExist(customerInfo[1]))
            customer = new Customer(customerInfo[0], customerInfo[1]);
        return customer;
    }

    private void showAddedCustomers(int numberCustomers) {
        System.out.println("\n\t\tAdded customers:");
        for(int i = numberCustomers, j = 1; i < network.getNumberCustomers(); i++, j++) {
            System.out.println(j + ". " + network.getCustomer(i));
        }
    }
}
