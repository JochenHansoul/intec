package be.jochenhansoul.bank;

public class Person {
    private String firstName;
    private String lastName;
    private Address address;
    private ContactInfo[] contactNumbers;

    public Person(
        String firstname,
        String lastName,
        Address address,
        ContactInfo[] contactNumbers) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.contactNumbers = contactNumbers;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Address getAddress() {
        return this.address;
    }

    public ContactInfo[] getPhoneNumbers() {
        return this.contactNumbers;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }
}
