package hileta.com.menu.management;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class CreateNetwork implements MenuCommand {
    private static Logger logger = LogManager.getLogger(MainCommand.class);
    Scanner scanner;

    @Override
    public void execute() {
        logger.info("Create network command is executed");
        scanner = new Scanner(System.in);
        String COMMAND_INFO = ANSI_PURPLE + "\n\t--> Fill network company info\n" + ANSI_RESET;
        System.out.println(COMMAND_INFO);
    }

    public Network networkCompanyInfo() {
        System.out.println("Type network company name: ");
        String companyName = scanner.nextLine();
        System.out.println("Type network company mobile number: ");
        String companyMobileNumber = scanner.nextLine().replaceAll("\\s","");
        System.out.println("Type network company email: ");
        String companyEmail = scanner.nextLine();
        return Network.getNetwork(companyName, companyMobileNumber, companyEmail);
    }

    public Network networkCompanyInfo(String companyName, String companyMobileNumber, String companyEmail) {
        return Network.getNetwork(companyName, companyMobileNumber, companyEmail);
    }

    /*@Override
    public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}
