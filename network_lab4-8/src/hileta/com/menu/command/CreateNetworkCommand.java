package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

public class CreateNetworkCommand implements MenuCommand {

    private String COMMAND_INFO = "\tFill network company info";
    Scanner scanner;

    @Override
    public void execute() {
        scanner = new Scanner(System.in);
        System.out.println(getCommandInfo());
    }

    public Network networkCompanyInfo() {
        System.out.println("Type network company name: ");
        String companyName = scanner.nextLine();
        System.out.println("Type network company mobile number: ");
        String companyMobileNumber = scanner.nextLine().replaceAll("\\s","");
        System.out.println("Type network company email: ");
        String companyEmail = scanner.nextLine();
        return new Network(companyName, companyMobileNumber, companyEmail);
    }

    @Override
    public String getCommandInfo() {
        return COMMAND_INFO;
    }
}
