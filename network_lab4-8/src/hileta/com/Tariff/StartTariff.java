package hileta.com.Tariff;

public class StartTariff extends BaseTariff {

    public StartTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator, int priceTariff, String tariffID) {
        super(nameTariff, SMSNumber, numberMinutesThisOperator, priceTariff, tariffID);
    }

    public String toString() {
        return "Start Tariff " + super.toString() + ")";
    }


}