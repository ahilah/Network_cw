package hileta.com.menu.command;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static hileta.com.menu.command.add.Add.ANSI_PURPLE;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;

public class FromFile implements MenuCommand {
    private String COMMAND_INFO = "input from file";
    private final Network network;
    private Scanner scanner;
    private BufferedReader buff;

    public FromFile(Network network) {
        this.network = network;
        scanner = new Scanner(System.in);
    }

    public void execute() {
        System.out.println("start " + COMMAND_INFO);
        while (true) {
            System.out.println("Type file path: ");
            String filePath = scanner.nextLine();
            try { // open file
                buff = new BufferedReader(new FileReader(filePath));

                switch (getUserDecisionObject()) {
                    case 0 -> {
                        System.out.println(ANSI_PURPLE + "\n\tInput data from file was successfully over!" + ANSI_RESET);
                        return;
                    }
                    case 1 -> {
                        //int isEndFile = Integer.parseInt(buff.readLine());
                        int [] info = getAmountAndTariffType(buff.readLine());
                        BaseTariff baseTariff;
                        String[] tariffInfo;
                        while(info != null) {
                            for(int i = 0; i < info[1]; i++) {
                                tariffInfo = buff.readLine().split(" ");
                                baseTariff = getNewStartTariff(tariffInfo);
                                network.addTariff(baseTariff);
                            }
                            info = getAmountAndTariffType(buff.readLine());
                        }
                        buff.close();
                        network.showTariffs();
                    }
                }

                /*while (true) {
                    String line = buff.readLine();
                    if (line != null) {
                        System.out.println(line);
                    } else break;
                }
                buff.close();*/

            }
            catch (IOException e) {
                System.out.println("Can't open: " + filePath);
            }


        }

    }

    /*private String[] splitString(String inputString) {
        String delims = "[-.,?!]+ ";
        return inputString.split(delims);
    }*/

    private int [] getAmountAndTariffType(String inputString) {
        int[] numbers = null;
        if (inputString != null) {
            String[] stringNumbers = inputString.split(" ");
            numbers = new int[stringNumbers.length];
            for (int i = 0; i < stringNumbers.length; i++) {
                numbers[i] = Integer.parseInt(stringNumbers[i]);
            }
        }
        return numbers;
    }

    private BaseTariff getNewStartTariff(String[] tariffInfo) {
        return new StartTariff(tariffInfo[0], Integer.parseInt(tariffInfo[1]),
                Double.parseDouble(tariffInfo[2]), Integer.parseInt(tariffInfo[3]), tariffInfo[4]);
    }

    private int getUserDecisionObject() {
        System.out.println("\n\nPress to add");
        System.out.print("""
                    1 - for new tariffs
                    2 - for new customers
                    3 - for new mobile numbers
                    4 - for new abroad
                    0 - to exit.""".indent(0));
        System.out.print("Type here: ");
        return Integer.parseInt(scanner.nextLine()); //scanner.nextInt();
    }

    /*public String getCommandInfo() {
        return COMMAND_INFO;
    }*/
}