package models.util;

public class Invoice {
    private  int id;
    private String customer;
    private double value;
    private String number;

    public int getId() {
        return id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Invoice(String customer, Double value, String number, String description) {
        this.customer = customer;
        this.value = value;
        this.number = number;
    }
}
