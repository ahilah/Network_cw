package hileta.com.Tariff;

public class SuperNetTariff extends BaseTariff {
    private double numberMinutesOtherNetwork;
    private double numberMinutesOtherCountries;
    private double mobileInternet;

    public SuperNetTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator, int priceTariff, String tariffID, double numberMinutesOtherNetwork, double numberMinutesOtherCountries, double mobileInternet) {
        super(nameTariff, SMSNumber, numberMinutesThisOperator, priceTariff, tariffID);
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
        this.mobileInternet = mobileInternet;
    }

    public double getNumberMinutesOtherNetwork() {
        return numberMinutesOtherNetwork;
    }

    public BaseTariff setNumberMinutesOtherNetwork(double numberMinutesOtherNetwork) {
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
        return this;
    }

    public double getNumberMinutesOtherCountries() {
        return numberMinutesOtherCountries;
    }

    public BaseTariff setNumberMinutesOtherCountries(double numberMinutesOtherCountries) {
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
        return this;
    }

    public double getMobileInternet() {
        return mobileInternet;
    }

    public BaseTariff setMobileInternet(double mobileInternet) {
        this.mobileInternet = mobileInternet;
        return this;
    }

    @Override
    public String toString() {
        return "Super Net Tariff " + super.toString() +
                ",\n\t\t\tnumber of minutes on other network: " + this.numberMinutesOtherNetwork +
                ",\n\t\t\tnumber of minutes on other countries: " + this.numberMinutesOtherCountries +
                ",\n\t\t\tGB of mobile Internet: " + this.mobileInternet + ")";
    }

    @Override
    public String rowTable() {
        return String.format("|%-15s ", " Super Net Tariff") + super.rowTable() + String.format(" %-14.2f| %-14.2f| %-9.2f|",
                this.numberMinutesOtherNetwork, this.numberMinutesOtherCountries, this.mobileInternet) +
                "\n|-------------------------------------" +
                "-----------------------------------------" +
                "-----------------------------------------------------------------------|";
    }
}