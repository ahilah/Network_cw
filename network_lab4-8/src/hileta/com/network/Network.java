package hileta.com.network;

import hileta.com.Tariff.BaseTariff;


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

    public void addNumber() {
    }

    public void addCustomer() {
    }

    public void addAbroad() {
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

    public int getNumberAvailableTariffs() {
        return operatorAvailableTariffs.size();
    }

    public int getNumberArchivedTariffs() {
        return operatorArchivedTariffs.size();
    }

    public List<BaseTariff> getOperatorAvailableTariffs() {
        return operatorAvailableTariffs;
    }
}

