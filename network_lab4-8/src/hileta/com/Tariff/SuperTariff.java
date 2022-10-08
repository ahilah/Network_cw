package hileta.com.Tariff;


public class SuperTariff extends BaseTariff {
    double numberMinutesOtherNetwork;
    double numberMinutesOtherCountries;

    SuperTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator, int priceTariff, String tariffID, double numberMinutesOtherNetwork, double numberMinutesOtherCountries) {
        super(nameTariff, SMSNumber, numberMinutesThisOperator, priceTariff, tariffID);
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
    }

    public void setNumberMinutesOtherNetwork(double numberMinutesOtherNetwork) {
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
    }

    public void setNumberMinutesOtherCountries(double numberMinutesOtherCountries) {
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
    }

    public String toString() {
        String var10000 = super.toString();
        return "Super Tariff (" + var10000 + " number of minutes on other network: " + this.numberMinutesOtherNetwork + ", number of minutes on other countries: " + this.numberMinutesOtherCountries + ")";
    }
}
