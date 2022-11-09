package hileta.com.menu.command.fromfile;

import hileta.com.network.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileCustomerTest {
    static Network network;
    static FileCustomer file;
    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        file = new FileCustomer(network, "D:\\test3.txt");
    }

    @AfterAll
    static void afterAll() {
        network.getCustomers().clear();
    }

    @Test
    void execute() {
        file.execute();
        Assertions.assertNotNull(network.getCustomers());
        Assertions.assertEquals("Anna", network.getCustomer(0).getName());
    }
}