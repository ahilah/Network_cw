package hileta.com.menu.command.file;

import hileta.com.network.Customer;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FileCustomer extends FileCommand {

    public FileCustomer(Network network) {
       super(network);
    }

    @Override
    public void execute() {
        super.execute();
        int numberCustomers = network.getNumberCustomers();
        try {
            getFileData();
            showAddedCustomers(numberCustomers);
        }
        catch (IOException e) {
            System.out.println("Can't open: " + filePath);
        }
    }

    private void getFileData() throws IOException {
        // open file
        buff = new BufferedReader(new FileReader(filePath));
        String[] customerInfo;
        String line = buff.readLine();
        while(line != null) {
            customerInfo = line.split(" ");
            Customer newCustomer = getNewCustomer(customerInfo);
            if(newCustomer != null)
                network.addCustomer(newCustomer);
            else System.out.println(ANSI_RED + "Line " + line + " contains incorrect parameters." + ANSI_RESET);
            line = buff.readLine();
        }
        buff.close();
    }

    private Customer getNewCustomer(String[] customerInfo) {
        Customer customer = null;
        if(!network.isCustomerAlreadyExist(customerInfo[1]))
            customer = new Customer(customerInfo[0], customerInfo[1]);
        return customer;
    }

    private void showAddedCustomers(int numberCustomers) {
        System.out.println("\n\tAdded customers:");
        for(int i = numberCustomers; i < network.getNumberCustomers(); i++) {
            System.out.println(network.getCustomer(i));
        }
    }
}
