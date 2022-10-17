package hileta.com.menu.command.add;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;


public class Add implements MenuCommand {
    Scanner scanner;
    private final Network network;
    AddCommand addCommand;
    public static final String ANSI_PURPLE = "\u001b[35m";

    public Add(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
        addCommand = new AddCommand(network);
    }

    public void execute() {
        while (true) {
            System.out.println("\n\n\tPres " + ANSI_RED + "0 " + ANSI_RESET +
                    "for end adding new items.\n\tAvailable commands: ");
            this.addCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            int command = Integer.parseInt(scanner.nextLine());
            if (command != 0) addCommand.execute(command);
            else {
                System.out.println(ANSI_PURPLE + "\n\tInput data was successfully over!" + ANSI_RESET);
                return;
            }
        }
    }


    /*
    // private final String COMMAND_INFO = "add new object";
    //private final FromFile fileCommand;
    //AddTariff addTariff;

     //fileCommand = new FromFile(network);
     //addTariff = new AddTariff(network);

    if (isInputFromFile()) {
            fileCommand.execute();
            return;
        }


    @Override
    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }

    while (true) {
            //int command = getUserDecisionObject();
            switch (getUserDecisionObject()) {
                case 0 -> {
                    System.out.println(ANSI_PURPLE + "\n\tInput data was successfully over!" + ANSI_RESET);
                    return;
                }
                case 1 -> {
                    addTariff.execute();
                    //network.showTariffs();
                }
                case 2 -> {
                    Customer customer = getNewCustomer();
                    network.addCustomer(customer);
                    System.out.println("\n\tAdded customer: ");
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
                    network.addMobileNumber(mobileNumber);
                    System.out.println("\n\tAdded mobile number: ");
                    System.out.println(mobileNumber);
                }
                case 4 -> {
                    Abroad abroad = getNewAbroad();
                    network.addAbroad(abroad);
                    System.out.println("\n\tAdded abroad:");
                    System.out.println(abroad);
                    //network.showAbroad();
                }
                default -> System.out.println(ANSI_RED + "Incorrect command! Try again." + ANSI_RESET);
            }
        }

    private boolean isInputFromFile() {
        System.out.print("\nPress to read data from:\n1 - file\n0 - console\nType here: ");
        return Integer.parseInt(scanner.nextLine()) == 1;
    }

    private int getUserDecisionObject() {
        System.out.println("\n\nPress to add");
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
        int numberTariff = getCheckedNoTariff();
        int numberCustomer = getCheckedNoCustomer();
        double balance = getCheckedBalance();
        network.getTariff(numberTariff).setNumberOfUsers(network.getTariff(numberTariff).getNumberOfUsers() + 1);
        return new MobileNumber(mobileNumber, network.getTariff(numberTariff).getTariffID(),
                network.getCustomer(numberCustomer).getCustomerID(), balance);
    }

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
