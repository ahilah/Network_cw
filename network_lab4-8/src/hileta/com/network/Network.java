package hileta.com.network;

import hileta.com.Tariff.BaseTariff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Network {
    private static Network network;
    private final String companyName;
    private final String companyNumber;
    private final String companyEmail;
    private List<BaseTariff> AvailableTariffs;
    private List<BaseTariff> ArchivedTariffs;
    private List<Customer> Customers;
    private List<MobileNumber> ListMobileNumbers;
    private List<Abroad> ListAbroad;

    public static Network getNetwork(String companyName, String companyNumber, String companyEmail) {
        if (network == null) {
            network = new Network(companyName, companyNumber, companyEmail);
        }
        return network;
    }
    private Network(String companyName, String companyNumber, String companyEmail) {
        this.companyName = companyName;
        this.companyNumber = companyNumber;
        this.companyEmail = companyEmail;
        CreateLists();
    }
    private void CreateLists() {
        AvailableTariffs = new ArrayList<>();
        ArchivedTariffs = new ArrayList<>();
        Customers = new ArrayList<>();
        ListMobileNumbers = new ArrayList<>();
        ListAbroad = new ArrayList<>();
    }

    public void addTariff(BaseTariff tariff) {
        AvailableTariffs.add(tariff);
    }
    public void addMobileNumber(MobileNumber mobileNumber) {
        ListMobileNumbers.add(mobileNumber);
    }
    public void addCustomer(Customer customer) {
        Customers.add(customer);
    }
    public void addAbroad(Abroad abroad) {
        ListAbroad.add(abroad);
    }

    public void archiveTariff(BaseTariff tariff) {
        ArchivedTariffs.add(tariff);
    }
    public void archiveAllAvailableTariffs() {
        ArchivedTariffs.addAll(AvailableTariffs);
        AvailableTariffs.clear();
    }

    public void deleteTariff(int numberOfTariff) {
        AvailableTariffs.remove(numberOfTariff);
    }

    public void sortAvailableTariffs() {
        Collections.sort(AvailableTariffs);
    }
    public BaseTariff searchTariff(String tariffID) {
        BaseTariff searchedTariff = null;
        for (BaseTariff tariff : AvailableTariffs) {
            if (tariff.getTariffID().equals(tariffID)) searchedTariff = tariff;
        }
        for (BaseTariff tariff : ArchivedTariffs) {
            if (tariff.getTariffID().equals(tariffID)) searchedTariff = tariff;
        }
        return searchedTariff;
    }

    public BaseTariff getTariff(int numberOfTariff) {
        return AvailableTariffs.get(numberOfTariff);
    }
    public BaseTariff getArchivedTariff(int numberOfTariff) {
        return ArchivedTariffs.get(numberOfTariff);
    }
    public MobileNumber getMobileNumber(int number) {
        return ListMobileNumbers.get(number);
    }
    public Abroad getAbroad(int numberAbroad) {
        return ListAbroad.get(numberAbroad);
   }
    public Customer getCustomer(int numberCustomer) {
        return Customers.get(numberCustomer);
    }
    public Customer getCustomer(String customerID) {
        Customer searchedCustomer = null;
        for(Customer customer : Customers) {
            if (customer.getCustomerID().equals(customerID))
                searchedCustomer = customer;
        }
        return searchedCustomer;
    }
    public void getNetworkInfo() {
        System.out.println("\n\t\tNetwork info:");
        System.out.println("Company name: " + this.companyName + "\ne-mail: " + this.companyEmail + "\nnumber: " + this.companyNumber);
    }

    public int getNumberAvailableTariffs() {
        return AvailableTariffs.size();
    }
    public int getNumberArchivedTariffs() {
        return ArchivedTariffs.size();
    }
    public int getNumberCustomers() {
        return Customers.size();
    }
    public int getNumberMobileNumbers() {
        return ListMobileNumbers.size();
    }
    public int getNumberAbroad() {
        return ListAbroad.size();
    }

    public List<BaseTariff> getAvailableTariffs() {
        return AvailableTariffs;
    }
    public List<BaseTariff> getArchivedTariffs() {
        return ArchivedTariffs;
    }
    public List<Abroad> getListAbroad() {
        return ListAbroad;
    }
    public List<MobileNumber> getListMobileNumbers() {
        return this.ListMobileNumbers;
    }

    public boolean isListTariffsEmpty() {
        return AvailableTariffs.isEmpty();
    }
    public boolean isListCustomersEmpty() {
        return Customers.isEmpty();
    }
    public boolean isListMobileNumbersEmpty() {
        return ListMobileNumbers.isEmpty();
    }

    public boolean isTariffAvailableExists(String otherID) {
        boolean isTariffIDEqual = false;
        for (BaseTariff availableTariff : AvailableTariffs) {
            if (availableTariff.getTariffID().equals(otherID)) {
                isTariffIDEqual = true;
                break;
            }
        }
        return isTariffIDEqual;
    }
    public boolean isTariffAlreadyExists(String otherID) {
        boolean isTariffIDEqual = false;
        for (BaseTariff availableTariff : AvailableTariffs) {
            if (availableTariff.getTariffID().equals(otherID)) {
                isTariffIDEqual = true;
                break;
            }
        }
        for (BaseTariff availableTariff : ArchivedTariffs) {
            if (availableTariff.getTariffID().equals(otherID)) {
                isTariffIDEqual = true;
                break;
            }
        }
        return isTariffIDEqual;
    }
    public boolean isMobileNumberAlreadyExist(String number) {
        boolean isNumberEqual = false;
        for (MobileNumber mobileNumber : ListMobileNumbers) {
            if (Objects.equals(mobileNumber.getNumber(), number)) {
                isNumberEqual = true;
                break;
            }
        }
        return isNumberEqual;
    }
    public boolean isCustomerAlreadyExist(String customerID) {
        boolean isCustomerIDEqual = false;
        for (Customer customer : Customers) {
            if (customer.getCustomerID().equals(customerID)) {
                isCustomerIDEqual = true;
                break;
            }
        }
        return isCustomerIDEqual;
    }

    public void showTariffs() {
        int i = 1;
        for (BaseTariff tariff : AvailableTariffs) {
            System.out.println(i + ". " + tariff);
            ++i;
        }
    }
    public void showArchive() {
        for(BaseTariff tariff : ArchivedTariffs)
            System.out.println(tariff.rowTable());
        /*int i = 1;
        for (BaseTariff tariff : ArchivedTariffs) {
            System.out.println(i + ". " + tariff);
            ++i;
        }*/
    }
    public void showCustomers() {
        int i = 1;
        for (Customer customer : Customers) {
            System.out.println(i + ". " + customer);
            ++i;
        }
    }
    public void showAbroad() {
        for(Abroad abroad : ListAbroad)
            System.out.println(abroad.rowTable());
    }
    public void showMobileNumbers() {
        int i = 1;
        for (MobileNumber number : ListMobileNumbers) {
            System.out.println(i + ". " + number);
            ++i;
        }
    }
}

