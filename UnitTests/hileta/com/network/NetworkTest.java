package hileta.com.network;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

class NetworkTest {
    static Network network;
    static List<BaseTariff> tariffs;

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("test1", "1", "test01");
        tariffs = new ArrayList<>(4);
    }

    @AfterEach
    void afterAll() {
        network.getArchivedTariffs().clear();
        network.getAvailableTariffs().clear();
        network.getListAbroad().clear();
        network.getListMobileNumbers().clear();
        tariffs.clear();
    }

    @Test
    void getNetwork() {
        Network network1 = Network.getNetwork("KyivNet", "0874551221", "kyivnet@com");
        Assertions.assertEquals(network1, network);
    }

    @Test
    void addAndDeleteTariff() {
        //tariffs.clear();
        BaseTariff tariff4 = new StartTariff("Angst",17,
                300, 90, "1");
        BaseTariff tariff2 = new StartTariff("Pile",20 ,
                200, 45, "2");
        BaseTariff tariff3 = new SuperTariff("Hayloft",300 ,
                200, 75, "3",
                120, 50);
        BaseTariff tariff1 = new SuperNetTariff("Volue-Vue",150 ,
                500, 10, "4",
                200, 60, 10);

        tariffs.add(tariff1);
        tariffs.add(tariff2);
        tariffs.add(tariff3);
        tariffs.add(tariff4);

        network.addTariff(tariff1);
        network.addTariff(tariff2);
        network.addTariff(tariff3);
        network.addTariff(tariff4);

        Assertions.assertArrayEquals(tariffs.toArray(), network.getAvailableTariffs().toArray());

        tariffs.remove(3);
        network.deleteTariff(3);
        Assertions.assertArrayEquals(tariffs.toArray(), network.getAvailableTariffs().toArray());

        //tariffs.clear();
        //network.getAvailableTariffs().clear();
    }

    @Test
    void addMobileNumber() {
        Abroad abroad = new Abroad("France", 10.5);
        network.addAbroad(abroad);
        Assertions.assertEquals(abroad, network.getAbroad(0));
    }

    @Test
    void archiveTariff() {
        network.getArchivedTariffs().clear();
        BaseTariff tariff4 = new StartTariff("Angst",17,
                300, 90, "1");
        network.archiveTariff(tariff4);
        tariffs.clear();
        tariffs.add(tariff4);
        Assertions.assertArrayEquals(tariffs.toArray(), network.getArchivedTariffs().toArray());
    }

    @Test
    void sortAvailableTariffs() {
        network.getAvailableTariffs().clear();

        BaseTariff tariff1 = new StartTariff("Angst",17,
                300, 90, "1");
        BaseTariff tariff3 = new StartTariff("Pile",20 ,
                200, 45, "2");
        BaseTariff tariff2 = new SuperTariff("Hayloft",300 ,
                200, 75, "3",
                120, 50);
        BaseTariff tariff4 = new SuperNetTariff("Volue-Vue",150 ,
                500, 10, "4",
                200, 60, 10);

        tariffs.clear();
        tariffs.add(tariff4);
        tariffs.add(tariff3);
        tariffs.add(tariff2);
        tariffs.add(tariff1);

        network.addTariff(tariff1);
        network.addTariff(tariff2);
        network.addTariff(tariff3);
        network.addTariff(tariff4);

        network.sortAvailableTariffs();
        Assertions.assertArrayEquals(tariffs.toArray(), network.getAvailableTariffs().toArray());
    }

    @Test
    void getCustomer() {
        network.addCustomer(new Customer("Anna", "2"));
        Assertions.assertNotNull(network.getCustomer("2"));
    }

    @Test
    void getNetworkInfo() {
        Assertions.assertEquals("\n" +
                "\t\tNetwork info:\n" +
                "Company name: test1\n" +
                "e-mail: test01\n" +
                "number: 1", network.getNetworkInfo());
    }

    @Test
    void archiveAllAvailableTariffs() {
        network.addTariff(new StartTariff("Angst",17,
                300, 90, "1"));
        Assertions.assertFalse(network.isListTariffsEmpty());
        Assertions.assertTrue(network.getArchivedTariffs().isEmpty());

        network.archiveAllAvailableTariffs();
        Assertions.assertTrue(network.isListTariffsEmpty());
        Assertions.assertFalse(network.getArchivedTariffs().isEmpty());
    }

    @Test
    void isTariffAlreadyExists() {
        network.archiveTariff(new StartTariff("Angst",17,
                300, 90, "1"));
        Assertions.assertTrue(network.isTariffAlreadyExists("1"));
    }

    @Test
    void isMobileNumberAlreadyExist() {
        network.addMobileNumber(new MobileNumber("1212", "1414", "17", 11.5));
        Assertions.assertTrue(network.isMobileNumberAlreadyExist("1212"));
    }

}