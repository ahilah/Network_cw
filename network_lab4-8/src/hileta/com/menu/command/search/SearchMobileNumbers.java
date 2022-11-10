package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class SearchMobileNumbers implements MenuCommand {
    private static Logger logger = LogManager.getLogger(SearchMobileNumbers.class);
    private final Network network;
    private List<MobileNumber> customerNumbers;
    public SearchMobileNumbers(Network network) {
        this.network = network;
        customerNumbers = new ArrayList<>();
    }

    @Override
    public void execute() {
        logger.info("Searching mobile numbers was executed");
        String customerID = getCustomerID();
        if(!customerNumbers.isEmpty()) {
            System.out.println("\n\t\t Mobile numbers of customer " + network.getCustomer(customerID).getName());
            int i = 1;
            for (MobileNumber mobileNumber : customerNumbers) {
                System.out.println(i + ". " + mobileNumber);
                i++;
            }
        }
        else System.out.println("Customer " +
                network.getCustomer(customerID).getName()
                + " haven't mobile numbers yet.");

        customerNumbers.clear();
    }

    public void searchMNumbers(String customerID) {
        for(int i = 0; i < network.getNumberMobileNumbers(); i++) {
            if (network.getMobileNumber(i).getUserID().equals(customerID))
                customerNumbers.add(network.getMobileNumber(i));
        }
    }

    private String getCustomerID() {
        System.out.println("\n\tChoose customer ID: ");
        network.showCustomers();
        System.out.println("Type here: ");
        String ID = scanner.nextLine();
        if (!network.isCustomerAlreadyExist(ID)) {
            logger.error("Customer with ID " + ID + " does not exist");
            System.out.println(ANSI_RED + "Customer with ID " + ID + " does not exist" + ANSI_RESET);
            ID = null;
        }
        return ID;
    }

    public List<MobileNumber> getCustomerNumbers() {
        return customerNumbers;
    }
}
