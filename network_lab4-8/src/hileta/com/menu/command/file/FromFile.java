package hileta.com.menu.command.file;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FromFile implements MenuCommand {
    //private String COMMAND_INFO = "input from file";
    private final Network network;
    private Scanner scanner;
    //private BufferedReader buff;

    private FromFileCommand fromFileCommand;

    public FromFile(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
        fromFileCommand = new FromFileCommand(network);
    }

    public void execute() {
        //boolean isEndReadLoop = false;
        while(true) {
            System.out.println("\n\n\tPres " + ANSI_RED + "0 " + ANSI_RESET +
                    "for end read from file.\n\tAvailable commands: ");
            this.fromFileCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            int command = Integer.parseInt(scanner.nextLine());
            if(command != 0) fromFileCommand.execute(command);
            else {
                System.out.println(ANSI_PURPLE + "\n\tInput data from file was successfully over!" + ANSI_RESET);
                return;
            }
        }

    }

}



    /* private int getUserDecisionObject() {
        System.out.println("\n\nPress to add");
        System.out.print("""
                    1 - for new tariffs
                    2 - for new customers
                    3 - for new mobile numbers
                    4 - for new abroad
                    0 - to exit.""".indent(0));
        System.out.print("Type here: ");
        return Integer.parseInt(scanner.nextLine()); //scanner.nextInt();
    } */



    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/


    /*

    private String[] splitString(String inputString) {
        String delims = "[-.,?!]+ ";
        return inputString.split(delims);
    }

    while (true) {
                    String line = buff.readLine();
                    if (line != null) {
                        System.out.println(line);
                    } else break;
                }
                buff.close();

                */

