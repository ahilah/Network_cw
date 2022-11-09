package hileta.com.menu.command.fromfile;

import hileta.com.network.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileMobileNumberTest {
    static Network network;
    static FileMobileNumber file;
    String filePath;

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        file = new FileMobileNumber(network, "D:\\test4.txt");
    }

    @AfterAll
    static void afterAll() {
        network.getAvailableTariffs().clear();
        network.getCustomers().clear();
        network.getListMobileNumbers().clear();
    }

    @Test
    void execute() {
        Assertions.assertTrue(network.isListTariffsEmpty());
        Assertions.assertTrue(network.isListCustomersEmpty());

        FileCustomer customer = new FileCustomer(network, "D:\\test3.txt");
        customer.execute();
        Assertions.assertTrue(network.isListTariffsEmpty());
        Assertions.assertFalse(network.isListCustomersEmpty());

        FileTariff tariff = new FileTariff(network, "D:\\test1.txt");
        tariff.execute();
        Assertions.assertFalse(network.isListCustomersEmpty());
        Assertions.assertFalse(network.isListTariffsEmpty());

        file.execute();
        Assertions.assertEquals("3807775", network.getMobileNumber(19).getNumber());
        Assertions.assertFalse(network.isListMobileNumbersEmpty());
    }
}