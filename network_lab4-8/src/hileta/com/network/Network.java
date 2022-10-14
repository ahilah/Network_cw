package hileta.com.network;

import hileta.com.Tariff.BaseTariff;


import java.util.ArrayList;
import java.util.List;

public class Network {

    private final String companyName;
    private final String companyNumber;
    private final String companyEmail;
    private List<BaseTariff> AvailableTariffs;
    private List<BaseTariff> ArchivedTariffs;
    private List<Customer> Customers;
    private List<MobileNumber> ListMobileNumbers;
    private List<Abroad> ListAbroad;

    public Network(String companyName, String companyNumber, String companyEmail) {
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

    public void archiveTariff(BaseTariff tariff) {
        ArchivedTariffs.add(tariff);
    }

    public void deleteTariff(int numberOfTariff) {
        AvailableTariffs.remove(numberOfTariff);
    }

    public void addNumber(MobileNumber mobileNumber) {
        ListMobileNumbers.add(mobileNumber);
    }

    public void addCustomer(Customer customer) {
        Customers.add(customer);
    }

    public void addAbroad(Abroad abroad) {
        ListAbroad.add(abroad);
    }

    public void numberCustomers() {
    }

    public void sortTariffs() {
    }

    public BaseTariff getTariff(int numberOfTariff) {
        return AvailableTariffs.get(numberOfTariff);
    }

    public BaseTariff getTariffFromArchive(int numberOfTariff) {
        return ArchivedTariffs.get(numberOfTariff);
    }

    public Customer getCustomer(int numberCustomer) {
        return Customers.get(numberCustomer);
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

    public boolean isListTariffsEmpty() {
        return AvailableTariffs.isEmpty();
    }

    public boolean isListCustomersEmpty() {
        return Customers.isEmpty();
    }

    public void showTariffs() {
        for(int i = 0, j = i + 1; i < this.AvailableTariffs.size(); ++i, ++j) {
            System.out.println(j + "." + this.AvailableTariffs.get(i));
        }
    }

    public void showCustomers() {
        for(int i = 0, j = i; i < Customers.size(); ++i, ++j) {
            System.out.println(j + "." + Customers.get(i));
        }
    }

    public void showAbroad() {
        for(int i = 0, j = i; i < ListAbroad.size(); ++i, ++j) {
            System.out.println(j + "." + ListAbroad.get(i));
        }
    }

    public List<BaseTariff> getAvailableTariffs() {
        return AvailableTariffs;
    }
}

