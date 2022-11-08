package hileta.com.menu.command.add;

import hileta.com.network.Network;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AddTariffTest {
    static AddTariff add;

    @BeforeAll
    static void beforeAll() {
        add = new AddTariff(Network.getNetwork("test1", "1", "test01"));
    }

    @Test
    void splitString() {
        String[] expected = new String[] {"1", "2", "3", "8", "9"};
        String[] actual = add.splitString("1--2---3-----8-9");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void getNewStartTariff() {
        String[] info = new String[] {"Angst", "@", "300", "90", "1"};
        Assertions.assertEquals(9999, add.getNewStartTariff(info).getSMSNumber());
    }

    @Test
    void getNewSuperTariff() {
        String[] info = new String[] {"Test1", "@", "120", "100", "1","120", "20"};
        Assertions.assertEquals(9999, add.getNewSuperTariff(info).getSMSNumber());
    }

    @Test
    void getNewSuperNetTariff() {
        String[] info = new String[] {"Test2", "@", "250", "25", "14","200", "16", "15"};
        Assertions.assertEquals(9999, add.getNewSuperNetTariff(info).getSMSNumber());
    }
}