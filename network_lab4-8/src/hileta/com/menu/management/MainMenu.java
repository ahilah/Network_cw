package hileta.com.menu.management;

import java.util.Scanner;

public class MainMenu {
    public static  Scanner scanner;
    private final MainCommand mainCommand;

    public MainMenu() {
        scanner = new Scanner(System.in);
        mainCommand = new MainCommand();
    }

    public void StartMainMenu() {
        while(true) {
            System.out.println("\nAvailable commands: ");
            this.mainCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            int command = Integer.parseInt(scanner.nextLine());
            mainCommand.execute(command);
            System.out.println("\n--------------------------------------------" +
                    "--------------------------------------------------------" +
                    "-----------------------------------------------------------" +
                    "-----------------");
        }
    }
}
