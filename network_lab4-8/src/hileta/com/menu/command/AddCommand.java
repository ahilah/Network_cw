package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Customer;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;

import java.util.Scanner;



public class AddCommand implements MenuCommand {

    private String COMMAND_INFO = "add new object";
    Scanner scanner;
    private Network network;
    private FromFileCommand fileCommand;
    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_RESET = "\u001b[0m";

    public AddCommand(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
        fileCommand = new FromFileCommand(network);
    }

    public void execute() {
        while (true) {
            System.out.print("\nPress to read data from:\n1 - file\n0 - console\nType here: ");
            int userFlag = scanner.nextInt();
            boolean inputFile = false;
            if (userFlag == 1) {
                inputFile = true;
                fileCommand.execute();
                break;
            }
            System.out.println("Press to add");
            System.out.print("""
                    1 - for new tariff
                    2 - for new customer
                    3 - for new mobile number
                    4 - for new abroad
                    0 - to exit.""".indent(0));
            System.out.print("Type here: ");
            int command = scanner.nextInt();
            switch(command) {
                case 1: {
                    // TODO
                }
                case 2: {
                    //System.out.println("Run command with parameters like: customer full name-----customerID");
                    System.out.print("Type customer name: ");
                    scanner.next();
                    String customerName = scanner.nextLine();
                    System.out.print("Type customer ID: ");
                    String customerID = scanner.next().replaceAll("\\s","");
                    Customer customer = new Customer(customerName, customerID);
                    network.addCustomer(customer);
                    break;
                    }
                case 3: {
                    if (network.isListCustomersEmpty() || network.isListTariffsEmpty()) {
                        System.out.println(ANSI_RED +
                                "List of tariffs or customers is empty. Create at least one object of both!"
                        + ANSI_RESET);
                        break;
                    }
                    System.out.print("Type mobile number: ");
                    scanner.next();
                    String mobileNumber = scanner.nextLine().replaceAll("\\s","");
                    System.out.print("Choose tariff: ");
                    network.showTariffs();
                    System.out.println("Type here: ");
                    int numberTariff = scanner.nextInt();
                    System.out.print("Choose customer: ");
                    network.showCustomers();
                    System.out.println("Type here: ");
                    int numberCustomer = scanner.nextInt();
                    System.out.print("Type number balance (in hryvnias): ");
                    double balance = scanner.nextDouble();
                    MobileNumber mobileNumberCust = new MobileNumber(mobileNumber,
                            network.getTariff(--numberTariff), network.getCustomer(--numberCustomer), balance);
                    network.addNumber(mobileNumberCust);
                    break;
                }
                case 0: {
                    System.out.println(ANSI_PURPLE + "\n\tInput data was successfully over!" + ANSI_RESET);
                    return;
                }
                default: {
                    System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
                    break;
                }
            }

        }


    }




    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }

    /*
    String ss = "input --price --data";

        List<String> s = convertArrayToList(s1);

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
