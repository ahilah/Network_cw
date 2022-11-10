package hileta.com.menu.command.add;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.Scanner;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class AddTariff implements MenuCommand  {
    private static Logger logger = LogManager.getLogger(AddTariff.class);
    Scanner scanner;
    private final Network network;

    public AddTariff(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        logger.info("Add tariff command is executed");
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
                if (baseTariff == null) return;
                network.addTariff(baseTariff);
            }
            case 2 -> {
                System.out.println(new StringBuilder().append(commandExample1)
                        .append(commandExample2).toString());
                tariffInfo = getInputTariffInfo();
                baseTariff = getNewSuperTariff(tariffInfo);
                if (baseTariff == null) return;
                network.addTariff(baseTariff);
            }
            case 3 -> {
                System.out.println(new StringBuilder().append(commandExample1)
                        .append(commandExample2).append(commandExample3).toString());
                tariffInfo = getInputTariffInfo();
                baseTariff = getNewSuperNetTariff(tariffInfo);
                if (baseTariff == null) return;
                network.addTariff(baseTariff);
            }
            default -> {
                logger.error("Wrong input number");
                System.out.println(ANSI_RED + "\tWrong command!" + ANSI_RESET);
                return;
            }
        }
        System.out.println("\n\tYour added tariff:");
        System.out.println(baseTariff);
        logger.info("New tariff was added successfully");
    }

    private int getTariffKind() {
        logger.info("Show types of tariffs");
        System.out.println("\n\tType " + ANSI_RED + "@" + ANSI_RESET + " for unlimited parameter!\nPress to add");
        System.out.print("""
                    1 - for start tariff
                    2 - for super tariff
                    3 - for super net tariff""".indent(0));
        System.out.print("Type number here: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String[] getInputTariffInfo() {
        System.out.print("Type: ");
        String tariffInputInfo = scanner.nextLine();
        return splitString(tariffInputInfo);
    }

    public String[] splitString(String inputString) {
        String delims = "[-.,?!]+";
        return inputString.split(delims);
    }

    public void searchUnlimitedParameters(String[] inputInfo) {
        final String unlimSym = "@";
        for (int i = 0; i < inputInfo.length; i++) {
            if (inputInfo[i].equals(unlimSym)) inputInfo[i] = "9999";
            logger.warn("Tariffs contains unlim param");
        }
    }

    public BaseTariff getNewStartTariff(String[] tariffInfo) {
        searchUnlimitedParameters(tariffInfo);
        try {
            return new StartTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                    Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4]);
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Not all parameters were inputted");
            System.out.println("Not all parameters were inputted. Try again");
        }
        return null;
    }

    public BaseTariff getNewSuperTariff(String[] tariffInfo) {
        searchUnlimitedParameters(tariffInfo);
        try {
            return new SuperTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                    Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                    Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]));
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Not all parameters were inputted");
            System.out.println("Not all parameters were inputted. Try again");
        }
        return null;
    }

    public BaseTariff getNewSuperNetTariff(String[] tariffInfo) {
        searchUnlimitedParameters(tariffInfo);
        try {
            return new SuperNetTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                    Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4],
                    Double.parseDouble(tariffInfo[5]), Double.parseDouble(tariffInfo[6]),
                    Double.parseDouble(tariffInfo[7]));
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Not all parameters were inputted");
            System.out.println("Not all parameters were inputted. Try again");
        }
        return null;
    }
}
