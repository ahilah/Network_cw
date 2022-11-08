package hileta.com.menu.command.search.tariffs;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.network.Network;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SearchTariffsTest {
    Network network;
    List<BaseTariff> tariffs;
    SearchTariffs search;

    @AfterEach
    void tearDown() {
        network.getArchivedTariffs().clear();
        network.getAvailableTariffs().clear();
        tariffs.clear();
    }

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
        network.addTariff(tariff1);
        network.addTariff(tariff2);
        network.addTariff(tariff3);
        network.addTariff(tariff4);

        tariffs.add(tariff2);

        search = new SearchTariffs(network);
    }

    @Test
    void fillListTariffs() {
        search.callSpectrum(0);
        List <BaseTariff> actual = search.fillListTariffs();
        try {
            Assertions.assertArrayEquals(tariffs.toArray(), actual.toArray());
        }
        catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}