package hileta.com.menu.command.fromfile;

import hileta.com.network.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileTariffsArchiveTest {
    static Network network;
    static FileTariffsArchive file;

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        file = new FileTariffsArchive(network, "D:\\test1.txt");
        network.getAvailableTariffs().clear();
        network.getArchivedTariffs().clear();
    }

    @AfterAll
    static void afterAll() {
        network.getAvailableTariffs().clear();
        network.getArchivedTariffs().clear();
    }

    @Test
    void execute() {
        file.execute();
        Assertions.assertTrue(network.getAvailableTariffs().isEmpty());
        Assertions.assertNotNull(network.getArchivedTariffs());
        Assertions.assertEquals("33333", network.getArchivedTariff(7).getTariffID());
        Assertions.assertEquals(8, network.getNumberArchivedTariffs());
    }
}