package hileta.com.menu.management;

import java.util.Scanner;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class MainMenu {
    public static Scanner scanner = new Scanner(System.in);
    private final MainCommand mainCommand;
    public MainMenu() {
        mainCommand = new MainCommand();
    }
    public void StartMainMenu() {
        while(true) {
            System.out.println("\nAvailable commands: ");
            this.mainCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            try {
                int command = Integer.parseInt(scanner.nextLine());
                mainCommand.execute(command);
                System.out.println("\n--------------------------------------------" +
                        "--------------------------------------------------------" +
                        "-----------------------------------------------------------" +
                        "-----------------");
            }
            catch (NumberFormatException e){
                System.out.println(ANSI_RED + "Wrong input line!" + ANSI_RESET);
            }
        }
    }
}
