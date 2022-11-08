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
        if(network.isListCustomersEmpty() || network.isListMobileNumbersEmpty() || network.isListTariffsEmpty()) {
            System.out.println("\n\tList of customers or mobile numbers or tariffs is empty. Please, fill data.");
            return;
        }
        fillDebtors();
        if(!debtors.isEmpty()){
            System.out.println("\n\t\t List of debtors: ");
            debtors.forEach((k, v) -> System.out.println(v + " - "+ k));
            System.out.print("\n\n\t\tGeneral debtor number: " +
                    Integer.parseInt(String.valueOf(debtors.size())));
        } else System.out.println("\n\t There are no debtors.");

    }

    public void clearDebtors() {
        debtors.clear();
    }

    public void fillDebtors() {
        for (int i = 0; i < network.getNumberCustomers(); i++) {
            for (int j = 0; j < network.getNumberMobileNumbers(); j++) {
                if (isNumberSearched(i, j) && isBalanceNotEnough(j)) {
                    debtors.put(network.getMobileNumber(j), network.getCustomer(i));
                }
            }
        }
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
                break;
            }
        }

        if (isTariffArchived) {
            for (int j = 0; j < network.getNumberArchivedTariffs(); j++) {
                if (network.getArchivedTariff(j).getTariffID().equals(searchedTariffID)) {
                    tariffPrice = network.getArchivedTariff(j).getPriceTariff();
                    break;
                }
            }
        }
        return numberBalance < tariffPrice;
    }

    public Customer getDebtors(MobileNumber mnumber) {
        return debtors.get(mnumber);
    }

    public Map<MobileNumber, Customer> getDebtors() {
        return debtors;
    }
}
