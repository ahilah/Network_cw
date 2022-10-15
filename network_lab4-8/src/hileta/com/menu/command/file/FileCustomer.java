package hileta.com.menu.command.file;

import hileta.com.network.Customer;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCustomer extends FileCommand {
    //private Network network;

    public FileCustomer(Network network) {
       super(network);
    }

    @Override
    public void execute() {
        super.execute();
        try { // open file
            buff = new BufferedReader(new FileReader(filePath));
            String[] customerInfo;
            String line = buff.readLine();
            while(line != null) {
                customerInfo = line.split(" ");
                network.addCustomer(getNewCustomer(customerInfo));
                line = buff.readLine();
            }
            buff.close();
            System.out.println("\n\tAdded customers:");
            network.showCustomers();
        }
        catch (IOException e) {
            System.out.println("Can't open: " + filePath);
        }
    }

    private Customer getNewCustomer(String[] customerInfo) {
        return new Customer(customerInfo[0], customerInfo[1]);
    }
}
