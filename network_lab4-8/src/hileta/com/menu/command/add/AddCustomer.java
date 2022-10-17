package hileta.com.menu.command.add;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Customer;
import hileta.com.network.Network;

import java.util.Scanner;

public class AddCustomer implements MenuCommand {
    Scanner scanner;
    private final Network network;

    public AddCustomer(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Customer customer = getNewCustomer();
        network.addCustomer(customer);
        System.out.println("\n\tAdded customer: ");
        System.out.println(customer);
        //network.showCustomers();
    }

    private Customer getNewCustomer() {
        System.out.print("Type customer name: ");
        //scanner.next();
        String customerName = scanner.nextLine();
        System.out.print("Type customer ID: ");
        String customerID = scanner.nextLine().replaceAll("\\s","");
        return new Customer(customerName, customerID);
    }
}
