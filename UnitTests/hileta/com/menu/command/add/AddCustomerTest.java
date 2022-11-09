package hileta.com.menu.command.add;

import hileta.com.network.Customer;
import hileta.com.network.Network;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddCustomerTest {

    @Test
    void getNewCustomer() {
        Network network = Network.getNetwork("test1", "1", "test01");
        AddCustomer add = new AddCustomer(network);
        Customer customer = add.getNewCustomer("Anna", "1");
        Assertions.assertEquals("1", customer.getCustomerID());
    }
}