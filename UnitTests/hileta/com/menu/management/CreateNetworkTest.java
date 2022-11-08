package hileta.com.menu.management;

import hileta.com.network.Network;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateNetworkTest {
    CreateNetwork create;

    @BeforeEach
    void setUp() {
       create = new CreateNetwork();
    }

    @Test
    void execute() {
        create.execute();
    }

    @Test
    void networkCompanyInfo() {
        Network network = Network.getNetwork("test1", "01","test01");
        Assertions.assertEquals(network, create.networkCompanyInfo("test1", "01","test01"));
    }
}