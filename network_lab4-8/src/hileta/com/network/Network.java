package hileta.com.network;

import hileta.com.Tariff.BaseTariff;


import java.util.ArrayList;
import java.util.List;

public class Network {

    private String companyName;
    private String companyNumber;
    private String companyEmail;
    private List<BaseTariff> operatorAvailableTariffs;
    private List<BaseTariff> operatorArchivedTariffs;
    private List<Customer> operatorCustomers;
    private List<MobileNumber> operatorNumbers;
    private List<Abroad> operatorListAbroad;

    public Network(String companyName, String companyNumber, String companyEmail) {
        this.companyName = companyName;
        this.companyNumber = companyNumber;
        this.companyEmail = companyEmail;
        CreateLists();
    }

    private void CreateLists() {
        operatorAvailableTariffs = new ArrayList<>();
        operatorArchivedTariffs = new ArrayList<>();
        operatorCustomers = new ArrayList<>();
        operatorNumbers = new ArrayList<>();
        operatorListAbroad = new ArrayList<>();
    }

    public void addTariff(BaseTariff tariff) {
        operatorAvailableTariffs.add(tariff);
    }

    public void archiveTariff(BaseTariff tariff) {
        operatorArchivedTariffs.add(tariff);
    }

    public void showTariffs() {
        for(int i = 0, j = i; i < this.operatorAvailableTariffs.size(); ++i, ++j) {
            System.out.println(String.valueOf(j) + this.operatorAvailableTariffs.get(i));
        }
    }

    public void deleteTariff(int numberOfTariff) {
        operatorAvailableTariffs.remove(numberOfTariff);
    }

    public void addNumber(MobileNumber mobileNumber) {
        operatorNumbers.add(mobileNumber);
    }

    public void addCustomer(Customer customer) {
        operatorCustomers.add(customer);
    }

    public void addAbroad(Abroad abroad) {
        operatorListAbroad.add(abroad);
    }

    public void showAbroad() {
    }

    public void numberCustomers() {
    }

    public void sortTariffs() {
    }

    public BaseTariff getTariff(int numberOfTariff) {
        return operatorAvailableTariffs.get(numberOfTariff);
    }

    public BaseTariff getTariffFromArchive(int numberOfTariff) {
        return operatorArchivedTariffs.get(numberOfTariff);
    }

    public Customer getCustomer(int numberCustomer) {
        return operatorCustomers.get(numberCustomer);
    }

    public int getNumberAvailableTariffs() {
        return operatorAvailableTariffs.size();
    }

    public int getNumberArchivedTariffs() {
        return operatorArchivedTariffs.size();
    }

    public boolean isListTariffsEmpty() {
        return operatorAvailableTariffs.isEmpty();
    }

    public boolean isListCustomersEmpty() {
        return operatorCustomers.isEmpty();
    }

    public void showCustomers() {
        for(int i = 0, j = i; i < operatorCustomers.size(); ++i, ++j) {
            System.out.println(String.valueOf(j) + operatorCustomers.get(i));
        }
    }

    public List<BaseTariff> getOperatorAvailableTariffs() {
        return operatorAvailableTariffs;
    }
}

