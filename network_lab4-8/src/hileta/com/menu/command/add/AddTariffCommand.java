package hileta.com.menu.command.add;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.Scanner;

public class AddTariffCommand implements MenuCommand  {

    Scanner scanner;
    private final Network network;
    private static final String ANSI_RED = "\u001b[31m";
    public static final String ANSI_RESET = "\u001b[0m";

    public AddTariffCommand(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        String commandExample1 = "Run command with parameters like: tariff name--" +
                "smsNumber--numberMinutesThisOperator--price--ID";
        String commandExample2 = "--numberMinutesOtherOperator--NumberMinutesAbroad";
        String commandExample3 = "--GBMobileInternet";
        String[] tariffInfo;
        BaseTariff baseTariff;
        int commandTariff = getTariffKind();
        switch (commandTariff) {
            case 1 -> {
                System.out.print(commandExample1 + "\n");
                tariffInfo = getInputTariffInfo();
                baseTariff = getNewStartTariff(tariffInfo);
                network.addTariff(baseTariff);
            }
            case 2 -> {
                System.out.println(new StringBuilder().append(commandExample1)
                        .append(commandExample2).toString());
                tariffInfo = getInputTariffInfo();
                baseTariff = getNewSuperTariff(tariffInfo);
                network.addTariff(baseTariff);
            }
            case 3 -> {
                System.out.println(new StringBuilder().append(commandExample1)
                        .append(commandExample2).append(commandExample3).toString());
                tariffInfo = getInputTariffInfo();
                baseTariff = getNewSuperNetTariff(tariffInfo);
                network.addTariff(baseTariff);
            }
            default -> {
                System.out.println(ANSI_RED + "\tWrong command!" + ANSI_RESET);
                return;
            }
        }
        System.out.println("\n\tYour added tariff:");
        System.out.println(baseTariff);
    }

    private int getTariffKind() {
        System.out.println("\tType " + ANSI_RED + "@" + ANSI_RESET + " for unlimited parameter!\nPress to add");
        System.out.print("""
                    1 - for start tariff
                    2 - for super tariff
                    3 - for super net tariff""".indent(0));
        System.out.print("Type number here: ");
        return Integer.parseInt(scanner.nextLine());
    }

    private String[] getInputTariffInfo() {
        System.out.print("Type: ");
        String tariffInputInfo = scanner.nextLine();
        return splitString(tariffInputInfo);
    }

    private String[] splitString(String inputString) {
        String delims = "[-.,?!]+";
        return inputString.split(delims);
    }

    private void searchUnlimitedParameters(String[] inputInfo) {
        final String unlimSym = "@";
        for (int i = 0; i < inputInfo.length; i++) {
            if (inputInfo[i].equals(unlimSym)) inputInfo[i] = "-1";
        }
    }

    private BaseTariff getNewStartTariff(String[] tariffInfo) {
        return new StartTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4]);
    }

    private BaseTariff getNewSuperTariff(String[] tariffInfo) {
        searchUnlimitedParameters(tariffInfo);
        return new SuperTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]));
    }

    private BaseTariff getNewSuperNetTariff(String[] tariffInfo) {
        searchUnlimitedParameters(tariffInfo);
        return new SuperNetTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]),
                Double.parseDouble(tariffInfo[7]));
    }


    public String getCommandInfo() {
        String COMMAND_INFO = "add new tariff";
        return COMMAND_INFO;
    }
}
