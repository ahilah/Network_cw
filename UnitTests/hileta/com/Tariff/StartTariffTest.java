package hileta.com.Tariff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StartTariffTest {
    @Test
    void StartTest() {
        StartTariff start = new StartTariff();
        start.setTariffID("1");
        start.setPriceTariff(10);
        start.setNameTariff("11");
        start.setNumberOfUsers(10);
        start.setSMSNumber(15);
        start.setNumberMinutesThisOperator(50);
        Assertions.assertEquals("Start Tariff 11\n" +
                "\t\t\t(number of SMS: 15,\n" +
                "\t\t\tnumber of minutes on this operator: 50.0,\n" +
                "\t\t\tprice of tariff in hryvnias: 10,\n" +
                "\t\t\ttariff ID: 1,\n" +
                "\t\t\tgeneral number of tariff users: 10)", start.toString());
        Assertions.assertEquals("| Start Tariff     11                  | 15        | 50,00        | 10        | 1              | 10        |     -         |     -         |     -    |\n" +
                "|-----------------------------------------------------------------------------------------------------------------------------------------------------|", start.rowTable());
    }
}