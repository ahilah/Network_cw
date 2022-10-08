package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Customer;
import hileta.com.network.Network;

import java.util.Scanner;

public class AddCommand implements MenuCommand {
    private String COMMAND_INFO = "add new object";
    Scanner scanner = new Scanner(System.in);
    private Network network;

    public AddCommand(Network network) {
        this.network = network;
    }

    public void execute() {
        System.out.println("add");
        FromFileCommand fileCommand = new FromFileCommand(network);


        while (true) {
            System.out.print("\nPress 1 - if you want to read from file your data else type 0\n Type here: ");
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
            int command = scanner.nextInt();
            switch(command) {
                case 1: {
                    // TODO
                }
                case 2: {
                    System.out.println("Run command with parameters like: customer full name-----customerID");
                    System.out.print("Type here: ");
                    String s1 = scanner.next();
                    String s2 = scanner.next();
                    ;
                    Customer customer = new Customer(s1, s2);
                    network.addCustomer(customer);
                    }

                }

            }


        }


    public String getCommandInfo() {
        return this.COMMAND_INFO;
    }

    /*
    String ss = "input --price --data";
        String delims = "[-.,?!]+";
        String[] s1 = ss.split(delims);
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
