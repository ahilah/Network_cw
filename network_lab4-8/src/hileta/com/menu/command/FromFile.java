package hileta.com.menu.command;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FromFile implements MenuCommand {
    private String COMMAND_INFO = "input from file";
    private final Network network;
    private Scanner scanner;

    public FromFile(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("start " + COMMAND_INFO);
        while (true) {
            System.out.println("Type file path: ");
            String filePath = scanner.nextLine();

            switch (getUserDecisionObject()) {
                case 0 -> {
                    System.out.println(ANSI_PURPLE + "\n\tInput data from file was successfully over!" + ANSI_RESET);
                    return;
                }
                case 1 -> {

                }
            }
        }

    }



    private int getUserDecisionObject() {
        System.out.println("\n\nPress to add");
        System.out.print("""
                    1 - for new tariffs
                    2 - for new customers
                    3 - for new mobile numbers
                    4 - for new abroad
                    0 - to exit.""".indent(0));
        System.out.print("Type here: ");
        return Integer.parseInt(scanner.nextLine()); //scanner.nextInt();
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}