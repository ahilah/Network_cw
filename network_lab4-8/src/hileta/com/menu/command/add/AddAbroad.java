package hileta.com.menu.command.add;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Abroad;
import hileta.com.network.Network;

import java.util.Scanner;

public class AddAbroad implements MenuCommand {
    Scanner scanner;
    private final Network network;

    public AddAbroad(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        Abroad abroad = getNewAbroad();
        network.addAbroad(abroad);
        System.out.println("\n\tAdded abroad:");
        System.out.println(abroad);
        //network.showAbroad();
    }

    private Abroad getNewAbroad() {
        System.out.print("Type country: ");
        String country = scanner.nextLine();
        System.out.print("Type price per minute in hryvnias: ");
        double pricePerMinute = Double.parseDouble(scanner.nextLine());
        return new Abroad(country, pricePerMinute);
    }
}
