package hileta.com.menu.command.add;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class AddMobileNumber implements MenuCommand {
    private static Logger logger = LogManager.getLogger(AddMobileNumber.class);
    private final Network network;

    public AddMobileNumber(Network network) {
        this.network = network;
        //scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        logger.info("Add mobile number command was executed");
        if (network.isListCustomersEmpty() || network.isListTariffsEmpty()) {
            System.out.println(ANSI_RED +
                    "List of tariffs or customers is empty. Create at least one object of both!"
                    + ANSI_RESET);
            logger.error("List of tariffs or customers is empty");
            return;
        }
        MobileNumber mobileNumber = getNewMobileNumber();
        network.addMobileNumber(mobileNumber);
        System.out.println("\n\tAdded mobile number: ");
        System.out.println(mobileNumber);
        logger.info("New mobile number was added");
    }

    private MobileNumber getNewMobileNumber() {
        System.out.print("Type mobile number: ");
        //scanner.next();
        String mobileNumber = scanner.nextLine().replaceAll("\\s","");
        int numberTariff = getCheckedNoTariff(inputNoTariff());
        int numberCustomer = getCheckedNoCustomer(inputNoCust());
        double balance = getCheckedBalance(getBalance());
        network.getTariff(numberTariff).setNumberOfUsers(network.getTariff(numberTariff).getNumberOfUsers() + 1);
        return new MobileNumber(mobileNumber, network.getTariff(numberTariff).getTariffID(),
                network.getCustomer(numberCustomer).getCustomerID(), balance);
    }

    private int inputNoCust() {
        System.out.print("\n\tChoose customer: \n");
        network.showCustomers();
        System.out.print("Type number here: ");
         return Integer.parseInt(scanner.nextLine());
    }

    public int getCheckedNoCustomer(int numberCustomer) {
        if (numberCustomer < 0 || numberCustomer > network.getNumberCustomers()) {
            logger.error("Wrong customer number " + numberCustomer);
            System.out.println(ANSI_RED + "\nWrong number of customer." +
                    " Set default first customer in list." + ANSI_RESET);
            numberCustomer = 1;
            logger.warn("Set default number of customer 0");
        }
        return --numberCustomer;
    }

    private int inputNoTariff() {
        System.out.print("\n\tChoose tariff: \n");
        network.showTariffs();
        System.out.print("Type number here: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getCheckedNoTariff(int numberTariff) {
        if (numberTariff < 0 || numberTariff > network.getNumberAvailableTariffs()) {
            logger.error("Wrong tariff number " + numberTariff);
            System.out.println(ANSI_RED + "\nWrong number of tariff. Set default first tariff in list." + ANSI_RESET);
            numberTariff = 1;
            logger.warn("Set default number of tariff 0");
        }
        return --numberTariff;
    }

    private double getBalance() {
        System.out.print("Type number balance (in hryvnias): ");
        return Double.parseDouble(scanner.nextLine());
    }

    public double getCheckedBalance(double balance) {
        if (balance < 0) {
            logger.error("Try to set incorrect balance");
            System.out.println(ANSI_RED + "\tBalance can't be less than 0! Set balance 0." + ANSI_RESET);
            logger.warn("Set default balance 0");
            balance = 0;
        }
        return balance;
    }
}
