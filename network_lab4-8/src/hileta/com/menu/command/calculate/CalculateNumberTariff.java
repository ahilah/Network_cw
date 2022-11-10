package hileta.com.menu.command.calculate;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperTariff;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.List;

public class CalculateNumberTariff {
    private static Logger logger = LogManager.getLogger(CalculateNumberTariff.class);
    private final List<BaseTariff> tariffs;
    private int startNumber;
    private int superNumber;
    private int superNetNumber;

    public CalculateNumberTariff(List<BaseTariff> tariffs) {
        this.tariffs = tariffs;
        calculateNumberTariffsTypes();
    }

    private void calculateNumberTariffsTypes() {
        logger.info("Calculate number tariffs types was executed");
        for (BaseTariff tariff : tariffs) {
            if (tariff instanceof StartTariff) startNumber++;
            else if (tariff instanceof SuperTariff) superNumber++;
            else superNetNumber++;
        }
    }

    public int getStartNumber() {
        return startNumber;
    }

    public int getSuperNumber() {
        return superNumber;
    }

    public int getSuperNetNumber() {
        return superNetNumber;
    }
}
