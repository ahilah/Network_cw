package hileta.com.menu.command.search.tariffs;

import hileta.com.Tariff.BaseTariff;
import hileta.com.Tariff.StartTariff;
import hileta.com.Tariff.SuperNetTariff;
import hileta.com.Tariff.SuperTariff;
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
        tariffs = new ArrayList<>();
    }

    @Override
    public void execute() {
        spectrum = new SpectrumParameters();
        List<BaseTariff> notFilteredtariffs = fillListTariffs();
        tariffs = filterTariffs(notFilteredtariffs);
        System.out.println("\n\t\t Filtered tariffs: ");
        for(BaseTariff tariff : tariffs)
            System.out.println(tariff);
    }

    private List<BaseTariff> fillListTariffs() {
        List<BaseTariff> notFilteredtariffs = new ArrayList<>();
        for (int i = 0; i < network.getNumberAvailableTariffs(); i++) {
            BaseTariff tariff = network.getTariff(i);
            if (isTariffMatch(tariff))
                notFilteredtariffs.add(tariff);
        }
        return notFilteredtariffs;
    }

    private boolean isTariffMatch(BaseTariff tariff) {
        return spectrum.getSMSNumber_l() <= tariff.getSMSNumber() &&
                spectrum.getSMSNumber_u() >= tariff.getSMSNumber() &&
                spectrum.getPriceTariff_l() <= tariff.getPriceTariff() &&
                spectrum.getPriceTariff_u() >= tariff.getPriceTariff() &&
                spectrum.getMinThisNet_l() <= tariff.getNumberMinutesThisOperator() &&
                spectrum.getMinThisNet_u() >= tariff.getNumberMinutesThisOperator();
    }

    private List<BaseTariff> filterTariffs(List<BaseTariff> notFilteredTariffs) {
        List<BaseTariff> filteredTariffs = new ArrayList<>();
        if (spectrum.getMinOtherCountries_u() == 0 || spectrum.getMinOtherNet_u() == 0) {
            notFilteredTariffs.removeIf(tariff -> tariff instanceof SuperNetTariff || tariff instanceof SuperTariff);
            filteredTariffs.addAll(notFilteredTariffs);

        } else {
            notFilteredTariffs.removeIf(tariff -> tariff instanceof StartTariff);
            if(spectrum.getMinThisNet_u() != 0) {
                notFilteredTariffs.removeIf(tariff -> tariff instanceof SuperTariff);
                for (BaseTariff tariff : notFilteredTariffs) {
                    SuperNetTariff netTariff = (SuperNetTariff) tariff;
                    if (netTariff.getMobileInternet() >= spectrum.getMobileInternet_l() &&
                            netTariff.getMobileInternet() <= spectrum.getMobileInternet_u() &&
                            netTariff.getNumberMinutesOtherCountries() >= spectrum.getMinOtherCountries_l() &&
                            netTariff.getNumberMinutesOtherCountries() <= spectrum.getMinOtherCountries_u() &&
                            netTariff.getNumberMinutesOtherNetwork() >= spectrum.getMinOtherNet_l() &&
                            netTariff.getNumberMinutesOtherNetwork() <= spectrum.getMinOtherNet_u() ) {
                        filteredTariffs.add(tariff);
                    }
                }
            } else {
                notFilteredTariffs.removeIf(tariff1 -> tariff1 instanceof SuperNetTariff);
                for (BaseTariff tariff2 : notFilteredTariffs) {
                        SuperTariff superTariff = (SuperTariff) tariff2;
                        if (superTariff.getNumberMinutesOtherCountries() >= spectrum.getMinOtherCountries_l() &&
                                superTariff.getNumberMinutesOtherCountries() <= spectrum.getMinOtherCountries_u() &&
                                superTariff.getNumberMinutesOtherNetwork() >= spectrum.getMinOtherNet_l() &&
                                superTariff.getNumberMinutesOtherNetwork() <= spectrum.getMinOtherNet_u())
                            filteredTariffs.add(tariff2);
                    }
                }
            }
            /*if () {
                notFilteredTariffs.removeIf(tariff -> tariff instanceof SuperTariff);
                for (BaseTariff tariff : notFilteredTariffs) {
                    SuperNetTariff netTariff = (SuperNetTariff) tariff;
                    if (netTariff.getMobileInternet() >= spectrum.getMobileInternet_l() ||
                            netTariff.getMobileInternet() <= spectrum.getMobileInternet_u())
                        filteredTariffs.add(tariff);
                }
            }}*/
        return filteredTariffs;
    }

}
