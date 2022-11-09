package hileta.com.menu.command.fromfile;

import hileta.com.network.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileTariffTest {
    static Network network;
    static FileTariff file;

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        file = new FileTariff(network, "D:\\test1.txt");
    }

    @AfterAll
    static void afterAll() {
        network.getAvailableTariffs().clear();
    }

    @Test
    void execute() {
        file.execute();
        Assertions.assertNotNull(network.getAvailableTariffs());
        Assertions.assertEquals("33333", network.getTariff(7).getTariffID());
        Assertions.assertEquals(8, network.getNumberAvailableTariffs());
    }
}