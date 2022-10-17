package hileta.com.menu.command.search;

import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Customer;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;

import java.util.LinkedHashMap;
import java.util.Map;

public class SearchDebtors implements MenuCommand {
    private final Network network;
    private Map<MobileNumber, Customer> debtors;
    public SearchDebtors(Network network) {
        this.network = network;
        debtors = new LinkedHashMap<>();
    }

    @Override
    public void execute() {
        for (int i = 0; i < network.getNumberCustomers(); i++) {
            for (int j = 0; j < network.getNumberMobileNumbers(); j++) {
                if (isNumberSearched(i, j) && isBalanceNotEnough(i)) {
                    debtors.put(network.getMobileNumber(j), network.getCustomer(i));
                }
            }
        }
        if(!debtors.isEmpty()){
            System.out.println("\n\t\t List of debtors: ");
            debtors.forEach((k, v) -> System.out.println(v + " - "+ k));
        } else System.out.println("\n\t There are no debtors.");
    }

    private boolean isNumberSearched(int i, int j) {
        String customerID = network.getCustomer(i).getCustomerID();
        return network.getMobileNumber(j).getUserID().equals(customerID);
    }
    private boolean isBalanceNotEnough(int i) {
        String searchedTariffID = network.getMobileNumber(i).getTariffID();
        boolean isTariffArchived = true;
        double tariffPrice = 0;
        double numberBalance = network.getMobileNumber(i).getBalance();
        for (int j = 0; j < network.getNumberAvailableTariffs(); j++) {
            if (network.getTariff(j).getTariffID().equals(searchedTariffID)) {
                isTariffArchived = false;
                tariffPrice = (network.getTariff(j).getPriceTariff());
            }
        }

        if (isTariffArchived) {
            for (int j = 0; j < network.getNumberArchivedTariffs(); j++) {
                if (network.getArchivedTariff(j).getTariffID().equals(searchedTariffID)) {
                    isTariffArchived = false;
                    tariffPrice = network.getArchivedTariff(j).getPriceTariff();
                }
            }
        }
        return numberBalance < tariffPrice;

    }
}
