package hileta.com.network;

public class Abroad {

    private String country;
    private double pricePerMinute;

    public Abroad(String country, double pricePerMinute) {
        this.country = country;
        this.pricePerMinute = pricePerMinute;
    }

    public String toString() {
        return "Abroad{country='" + this.country + "', pricePerMinute=" + this.pricePerMinute + "}";
    }
}

