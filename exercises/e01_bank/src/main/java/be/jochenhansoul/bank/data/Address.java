package be.jochenhansoul.bank.data;

public class Address {
    private String street;
    private int number;
    private String numberAddition;
    private int postalCode; // sommige landen gebruiken letters in hun postcode
    private String city;
    private String country;

    public Address(
        String street,
        int number,
        String numberAddition,
        int postalCode,
        String city,
        String country) {
        
        this.street = street;
        this.number = number;
        this.numberAddition = numberAddition;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setNumberAddition(String numberAddition) {
        this.numberAddition = numberAddition;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return this.street;
    }

    public int getNumber() {
        return this.number;
    }

    public String getNumberAddition() {
        return this.numberAddition;
    }

    public int getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        return this.number + " " + this.numberAddition + " " + this.street
            + " " + this.postalCode + " " + this.city + " " + this.country;
    }
}
