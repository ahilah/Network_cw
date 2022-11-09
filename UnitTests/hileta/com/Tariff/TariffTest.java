package hileta.com.Tariff;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TariffTest {
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

    @Test
    void SuperTest() {
        SuperTariff superT = new SuperTariff("Hayloft",300 ,
                200, 75, "3",
                120, 50);
        Assertions.assertEquals("| Super Tariff     Hayloft             |" +
                " 300       | 200,00       | 75        | 3              | 0         |" +
                " 120,00        | 50,00         |     -    |\n" +
                "|--------------------------------------------------------------------" +
                "-----------------------------------------------------------------------" +
                "----------|", superT.rowTable());
    }

    @Test
    void SuperNetTest() {
        SuperNetTariff superT = new SuperNetTariff("Hayloft",300 ,
                200, 75, "3",
                120, 50, 11);
        Assertions.assertEquals("| Super Net Tariff Hayloft             | 300" +
                "       | 200,00       | 75        | 3              | 0         | 120,00" +
                "        | 50,00         | 11,00    |\n" +
                "|------------------------------------------------------------------------" +
                "--------------------------------------------------------------------------" +
                "---|", superT.rowTable());
    }
}