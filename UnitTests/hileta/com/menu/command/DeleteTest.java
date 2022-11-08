package hileta.com.menu.command;

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

class DeleteTest {
    static Network network;
    static Delete delete;
    @AfterAll
    static void afterAll() {
        network.getAvailableTariffs().clear();
        network.getListMobileNumbers().clear();
        network.getCustomers().clear();
    }

    @BeforeAll
    static void beforeAll() {
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
        delete = new Delete(network);
    }

    @Test
    void changeTariffsAfterRemoving() {
        delete.changeTariffsAfterRemoving(0,1);
        Assertions.assertEquals("4", network.getMobileNumber(0).getTariffID());
    }
}