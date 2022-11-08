package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;

import java.util.ArrayList;
import java.util.List;

import static hileta.com.menu.management.MainMenu.scanner;

public class SearchMobileNumbers implements MenuCommand {
    private final Network network;
    private List<MobileNumber> customerNumbers;
    public SearchMobileNumbers(Network network) {
        this.network = network;
        customerNumbers = new ArrayList<>();
    }

    @Override
    public void execute() {
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
        return scanner.nextLine();
    }

    public List<MobileNumber> getCustomerNumbers() {
        return customerNumbers;
    }
}
