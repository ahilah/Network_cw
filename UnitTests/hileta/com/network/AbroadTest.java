package hileta.com.network;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AbroadTest {
    static Abroad abroad;

    @BeforeAll
    static void beforeAll() {
        abroad = new Abroad("Poland", 10);
    }

    @Test
    void getCountry() {
        Assertions.assertEquals("Poland", abroad.getCountry());
    }

    @Test
    void getPricePerMinute() {
        Assertions.assertEquals(10, abroad.getPricePerMinute());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("Country: Poland, price per minute: 10.0", abroad.toString());
    }

    @Test
    void rowTable() {
        Assertions.assertEquals("|  Poland                         |  10,00     |\n" +
                "|----------------------------------------------|", abroad.rowTable());
    }
}