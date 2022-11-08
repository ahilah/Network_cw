package hileta.com.menu.command.edit;

import hileta.com.Tariff.BaseTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import static hileta.com.menu.management.MainCommand.ANSI_RED;
import static hileta.com.menu.management.MainCommand.ANSI_RESET;
import static hileta.com.menu.management.MainMenu.scanner;

public class EditTariff implements MenuCommand {
    private final Network network;

    public EditTariff(Network network) {
        this.network = network;
    }

    @Override
    public void execute() {
        if(network.isListTariffsEmpty()) {
            System.out.println(ANSI_RED +
                    "\n\tList of tariffs is empty. Please, input data firstly. " + ANSI_RESET);
            return;
        }
        int tariffNumber = getNumberTariff();
        String [] tariffInfo = getInputTariffInfo();
        BaseTariff startTariff = network.getTariff(tariffNumber);
        editBaseTariff(startTariff, tariffInfo);
        System.out.println("\n\t\tEdited tariff: ");
        System.out.println(network.getTariff(tariffNumber));
    }

    private int getNumberTariff() {
        System.out.println("\n\t Choose number to edit: ");
        network.showTariffs();
        System.out.print("Type here: ");
        int i = Integer.parseInt(scanner.nextLine());
        return --i;
    }
    private String[] getInputTariffInfo() {
        System.out.println("\n\tEnter your tariff parameters like [name]---[sms]--[]--[]--[]");
        System.out.print("Type: ");
        String tariffInputInfo = scanner.nextLine();
        return splitString(tariffInputInfo);
    }
    public String[] splitString(String inputString) {
        String delims = "[-.,?!]+";
        return inputString.split(delims);
    }
    public void editBaseTariff(BaseTariff tariff, String [] tariffInfo) {
        /*tariff =*/ tariff.setSMSNumber(Integer.parseInt(tariffInfo[0]))
                .setNumberMinutesThisOperator(Double.parseDouble(tariffInfo[1]))
                .setPriceTariff(Integer.parseInt(tariffInfo[2]))
                .setTariffID(tariffInfo[3]);
    }
}
