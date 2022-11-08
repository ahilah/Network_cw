package hileta.com.menu.command.search;

import hileta.com.network.MobileNumber;
import hileta.com.network.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchMobileNumbersTest {
    static Network network;
    static SearchMobileNumbers search;

    @AfterAll
    static void afterAll() {
        network.getListMobileNumbers().clear();
    }

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        search = new SearchMobileNumbers(network);
        network.addMobileNumber(new MobileNumber("111111111", "1918", "1", 33));
        network.addMobileNumber(new MobileNumber("222222222", "3235", "2", 95));
    }
    @Test
    void searchMNumbers() {
        search.searchMNumbers("2");
        Assertions.assertNotNull(search.getCustomerNumbers());
        Assertions.assertEquals("222222222", search.getCustomerNumbers().get(0).getNumber());
    }
}