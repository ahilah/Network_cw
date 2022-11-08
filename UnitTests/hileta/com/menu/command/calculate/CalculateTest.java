package hileta.com.menu.command.calculate;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.network.Network;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateTest {

    static Network network;
    static List<BaseTariff> tariffs;
    Calculate calculate;

    @BeforeEach
    void setUp() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        tariffs = new ArrayList<>(4);
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
        network.getAvailableTariffs().clear();

        network.addTariff(tariff1);
        network.addTariff(tariff2);

        network.archiveTariff(tariff3);
        network.archiveTariff(tariff4);

        calculate = new Calculate(network);
    }

    @AfterEach
    void tearDown() {
        network.getAvailableTariffs().clear();
        network.getArchivedTariffs().clear();
        tariffs.clear();
    }

    @Test
    void generalTariffNumber() {
        assertEquals(4, calculate.generalTariffNumber());
    }
}