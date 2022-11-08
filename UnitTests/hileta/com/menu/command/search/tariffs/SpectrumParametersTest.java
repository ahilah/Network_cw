package hileta.com.menu.command.search.tariffs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpectrumParametersTest {
    SpectrumParameters spct;

    @BeforeEach
    void setUp() {
        spct = new SpectrumParameters(1, 100,
                1, 200, 1, 300);
    }

    @Test
    void getSMSNumber_l() {
        Assertions.assertEquals(1, spct.getSMSNumber_l());
    }

    @Test
    void getSMSNumber_u() {
        Assertions.assertEquals(100, spct.getSMSNumber_u());
    }

    @Test
    void getMinThisNet_l() {
        Assertions.assertEquals(1, spct.getMinThisNet_l());
    }

    @Test
    void getMinThisNet_u() {
        Assertions.assertEquals(200, spct.getMinThisNet_u());
    }

    @Test
    void getPriceTariff_l() {
        Assertions.assertEquals(1, spct.getPriceTariff_l());
    }

    @Test
    void getPriceTariff_u() {
        Assertions.assertEquals(300, spct.getPriceTariff_u());
    }
}