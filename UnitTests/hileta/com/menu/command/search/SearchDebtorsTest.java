package hileta.com.menu.command.search;

import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.network.Customer;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchDebtorsTest {
    static Network network;
    static SearchDebtors search;
    @AfterAll
    static void afterAll() {
        network.getArchivedTariffs().clear();
        network.getAvailableTariffs().clear();
        network.getListMobileNumbers().clear();
        network.getCustomers().clear();
        search.clearDebtors();
    }

    @BeforeAll
    static void beforeAll() {
        //search.clearDebtors();
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        network.addTariff(new StartTariff("Angst",17,
                300, 90, "1"));
        network.addTariff(new SuperNetTariff("Volue-Vue",150 ,
                500, 10, "4",
                200, 60, 10));
        network.archiveTariff(new SuperTariff("Hayloft",300 ,
                200, 75, "3",
                120, 50));
        network.addCustomer(new Customer("Anna", "1"));
        network.addCustomer(new Customer("John", "2"));
        network.addMobileNumber(new MobileNumber("111", "1", "1", 10));
        network.addMobileNumber(new MobileNumber("222", "3", "2", 500));
        search = new SearchDebtors(network);
    }
    @Test
    void execute() {
        Customer customer = network.getCustomer(0);
        search.execute();
        Assertions.assertNotNull(search.getDebtors());
        Assertions.assertEquals(customer, search.getDebtors(network.getMobileNumber(0)));
    }
}