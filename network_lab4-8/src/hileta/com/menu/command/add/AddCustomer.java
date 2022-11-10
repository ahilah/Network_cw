package hileta.com.menu.command.add;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Customer;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class AddCustomer implements MenuCommand {
    private static Logger logger = LogManager.getLogger(AddCustomer.class);
    Scanner scanner;
    private final Network network;

    public AddCustomer(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        logger.info("Add customer command was executed");
        String name = getName();
        String ID = getID();
        if (ID == null) {
            System.out.println(ANSI_RED + "\tIncorrect input parameters. Try again!" + ANSI_RESET);
            return;
        }

        Customer customer = getNewCustomer(name, ID);
        network.addCustomer(customer);
        System.out.println("\n\tAdded customer: ");
        System.out.println(customer);
        logger.info("New customer was added successfully");
    }

    private String getName() {
        System.out.print("Type customer name: ");
        return scanner.nextLine();
    }

    private String getID() {
        System.out.print("Type customer ID: ");
        String ID = scanner.nextLine().replaceAll("\\s","");
        if (network.isCustomerAlreadyExist(ID)) {
            logger.error("Attempt to add existing user");
            System.out.println(ANSI_RED + "\n\tUser with ID " + ID + " already exists" + ANSI_RESET);
            ID = null;
        }
        return ID;
    }

    public Customer getNewCustomer(String name, String ID) {
        return new Customer(name, ID);
    }
}
