package hileta.com.menu.command.search.tariffs;

import static hileta.com.menu.management.MainMenu.scanner;

public class SpectrumParameters {
    private int SMSNumber_l;
    private int SMSNumber_u;
    private double MinThisNet_l;
    private double MinThisNet_u;
    private int priceTariff_l;
    private int priceTariff_u;
    private double MinOtherNet_l;
    private double MinOtherNet_u;
    private double MinOtherCountries_l;
    private double MinOtherCountries_u;
    private double mobileInternet_l;
    private double mobileInternet_u;

    public SpectrumParameters() {
        getSpectrum();
    }

    private void getSpectrum() {
        System.out.println("\n\t\t Enter: ");

        System.out.print("interval of number SMS: ");
        String[] SMS = scanner.nextLine().split(" ");
        SMSNumber_l = Integer.parseInt(SMS[0]);
        SMSNumber_u = Integer.parseInt(SMS[1]);

        System.out.print("interval of minutes on this network: ");
        String[] thisnet = scanner.nextLine().split(" ");
        MinThisNet_l = Double.parseDouble(thisnet[0]);
        MinThisNet_u = Double.parseDouble(thisnet[1]);

        System.out.print("interval of price (in hryvnias): ");
        String[] price = scanner.nextLine().split(" ");
        priceTariff_l = Integer.parseInt(price[0]);
        priceTariff_u = Integer.parseInt(price[1]);

        System.out.print("interval of minutes on other countries: ");
        String[] othernet = scanner.nextLine().split(" ");
        MinOtherNet_l = Double.parseDouble(price[0]);
        MinOtherNet_u = Double.parseDouble(price[1]);

        System.out.print("interval of minutes on other countries: ");
        String[] othercountries = scanner.nextLine().split(" ");
        MinOtherCountries_l = Double.parseDouble(othercountries[0]);
        MinOtherCountries_u = Double.parseDouble(othercountries[1]);

        System.out.print("interval of mobile internet (in GB): ");
        String[] internet = scanner.nextLine().split(" ");
        mobileInternet_l = Double.parseDouble(internet[0]);
        mobileInternet_u = Double.parseDouble(internet[1]);

    }

    public int getSMSNumber_l() {
        return SMSNumber_l;
    }

    public void setSMSNumber_l(int SMSNumber_l) {
        this.SMSNumber_l = SMSNumber_l;
    }

    public int getSMSNumber_u() {
        return SMSNumber_u;
    }

    public void setSMSNumber_u(int SMSNumber_u) {
        this.SMSNumber_u = SMSNumber_u;
    }

    public double getMinThisNet_l() {
        return MinThisNet_l;
    }

    public void setMinThisNet_l(double minThisNet_l) {
        MinThisNet_l = minThisNet_l;
    }

    public double getMinThisNet_u() {
        return MinThisNet_u;
    }

    public void setMinThisNet_u(double minThisNet_u) {
        MinThisNet_u = minThisNet_u;
    }

    public int getPriceTariff_l() {
        return priceTariff_l;
    }

    public void setPriceTariff_l(int priceTariff_l) {
        this.priceTariff_l = priceTariff_l;
    }

    public int getPriceTariff_u() {
        return priceTariff_u;
    }

    public void setPriceTariff_u(int priceTariff_u) {
        this.priceTariff_u = priceTariff_u;
    }

    public double getMinOtherNet_l() {
        return MinOtherNet_l;
    }

    public void setMinOtherNet_l(double minOtherNet_l) {
        MinOtherNet_l = minOtherNet_l;
    }

    public double getMinOtherNet_u() {
        return MinOtherNet_u;
    }

    public void setMinOtherNet_u(double minOtherNet_u) {
        MinOtherNet_u = minOtherNet_u;
    }

    public double getMinOtherCountries_l() {
        return MinOtherCountries_l;
    }

    public void setMinOtherCountries_l(double minOtherCountries_l) {
        MinOtherCountries_l = minOtherCountries_l;
    }

    public double getMinOtherCountries_u() {
        return MinOtherCountries_u;
    }

    public void setMinOtherCountries_u(double minOtherCountries_u) {
        MinOtherCountries_u = minOtherCountries_u;
    }

    public double getMobileInternet_l() {
        return mobileInternet_l;
    }

    public void setMobileInternet_l(double mobileInternet_l) {
        this.mobileInternet_l = mobileInternet_l;
    }

    public double getMobileInternet_u() {
        return mobileInternet_u;
    }

    public void setMobileInternet_u(double mobileInternet_u) {
        this.mobileInternet_u = mobileInternet_u;
    }
}
