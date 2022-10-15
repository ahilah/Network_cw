package hileta.com.network;

public class MobileNumber {
    String number;
    String tariffID;
    String userID;
    double balance;

    public MobileNumber(String number, String tariffID, String userID, double balance) {
        this.number = number;
        this.tariffID = tariffID;
        this.userID = userID;
        this.balance = balance;
    }

    public String toString() {
        return "Mobile Number: " + this.number + ", tariff: " +
                this.tariffID + ", user: " + this.userID + ", balance: " + this.balance;
    }

    public String getTariffID() {
        return tariffID;
    }

    public String getNumber() {
        return number;
    }

    public void setTariffID(String tariffID) {
        this.tariffID = tariffID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

