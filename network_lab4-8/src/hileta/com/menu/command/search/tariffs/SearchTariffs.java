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
        List<BaseTariff> filteredBaseParameters = fillListTariffs();
        tariffs = filterAdditionalParameters(filteredBaseParameters);
        System.out.println("\n\t\t Filtered tariffs: ");
        if (tariffs.isEmpty()) {
            System.out.println("there is no such tariffs");
        } else
            for (BaseTariff tariff : tariffs) {
            System.out.println(tariff);
        }
    }

    private List<BaseTariff> fillListTariffs() {
        List<BaseTariff> filteredBaseParameters = new ArrayList<>();
        for (int i = 0; i < network.getNumberAvailableTariffs(); i++) {
            BaseTariff tariff = network.getTariff(i);
            if (isBaseParametersMatch(tariff))
                filteredBaseParameters.add(tariff);
        }
        return filteredBaseParameters;
    }
    private boolean isBaseParametersMatch(BaseTariff tariff) {
        return spectrum.getSMSNumber_l() <= tariff.getSMSNumber() &&
                spectrum.getSMSNumber_u() >= tariff.getSMSNumber() &&
                spectrum.getPriceTariff_l() <= tariff.getPriceTariff() &&
                spectrum.getPriceTariff_u() >= tariff.getPriceTariff() &&
                spectrum.getMinThisNet_l() <= tariff.getNumberMinutesThisOperator() &&
                spectrum.getMinThisNet_u() >= tariff.getNumberMinutesThisOperator();
    }
    private List<BaseTariff> filterAdditionalParameters(List<BaseTariff> notFilteredTariffs) {
        List<BaseTariff> filteredTariffs = new ArrayList<>();
        if (isAdditionalParamNeeded()) {
            notFilteredTariffs.removeIf(tariff -> tariff instanceof SuperNetTariff || tariff instanceof SuperTariff);
            filteredTariffs.addAll(notFilteredTariffs);
        } else {
            filteredTariffs.addAll(filterSuperTariffs(notFilteredTariffs));
            }
        return filteredTariffs;
    }
    private boolean isAdditionalParamNeeded() {
        return spectrum.getMinOtherCountries_u() == 0 || spectrum.getMinOtherNet_u() == 0;
    }
    private List<BaseTariff> filterSuperTariffs(List<BaseTariff> notFilteredTariffs) {
        List<BaseTariff> filteredTariffs = new ArrayList<>();
        notFilteredTariffs.removeIf(tariff -> tariff instanceof StartTariff);
        if (isInternedNeeded()) {
            filteredTariffs.addAll(filterSuperNetTariffs(notFilteredTariffs));
        } else {
            notFilteredTariffs.removeIf(tariff1 -> tariff1 instanceof SuperNetTariff);
            for (BaseTariff tariff : notFilteredTariffs) {
                SuperTariff superTariff = (SuperTariff) tariff;
                if (isSuperParamMatch(superTariff))
                    filteredTariffs.add(tariff);
            }
        }
        return filteredTariffs;
    }
    private boolean isInternedNeeded() {
        return spectrum.getMinThisNet_u() != 0;
    }
    private List<BaseTariff> filterSuperNetTariffs(List<BaseTariff> notFilteredTariffs) {
        List<BaseTariff> filteredTariffs = new ArrayList<>();
        notFilteredTariffs.removeIf(tariff -> tariff instanceof SuperTariff);
        for (BaseTariff tariff : notFilteredTariffs) {
            SuperNetTariff netTariff = (SuperNetTariff) tariff;
            if (isSuperNetParamMatch(netTariff))
                filteredTariffs.add(tariff);
        }
        return filteredTariffs;
    }
    private boolean isSuperNetParamMatch(SuperNetTariff netTariff) {
        return netTariff.getMobileInternet() >= spectrum.getMobileInternet_l() &&
                netTariff.getMobileInternet() <= spectrum.getMobileInternet_u() &&
                netTariff.getNumberMinutesOtherCountries() >= spectrum.getMinOtherCountries_l() &&
                netTariff.getNumberMinutesOtherCountries() <= spectrum.getMinOtherCountries_u() &&
                netTariff.getNumberMinutesOtherNetwork() >= spectrum.getMinOtherNet_l() &&
                netTariff.getNumberMinutesOtherNetwork() <= spectrum.getMinOtherNet_u();
    }
    private boolean isSuperParamMatch(SuperTariff superTariff) {
        return superTariff.getNumberMinutesOtherCountries() >= spectrum.getMinOtherCountries_l() &&
                superTariff.getNumberMinutesOtherCountries() <= spectrum.getMinOtherCountries_u() &&
                superTariff.getNumberMinutesOtherNetwork() >= spectrum.getMinOtherNet_l() &&
                superTariff.getNumberMinutesOtherNetwork() <= spectrum.getMinOtherNet_u();
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
}
