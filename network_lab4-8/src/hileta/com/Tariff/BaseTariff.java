package hileta.com.Tariff;

public abstract class BaseTariff implements Comparable<BaseTariff> {
    String nameTariff;
    int SMSNumber;
    double numberMinutesThisOperator;
    int priceTariff;
    String tariffID;
    int numberOfUsers = 0;

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

    public void setNameTariff(String nameTariff) {
        this.nameTariff = nameTariff;
    }

    public void setSMSNumber(int SMSNumber) {
        this.SMSNumber = SMSNumber;
    }

    public void setNumberMinutesThisOperator(double numberMinutesThisOperator) {
        this.numberMinutesThisOperator = numberMinutesThisOperator;
    }

    public void setPriceTariff(int priceTariff) {
        this.priceTariff = priceTariff;
    }

    public void setTariffID(String tariffID) {
        this.tariffID = tariffID;
    }

    public void setNumberOfUsers(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    @Override
    public int compareTo(BaseTariff o) {
        return this.priceTariff - o.getPriceTariff();
    }

    public String toString() {
        return  this.nameTariff + ",\n\t\t\tnumber of SMS: " + this.SMSNumber +
                ",\n\t\t\tnumber of minutes on this operator: " + this.numberMinutesThisOperator +
                ",\n\t\t\tprice of tariff in hryvnias: " + this.priceTariff +
                ",\n\t\t\ttariff ID: " + this.tariffID +
                ",\n\t\t\tgeneral number of tariff users: " + this.numberOfUsers;
    }
}
