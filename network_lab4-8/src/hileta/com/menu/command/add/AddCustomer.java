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
        String name = getName();
        String ID = getID();
        Customer customer = getNewCustomer(name, ID);
        network.addCustomer(customer);
        System.out.println("\n\tAdded customer: ");
        System.out.println(customer);
        //network.showCustomers();
    }

    private String getName() {
        System.out.print("Type customer name: ");
        //scanner.next();
        return scanner.nextLine();
    }

    private String getID() {
        System.out.print("Type customer ID: ");
        return  scanner.nextLine().replaceAll("\\s","");
    }

    public Customer getNewCustomer(String name, String ID) {
        return new Customer(name, ID);
    }
}
