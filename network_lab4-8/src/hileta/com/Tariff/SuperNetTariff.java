package hileta.com.Tariff;

public class SuperNetTariff extends BaseTariff {
    double numberMinutesOtherNetwork;
    double numberMinutesOtherCountries;
    double mobileInternet;

    public SuperNetTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator, int priceTariff, String tariffID, double numberMinutesOtherNetwork, double numberMinutesOtherCountries, double mobileInternet) {
        super(nameTariff, SMSNumber, numberMinutesThisOperator, priceTariff, tariffID);
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
        this.mobileInternet = mobileInternet;
    }

    public String toString() {
        return "Super Net Tariff (" + super.toString() +
                ",\n\t\t\tnumber of minutes on other network: " + this.numberMinutesOtherNetwork +
                ",\n\t\t\tnumber of minutes on other countries: " + this.numberMinutesOtherCountries +
                ",\n\t\t\tGB of mobile Internet: " + this.mobileInternet + ")";
    }
}
