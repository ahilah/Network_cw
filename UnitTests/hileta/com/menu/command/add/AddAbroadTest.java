package hileta.com.menu.command.add;

import hileta.com.network.Abroad;
import hileta.com.network.Network;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddAbroadTest {
    Network network;
    AddAbroad abroad;

    @BeforeEach
    void setUp() {
        network = Network.getNetwork("test1", "1", "test01");
        abroad = new AddAbroad(network);
        network.getListAbroad().clear();
    }

    @Test
    void getNewAbroad() {
        Abroad actualAbroad = abroad.getNewAbroad("Poland", 10.0);
        Assertions.assertEquals("Poland", actualAbroad.getCountry());
    }
}