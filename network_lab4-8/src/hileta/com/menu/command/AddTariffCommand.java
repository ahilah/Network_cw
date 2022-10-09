package hileta.com.menu.command;

import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

public class AddTariffCommand implements MenuCommand  {

    private final String COMMAND_INFO = "add new object";
    Scanner scanner;
    private Network network;

    private static final String ANSI_RED = "\u001b[31m";
    private static final String ANSI_PURPLE = "\u001b[35m";
    public static final String ANSI_RESET = "\u001b[0m";

    public AddTariffCommand() {
        this.network = new Network("111", "222", "333");
        scanner = new Scanner(System.in);
        //fileCommand = new FromFileCommand(network);
    }

    @Override
    public void execute() {
        System.out.println("Type " + ANSI_RED + "@" + ANSI_RESET + " for unlimited parameter.\nPress to add");
        System.out.print("""
                    1 - for start tariff
                    2 - for super tariff
                    3 - for super net tariff""".indent(0));
        System.out.print("Type here: ");
        int commandTariff = Integer.parseInt(scanner.nextLine());
        String commandExample1 = "Run command with parameters like: customer tariff name--" +
                "smsNumber--numberMinutesThisOperator--price--ID";
        String commandExample2 = "--numberMinutesOtherOperator--NumberMinutesAbroad";
        String commandExample3 = "--GBMobileInternet";
        switch(commandTariff) {
            case 1: {
                System.out.print(commandExample1 + "\n");
                String tariffInputInfo = scanner.nextLine();
                String[] tariffInfo = splitString(tariffInputInfo);
                StartTariff startTariff = new StartTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                        Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4]);
                network.addTariff(startTariff);
                System.out.println(network.getTariff(0));
                break;
            }
            case 2: {
                System.out.println(new StringBuilder().append(commandExample1)
                        .append(commandExample2).toString());
                String tariffInputInfo = scanner.nextLine();
                String[] tariffInfo = splitString(tariffInputInfo);
                searchUnlimitedParameters(tariffInfo);
                SuperTariff superTariff = new SuperTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                        Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                        Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]));
                network.addTariff(superTariff);
                break;
            }
            case 3: {
                System.out.println(new StringBuilder().append(commandExample1)
                        .append(commandExample2).append(commandExample3).toString());
                String tariffInputInfo = scanner.nextLine();
                String[] tariffInfo = splitString(tariffInputInfo);
                searchUnlimitedParameters(tariffInfo);
                SuperNetTariff superNetTariff = new SuperNetTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                        Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                        Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]),
                        Double.parseDouble(tariffInfo[7]));
                network.addTariff(superNetTariff);
                break;
            }
            default: {
                System.out.println("u lox");
                return;
            }
        }
    }

    @Override
    public String getCommandInfo() {
        return null;
    }

    private void searchUnlimitedParameters(String[] inputInfo) {
        final String unlimSym = "@";
        for (int i = 0; i < inputInfo.length; i++) {
            if (inputInfo[i].equals(unlimSym)) inputInfo[i] = "-1";
        }
    }

    private String[] splitString(String inputString) {
        String delims = "[-.,?!]+";
        return inputString.split(delims);
    }
}
