package hileta.com.network;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CustomerTest {
    static Customer customer;

    @BeforeAll
    static void beforeAll() {
        customer = new Customer("Anna", "1");
    }

    @Test
    void getCustomerID() {
        Assertions.assertEquals("1", customer.getCustomerID());
    }

    @Test
    void getName() {
        Assertions.assertEquals("Anna", customer.getName());
    }

    @Test
    void setName() {
        customer.setName("John");
        Assertions.assertEquals("John", customer.getName());
    }

    @Test
    void setCustomerID() {
        customer.setCustomerID("2");
        Assertions.assertEquals("2", customer.getCustomerID());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Name: Anna, ID: 2", customer.toString());
    }
}