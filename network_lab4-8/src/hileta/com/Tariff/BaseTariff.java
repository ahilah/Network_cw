package hileta.com.Tariff;

public abstract class BaseTariff implements Comparable<BaseTariff> {
    private String nameTariff;
    private int SMSNumber;
    private double numberMinutesThisOperator;
    private int priceTariff;
    private String tariffID;
    private int numberOfUsers = 0;

    BaseTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator, int priceTariff, String tariffID) {
        this.nameTariff = nameTariff;
        this.SMSNumber = SMSNumber;
        this.numberMinutesThisOperator = numberMinutesThisOperator;
        this.priceTariff = priceTariff;
        this.tariffID = tariffID;
    }
    public int getNumberOfUsers() {
        return this.numberOfUsers;
    }
    public String getTariffID() {
        return tariffID;
    }
    public int getPriceTariff() {
        return priceTariff;
    }
    public int getSMSNumber() {
        return SMSNumber;
    }
    public double getNumberMinutesThisOperator() {
        return numberMinutesThisOperator;
    }
    public BaseTariff setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
        return this;
    }
    public BaseTariff setSMSNumber(int SMSNumber) {
        this.SMSNumber = SMSNumber;
        return this;
    }
    public BaseTariff setNumberMinutesThisOperator(double numberMinutesThisOperator) {
        this.numberMinutesThisOperator = numberMinutesThisOperator;
        return this;
    }
    public BaseTariff setPriceTariff(int priceTariff) {
        this.priceTariff = priceTariff;
        return this;
    }
    public BaseTariff setTariffID(String tariffID) {
        this.tariffID = tariffID;
        return this;
    }
    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public int compareTo(BaseTariff o) {
        return this.priceTariff - o.getPriceTariff();
    }

    public String toString() {
        return  this.nameTariff + "\n\t\t\t(number of SMS: " + this.SMSNumber +
                ",\n\t\t\tnumber of minutes on this operator: " + this.numberMinutesThisOperator +
                ",\n\t\t\tprice of tariff in hryvnias: " + this.priceTariff +
                ",\n\t\t\ttariff ID: " + this.tariffID +
                ",\n\t\t\tgeneral number of tariff users: " + this.numberOfUsers;
    }

    public String rowTable() {
        return String.format("%-20s| %-10d| %-13.2f| %-10d| %-15s| %-10d|", this.nameTariff,
                this.SMSNumber, this.numberMinutesThisOperator, this.priceTariff, this.tariffID,
                this.numberOfUsers);
    }
}
