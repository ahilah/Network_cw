package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class CreateNetwork implements MenuCommand {
    private String COMMAND_INFO = ANSI_PURPLE + "\n\t--> Fill network company info\n" + ANSI_RESET;
    Scanner scanner;

    @Override
    public void execute() {
        scanner = new Scanner(System.in);
        System.out.println(COMMAND_INFO);
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

    /*@Override
    public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}
