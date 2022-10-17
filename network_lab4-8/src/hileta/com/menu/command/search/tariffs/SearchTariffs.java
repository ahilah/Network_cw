package hileta.com.menu.command.search.tariffs;

import hileta.com.Tariff.BaseTariff;
import hileta.com.menu.command.commandable.MenuCommand;
import hileta.com.network.Network;

import java.util.ArrayList;
import java.util.List;

public class SearchTariffs implements MenuCommand {
    private final Network network;
    private SpectrumParameters spectrum;
    private List<BaseTariff> tariffs;

    public SearchTariffs(Network network) {
        this.network = network;
        spectrum = new SpectrumParameters();
        tariffs = new ArrayList<>();
    }

    @Override
    public void execute() {
        fillListTariffs();
    }

    private void fillListTariffs() {
        for (int i = 0; i < network.getNumberAvailableTariffs(); i++) {
            BaseTariff tariff = network.getTariff(i);
            if (isTariffMatch(tariff))
                tariffs.add(tariff);
        }
    }

    private boolean isTariffMatch(BaseTariff tariff) {
        return spectrum.getSMSNumber_l() <= tariff.getSMSNumber() &&
                spectrum.getSMSNumber_u() >= tariff.getSMSNumber() &&
                spectrum.getPriceTariff_l() <= tariff.getPriceTariff() &&
                spectrum.getPriceTariff_u() >= tariff.getPriceTariff() &&
                spectrum.getMinThisNet_l() <= tariff.getNumberMinutesThisOperator() &&
                spectrum.getMinThisNet_u() >= tariff.getNumberMinutesThisOperator();
    }

    private void filterTariffs() {
        
    }

}
