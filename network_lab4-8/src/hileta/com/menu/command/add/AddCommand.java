package hileta.com.menu.command.add;

import hileta.com.menu.command.FromFileCommand;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Abroad;
import hileta.com.network.Customer;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;

import java.util.Scanner;



public class AddCommand implements MenuCommand {
    // private final String COMMAND_INFO = "add new object";
    Scanner scanner;
    private Network network;
    private final FromFileCommand fileCommand;
    AddTariffCommand addTariffCommand;
    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_RESET = "\u001b[0m";

    public AddCommand(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
        fileCommand = new FromFileCommand(network);
        addTariffCommand = new AddTariffCommand(network);
    }

    public void execute() {
        if (isInputFromFile()) {
            fileCommand.execute();
            return;
        }
        while (true) {
            //int command = getUserDecisionObject();
            switch (getUserDecisionObject()) {
                case 0 -> {
                    System.out.println(ANSI_PURPLE + "\n\tInput data was successfully over!" + ANSI_RESET);
                    return;
                }
                case 1 -> {
                    addTariffCommand.execute();
                    //network.showTariffs();
                }
                case 2 -> {
                    Customer customer = getNewCustomer();
                    network.addCustomer(customer);
                    System.out.println("\tYour added customer: ");
                    System.out.println(customer);
                    //network.showCustomers();
                }
                case 3 -> {
                    if (network.isListCustomersEmpty() || network.isListTariffsEmpty()) {
                        System.out.println(ANSI_RED +
                                "List of tariffs or customers is empty. Create at least one object of both!"
                                + ANSI_RESET);
                        break;
                    }
                    MobileNumber mobileNumber = getNewMobileNumber();
                    network.addNumber(mobileNumber);
                    System.out.println("\tYour added mobile number: ");
                    System.out.println(mobileNumber);
                }
                case 4 -> {
                    Abroad abroad = getNewAbroad();
                    network.addAbroad(abroad);
                    System.out.println("\tYour added abroad:");
                    System.out.println(abroad);
                    //network.showAbroad();
                }
                default -> System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
            }
        }
    }

    private boolean isInputFromFile() {
        System.out.print("\nPress to read data from:\n1 - file\n0 - console\nType here: ");
        return Integer.parseInt(scanner.nextLine()) == 1;
    }

    private int getUserDecisionObject() {
        System.out.println("\nPress to add");
        System.out.print("""
                    1 - for new tariff
                    2 - for new customer
                    3 - for new mobile number
                    4 - for new abroad
                    0 - to exit.""".indent(0));
        System.out.print("Type here: ");
        return Integer.parseInt(scanner.nextLine()); //scanner.nextInt();
    }

    private Customer getNewCustomer() {
        System.out.print("Type customer name: ");
        //scanner.next();
        String customerName = scanner.nextLine();
        System.out.print("Type customer ID: ");
        String customerID = scanner.nextLine().replaceAll("\\s","");
        return new Customer(customerName, customerID);
    }

    private MobileNumber getNewMobileNumber() {
        System.out.print("Type mobile number: ");
        //scanner.next();
        String mobileNumber = scanner.nextLine().replaceAll("\\s","");
        System.out.print("Choose tariff: ");
        network.showTariffs();
        System.out.println("Type here: ");
        int numberTariff = Integer.parseInt(scanner.nextLine());
        System.out.print("Choose customer: ");
        network.showCustomers();
        System.out.println("Type here: ");
        int numberCustomer = Integer.parseInt(scanner.nextLine());
        System.out.print("Type number balance (in hryvnias): ");
        double balance = Double.parseDouble(scanner.nextLine());
        return new MobileNumber(mobileNumber, network.getTariff(--numberTariff).getTariffID(),
                network.getCustomer(--numberCustomer).getCustomerID(), balance);
    }

    private Abroad getNewAbroad() {
        System.out.print("Type country: ");
        String country = scanner.nextLine();
        System.out.print("Type price per minute in hryvnias: ");
        double pricePerMinute = Double.parseDouble(scanner.nextLine());
        return new Abroad(country, pricePerMinute);
    }

    /*@Override
    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }*/

    /*
    String ss = "input --price --data";

        List<String> s = convertArrayToList(s1);
        String delims = "[-.,?!]+";
                String[] s1 = ss.split(delims);
        for(int i = 0; i < s.size(); ++i) {
            System.out.println((String)s.get(i));
        }

    public static <T> List<T> convertArrayToList(T[] array) {
        List<T> list = new ArrayList();
        Object[] var1 = array;
        int var2 = array.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            T t = (T) var1[var3];
            list.add(t);
        }

        return list;
    }
 */
}
