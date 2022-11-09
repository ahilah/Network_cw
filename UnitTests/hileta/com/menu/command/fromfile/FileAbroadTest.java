package hileta.com.menu.command.fromfile;

import hileta.com.network.Network;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileAbroadTest {
    static Network network;
    static FileAbroad file;

    @AfterAll
    static void afterAll() {
        network.getListAbroad().clear();

    }

    @BeforeAll
    static void beforeAll() {
        network = Network.getNetwork("LvivNet", "06985471", "lvivnet@com");
        file = new FileAbroad(network, "D:\\test6.txt");
    }

    @Test
    void execute() {
        file.execute();
        Assertions.assertEquals("Algeria", network.getAbroad(0).getCountry());
    }
}