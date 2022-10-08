package hileta.com.Tariff;

public class SuperNetTariff extends BaseTariff {
    double numberMinutesOtherNetwork;
    double numberMinutesOtherCountries;
    double mobileInternet;

    SuperNetTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator, int priceTariff, String tariffID, double numberMinutesOtherNetwork, double numberMinutesOtherCountries, double mobileInternet) {
        super(nameTariff, SMSNumber, numberMinutesThisOperator, priceTariff, tariffID);
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
        this.mobileInternet = mobileInternet;
    }

    public String toString() {
        String var10000 = super.toString();
        return "Super Net Tariff (" + var10000 + " number of minutes on other network: " + this.numberMinutesOtherNetwork + ", number of minutes on other countries: " + this.numberMinutesOtherCountries + ", GB of mobile Internet: " + this.mobileInternet + ")";
    }
}
