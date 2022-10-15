package hileta.com.network;

public class Customer {
    String name;
    String CustomerID;

    public Customer(String name, String CustomerID) {
        this.name = name;
        this.CustomerID = CustomerID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerID(String customerID) {
        this.CustomerID = customerID;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", ID: " + this.CustomerID;
    }
}
