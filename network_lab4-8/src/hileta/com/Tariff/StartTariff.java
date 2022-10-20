package hileta.com.Tariff;

public class StartTariff extends BaseTariff {

    public StartTariff(String nameTariff, int SMSNumber, double numberMinutesThisOperator, int priceTariff, String tariffID) {
        super(nameTariff, SMSNumber, numberMinutesThisOperator, priceTariff, tariffID);
    }

    @Override
    public String toString() {
        return "Start Tariff " + super.toString() + ")";
    }

    @Override
    public String rowTable() {
        return String.format("|%-17s ", " Start Tariff ") + super.rowTable() +
                String.format(" %-14s| %-14s| %-9s|", "    -    ", "    -    ", "    -    ") +
                "\n|-------------------------------------" +
                "-----------------------------------------" +
                "-----------------------------------------------------------------------|";
    }
}