package hileta.com.menu.command.search;

import hileta.com.network.Abroad;
import hileta.com.network.Network;
import org.junit.jupiter.api.*;

class SearchAbroadTest {
    static Network network;
    static SearchAbroad search;

    @AfterAll
    static void afterAll() {
        network.getListAbroad().clear();
    }

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        search = new SearchAbroad(network);
        network.addAbroad(new Abroad("Poland", 10));
        network.addAbroad(new Abroad("USA", 15));
        network.addAbroad(new Abroad("Italy", 20));
        network.addAbroad(new Abroad("Canada", 25));
    }

    @Test
    void searchAbroad() {
        Abroad abroad = search.searchAbroad("Canada");
        Assertions.assertNotNull(abroad);
        Assertions.assertEquals(25, abroad.getPricePerMinute());
    }
}