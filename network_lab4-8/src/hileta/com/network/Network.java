package hileta.com.network;

import java.io.PrintStream;
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

    public Network() {
    }

    public void addTariff(BaseTariff tariff) {
        this.operatorAvailableTariffs.add(tariff);
    }

    public void archiveTariff(BaseTariff tariff) {
        this.operatorArchivedTariffs.add(tariff);
    }

    public void showTariffs() {
        int i = 0;

        for(int j = i; i < this.operatorAvailableTariffs.size(); ++j) {
            PrintStream var10000 = System.out;
            String var10001 = String.valueOf(j);
            var10000.println(var10001 + this.operatorAvailableTariffs.get(i));
            ++i;
        }

    }

    public void deleteTariff(int numberOfTariff) {
        this.operatorAvailableTariffs.remove(numberOfTariff);
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
        return (BaseTariff)this.operatorAvailableTariffs.get(numberOfTariff);
    }

    public BaseTariff getTariffFromArchive(int numberOfTariff) {
        return (BaseTariff)this.operatorArchivedTariffs.get(numberOfTariff);
    }

    public int getNumberAvailableTariffs() {
        return this.operatorAvailableTariffs.size();
    }

    public int getNumberArchivedTariffs() {
        return this.operatorArchivedTariffs.size();
    }

    public List<BaseTariff> getOperatorAvailableTariffs() {
        return this.operatorAvailableTariffs;
    }
}

