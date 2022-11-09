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
        String country = getCountryName();
        Double price = getPricePerMinute();
        Abroad abroad = getNewAbroad(country, price);
        network.addAbroad(abroad);
        System.out.println("\n\tAdded abroad:");
        System.out.println(abroad);
        //network.showAbroad();
    }

    private String getCountryName() {
        System.out.print("Type country: ");
        return scanner.nextLine();
    }

    private Double getPricePerMinute() {
        System.out.print("Type price per minute in hryvnias: ");
        return Double.parseDouble(scanner.nextLine());
    }

    public Abroad getNewAbroad(String country, Double price) {
        return new Abroad(country, price);
    }
}
