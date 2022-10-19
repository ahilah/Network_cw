package hileta.com.network;

public class Abroad {

    private String country;
    private double pricePerMinute;

    public Abroad(String country, double pricePerMinute) {
        this.country = country;
        this.pricePerMinute = pricePerMinute;
    }

    public String getCountry() {
        return country;
    }

    public double getPricePerMinute() {
        return pricePerMinute;
    }

    @Override
    public String toString() {
        return "Country: " + this.country + ", price per minute: " + this.pricePerMinute;
    }
}

