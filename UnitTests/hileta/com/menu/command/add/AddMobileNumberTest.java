package hileta.com.menu.command.add;

import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import hileta.com.network.Customer;
import hileta.com.network.MobileNumber;
import hileta.com.network.Network;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AddMobileNumberTest {
    static AddMobileNumber add;
    static Network network;

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("test1", "1", "test01");
        add = new AddMobileNumber(network);

        network.addCustomer(new Customer("Anna", "1"));
        network.addCustomer(new Customer("John", "2"));

        network.addMobileNumber(new MobileNumber("111", "1", "1", 10));
        network.addMobileNumber(new MobileNumber("222", "3", "2", 500));

        network.addTariff(new StartTariff("Angst",17,
                300, 90, "1"));
        network.addTariff(new SuperNetTariff("Volue-Vue",150 ,
                500, 10, "4",
                200, 60, 10));
        network.archiveTariff(new SuperTariff("Hayloft",300 ,
                200, 75, "3",
                120, 50));
    }

    @AfterEach
    void tearDown() {
        network.getCustomers().clear();
    }

    @Test
    void getCheckedNoCustomer() {
        Assertions.assertEquals(0, add.getCheckedNoCustomer(-9));
        Assertions.assertEquals(0, add.getCheckedNoCustomer(1));
    }

    @Test
    void getCheckedNoTariff() {
        Assertions.assertEquals(0, add.getCheckedNoTariff(-9));
        Assertions.assertEquals(0, add.getCheckedNoTariff(1));
    }

    @Test
    void getCheckedBalance() {
        Assertions.assertEquals(0, add.getCheckedBalance(-9));
        Assertions.assertEquals(100, add.getCheckedBalance(100));
    }
}