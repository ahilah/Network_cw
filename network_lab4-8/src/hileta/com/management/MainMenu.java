package hileta.com.management;

import java.util.Scanner;

public class MainMenu {
    public Scanner scanner;
    public MainCommand mainCommand;

    public MainMenu() {
        this.scanner = new Scanner(System.in);
        this.mainCommand = new MainCommand();
    }

    public void StartMainMenu() {
        while(true) {
            System.out.println("\nAvailable commands: ");
            this.mainCommand.showAvailableCommands();
            System.out.print("Enter your command here: ");
            int command = this.scanner.nextInt();
            --command;
            this.mainCommand.execute(command);
        }
    }
}
