package be.jochenhansoul.bank;

public class Address {
    private String street;
    private int number;
    private String numberAddition;
    private int postalcode;
    private String city;
    private String country;

    public Address(
        String street,
        int number,
        String numberAddition,
        int postalcode,
        String city,
        String country) {
        
        this.street = street;
        this.number = number;
        this.numberAddition = numberAddition;
        this.postalcode = postalcode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return this.street;
    }

    public int getnumber() {
        return this.number;
    }

    public String getnumberAddition() {
        return this.numberAddition;
    }

    public int getPostalcode() {
        return this.postalcode;
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
            + " " + this.postalcode + " " + this.city + " " + this.country;
    }
}
