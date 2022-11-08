package hileta.com.menu.command.calculate;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CalculateNumberTariffTest {
    List<BaseTariff> tariffs;
    CalculateNumberTariff calculate;

    @BeforeEach
    void setUp() {
        tariffs = new ArrayList<BaseTariff>(4);
        tariffs.add(new StartTariff("Angst", 17,
                        300, 90, "1"));
        tariffs.add(new StartTariff("Pile", 20,
                    200, 45, "2"));
        tariffs.add(new SuperTariff("Hayloft", 300,
                    200, 75, "3",
                    120, 50));
        tariffs.add(new SuperNetTariff("Volue-Vue", 150,
                    500, 10, "4",
                    200, 60, 10));

        calculate = new CalculateNumberTariff(tariffs);
    }

    @AfterEach
    void tearDown() {
        tariffs.clear();
    }

    @Test
    void getStartNumber() {
        Assertions.assertEquals(2, calculate.getStartNumber());
    }

    @Test
    void getSuperNumber() {
        Assertions.assertEquals(1, calculate.getSuperNumber());
    }

    @Test
    void getSuperNetNumber() {
        Assertions.assertEquals(1, calculate.getSuperNetNumber());
    }
}