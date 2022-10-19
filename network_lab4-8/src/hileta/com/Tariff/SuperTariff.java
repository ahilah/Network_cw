package hileta.com.Tariff;


public class SuperTariff extends BaseTariff {
    private double numberMinutesOtherNetwork;
    private double numberMinutesOtherCountries;

    public SuperTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator,
                       int priceTariff, String tariffID, double numberMinutesOtherNetwork,
                       double numberMinutesOtherCountries) {
        super(nameTariff, SMSNumber, numberMinutesThisOperator, priceTariff, tariffID);
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
    }

    public double getNumberMinutesOtherNetwork() {
        return numberMinutesOtherNetwork;
    }

    public double getNumberMinutesOtherCountries() {
        return numberMinutesOtherCountries;
    }

    public void setNumberMinutesOtherNetwork(double numberMinutesOtherNetwork) {
        this.numberMinutesOtherNetwork = numberMinutesOtherNetwork;
    }

    public void setNumberMinutesOtherCountries(double numberMinutesOtherCountries) {
        this.numberMinutesOtherCountries = numberMinutesOtherCountries;
    }

    @Override
    public String toString() {
        return "Super Tariff " + super.toString() +
                ",\n\t\t\tnumber of minutes on other network: " + this.numberMinutesOtherNetwork +
                ",\n\t\t\tnumber of minutes on other countries: " + this.numberMinutesOtherCountries + ")";
    }
}
