package hileta.com.network;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MobileNumberTest {
    static MobileNumber mnumber;

    @BeforeAll
    static void beforeAll() {
        mnumber = new MobileNumber("1111", "11", "1", 10.5);
    }

    @Test
    void getTariffID() {
        Assertions.assertEquals("22", mnumber.getTariffID());
    }

    @Test
    void getNumber() {
        Assertions.assertEquals("1111", mnumber.getNumber());
    }

    @Test
    void getUserID() {
        Assertions.assertEquals("2", mnumber.getUserID());
    }

    @Test
    void getBalance() {
        Assertions.assertEquals(12.5, mnumber.getBalance());
    }

    @Test
    void setTariffID() {
        mnumber.setTariffID("22");
        Assertions.assertEquals("22", mnumber.getTariffID());
    }

    @Test
    void setUserID() {
        mnumber.setUserID("2");
        Assertions.assertEquals("2", mnumber.getUserID());
    }

    @Test
    void setBalance() {
        mnumber.setBalance(12.5);
        Assertions.assertEquals(12.5, mnumber.getBalance());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Mobile number: 1111, tariff ID: 11, user ID: 1, balance: 12.5", mnumber.toString());
    }
}