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

    /*public double getNumberMinutesOtherNetwork() {
        return numberMinutesOtherNetwork;
    }
    public double getNumberMinutesOtherCountries() {
        return numberMinutesOtherCountries;
    }*/


    @Override
    public String toString() {
        return "Super Tariff " + super.toString() +
                ",\n\t\t\tnumber of minutes on other network: " + this.numberMinutesOtherNetwork +
                ",\n\t\t\tnumber of minutes on other countries: " + this.numberMinutesOtherCountries + ")";
    }

    @Override
    public String rowTable() {
        return String.format("|%-17s ", " Super Tariff ") + super.rowTable() + String.format(" %-14.2f| %-14.2f| %-9s|",
                this.numberMinutesOtherNetwork, this.numberMinutesOtherCountries, "    -    ") +
                "\n|-------------------------------------" +
                "-----------------------------------------" +
                "-----------------------------------------------------------------------|";
    }
}