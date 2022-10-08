package hileta.com.network;

import hileta.com.Tariff.BaseTariff;

public class MobileNumber {
    String number;
    BaseTariff tariff;
    Customer user;
    double balance;

    public MobileNumber(String number, BaseTariff tariff, Customer user, double balance) {
        this.number = number;
        this.tariff = tariff;
        this.user = user;
        this.balance = balance;
    }

    public String toString() {
        return "Mobile Number: " + this.number + ", tariff: " + this.tariff.toString() + ", user: " + this.user;
    }

    public void setTariff(BaseTariff tariff) {
        this.tariff = tariff;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

