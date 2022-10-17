package hileta.com.menu.management;

import java.util.Scanner;

public class MainMenu {
    public static  Scanner scanner = new Scanner(System.in);
    private final MainCommand mainCommand;

    public MainMenu() {
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
